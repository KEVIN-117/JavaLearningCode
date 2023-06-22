package N_26_Sockets.Client;


import N_26_Sockets.StartEvent;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client implements Runnable, StartEvent {
    private Integer port;
    private String host;
    private Socket client;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    private Boolean isRunning;
    private OnServerReponse response;
    private Thread thread;

    public Client(Integer port, String host) {
        this.port = port;
        this.host = host;
        this.isRunning = false;
    }


    @Override
    public void start(){
        try {
            this.client = new Socket(this.host, this.port);
            this.outputStream = new ObjectOutputStream(this.client.getOutputStream());
            this.inputStream = new ObjectInputStream(this.client.getInputStream());
            this.isRunning = true;
            this.thread = new Thread(this);
            this.thread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop(){
        try {
            this.client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onResponse(OnServerReponse response){

        this.response = response;
    }
    public void emmit(User user){
        try {
            this.outputStream.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (this.isRunning){
            try {
                User res = (User) this.inputStream.readObject();
                this.response.onResponse(res);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
