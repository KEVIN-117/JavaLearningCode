package N_26_Sockets.Exampple;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;
    private Scanner scanner;

    public ChatClient(String serverAddress, int port) {
        try {
            socket = new Socket(serverAddress, port);
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            scanner = new Scanner(System.in);
            System.out.print("Ingrese su nombre: ");
            String clientName = scanner.nextLine();
            outputStream.write(clientName.getBytes());
            // forzara la escritura de todos los datos almacenados en el búfer de salida del flujo de salida.
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        Thread readThread = new Thread(() -> {
            try {
                while (true) {
                    String message = readMessage();
                    if (message == null) {
                        break;
                    }
                    System.out.println(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Thread writeThread = new Thread(() -> {
            try {
                while (true) {
                    String message = scanner.nextLine();
                    sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        readThread.start();
        writeThread.start();
    }

    private String readMessage() throws IOException {
        byte[] buffer = new byte[256];
        int bytesRead = inputStream.read(buffer);
        if (bytesRead == -1) {
            return null;
        }
        return new String(buffer, 0, bytesRead).trim();
    }

    private void sendMessage(String message) throws IOException {
        outputStream.write(message.getBytes());
        outputStream.flush();
    }

    public static void main(String[] args) {
        ChatClient client = new ChatClient("localhost", 5000);
        client.start();
    }
}