package N_26_Sockets.Exampple;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ChatServer {
    private ServerSocket serverSocket;
    private List<ClientHandler> clients;

    public ChatServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            clients = new ArrayList<>();
            System.out.println("Server started on port " + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clients.add(clientHandler);
                clientHandler.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class ClientHandler extends Thread {
        private Socket clientSocket;
        private ObjectInputStream inputStream;
        private ObjectOutputStream outputStream;
        private String clientName;

        public ClientHandler(Socket clientSocket) {

            this.clientSocket = clientSocket;
            try {
                this.outputStream = new ObjectOutputStream(this.clientSocket.getOutputStream());
                this.inputStream = new ObjectInputStream(this.clientSocket.getInputStream());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void run() {
            try {
                ClientData clientData = (ClientData) inputStream.readObject();


                // Informar a todos los clientes conectados sobre la nueva conexión
                broadcastMessage(clientName + " se ha unido al chat.");

                // Leer y reenviar mensajes
                while (true) {
                    //String message = readMessage();
                    if (Objects.equals(clientData.getMsg(), "exit")) {
                        break;
                    }
                    broadcastMessage( (clientData.getGender().toString().equalsIgnoreCase("female"))? FontColors.pink+clientData.getName() : FontColors.azul+clientData.getName() + " envio: \n" + clientData.getMsg());
                }

                // Informar a todos los clientes sobre la desconexión
                broadcastMessage((clientData.getGender().toString().equalsIgnoreCase("female"))? FontColors.pink+clientData.getName() : FontColors.azul+clientData.getName()  + " se ha desconectado.");

                // Cerrar conexiones y eliminar el cliente de la lista
                inputStream.close();
                outputStream.close();
                clientSocket.close();
                clients.remove(this);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        private String getClientName() throws IOException {
            byte[] buffer = new byte[256];
            int bytesRead = inputStream.read(buffer);
            return new String(buffer, 0, bytesRead).trim();
        }

        private String readMessage() throws IOException {
            byte[] buffer = new byte[256];
            int bytesRead = inputStream.read(buffer);
            if (bytesRead == -1) {
                return null;
            }
            return new String(buffer, 0, bytesRead).trim();
        }

        private void broadcastMessage(String message) throws IOException {

            for (ClientHandler client : clients) {
                client.sendMessage(message);
            }
        }

        private void sendMessage(String data) throws IOException {
            outputStream.write(data.getBytes());
            outputStream.flush();
        }
        private void sendMessage(ClientData data) throws IOException {
            outputStream.writeObject(data);
            //outputStream.flush();
        }
    }

    public static void main(String[] args) {
        ChatServer server = new ChatServer(5000);
        server.start();
    }
}
