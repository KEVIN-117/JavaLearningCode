package N_26_Sockets.Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerClient extends Thread {
    private Socket client;
    private Server server;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    private Boolean isConnect;
    private EventForJoinRoom eventForJoinRoom;
    private String room;


    public ServerClient(Socket client, Server server) {
        this.client = client;
        this.server = server;
        this.isConnect = true;
        this.room = "";
        try {
            this.outputStream = new ObjectOutputStream(this.client.getOutputStream());
            this.inputStream = new ObjectInputStream(this.client.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void close(){
        try {
            this.client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addEventJoinRoom(EventForJoinRoom event){
        this.eventForJoinRoom = event;
    }

    public void emmit(User msg){
        try {
            this.outputStream.writeObject(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
        while (this.isConnect){
            try {
                User user = (User) inputStream.readObject();
                if (user.getMsg().equals("1n1t 535510n")){
                    User response = new User("Server", "welcome to chat" + user.getName());
                    this.outputStream.writeObject(response);
                } else if (user.getMsg().equals(":qu1t")) {
                    this.isConnect = false;
                } else if (user.getMsg().contains(":jo1n")) {
                    String[] command = user.getMsg().split(" ");
                    if (command.length == 2){
                        this.room = command[1];
                        this.eventForJoinRoom.join(this, command[1]);
                    }
                } else if (this.room.equals("")) {
                    User response = new User("Server", user.getName()+" You are not connected to a room use the Command :join <ROOM> to join a room");
                    this.outputStream.writeObject(response);
                }else {
                    this.server.emmitMEsages(this.room, user);
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        close();
    }
}
