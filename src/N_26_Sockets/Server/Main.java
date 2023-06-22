package N_26_Sockets.Server;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Server server = new Server(3000);
        server.start();
        Scanner scanner = new Scanner(System.in);
        while (true){
            if (scanner.nextLine().equals(":stop")){
                server.stop();
                break;
            }

        }
    }
}
