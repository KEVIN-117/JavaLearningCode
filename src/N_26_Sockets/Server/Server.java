package N_26_Sockets.Server;

import N_26_Sockets.StartEvent;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Server implements Runnable, StartEvent {
    private Integer port;
    private ServerSocket server;
    private Boolean isRunning;
    private Thread thread;
    private HashMap<String, ArrayList<ServerClient>> rooms;

    public Server(Integer port) {
        this.port = port;
        this.isRunning = false;
        this.rooms = new HashMap<>();
    }

    @Override
    public  void start(){
        try {
            this.server = new ServerSocket(this.port);
            System.out.println("Server is running in port :" + this.server.getLocalPort());

            this.isRunning = true;
            this.thread = new Thread(this);
            this.thread.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void emmitMEsages(String roomName, User sendUserData){
        ArrayList<ServerClient> room = this.rooms.get(roomName);
        for (int i = 0; i < room.size(); i++) {
            room.get(i).emmit(sendUserData);
        }
    }
    @Override
    public void run() {
        while(this.isRunning){
            try {
                Socket clientSocket = this.server.accept();
                ServerClient serverClient = new ServerClient(clientSocket, this);
                serverClient.start();

                serverClient.addEventJoinRoom((ServerClient user, String roomName) -> {
                    ArrayList<ServerClient> room = this.rooms.get(roomName);
                    if (room == null) {
                        room = new ArrayList<>();
                    }
                    room.add(user);
                    this.rooms.put(roomName, room);
                });
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void stop(){
        try {
            this.isRunning = false;
            this.thread.stop();
            this.server.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
