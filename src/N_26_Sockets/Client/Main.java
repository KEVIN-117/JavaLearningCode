package N_26_Sockets.Client;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("write your name:");
        String name = scanner.nextLine();

        Client client = new Client(3000, "127.0.0.1");
        client.start();
        client.onResponse((response) -> {
            System.out.println(response.getName() + " <==> " + response.getDate() + "\n"+response.getMsg());
        });

        User user = new User(name, "1n1t 535510n");
        client.emmit(user);

        while(true){
            String msg = scanner.nextLine();
            User user1 = new User(name, msg);
            client.emmit(user1);
        }

    }
}
