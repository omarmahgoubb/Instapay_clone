import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in) ;
        User user = new User();
        InstaPayAccount instaPayAccount = InstaPayAccount.getInstance() ;
        int command ;
        boolean flag = true;
        while (flag) {
            System.out.println("enter 1 for sign up  / enter  2 for signing in / 3 for exit");
            command = scanner.nextInt();
            if (command == 1) {
                user.Register();

                /*if (user.Register()) {
                    scanner.nextLine();
                    System.out.println("sign in to your account");
                    System.out.println("enter your username ");
                    String username = scanner.nextLine();
                    System.out.println("enter your password ");
                    String password = scanner.nextLine();
                    user = instaPayAccount.login(username, password);
                    String recivername;
                    float amount;
                    scanner.nextLine();
                    System.out.println("enter the reciever name");
                    recivername = scanner.nextLine();
                    System.out.println("enter the amount ");
                    amount = scanner.nextFloat();
                    instaPayAccount.transferToInstaPayAccount(user, recivername, amount);*/
            }
            else if (command == 2) {
                System.out.println("enter your username ");
                String username = scanner.nextLine();
                System.out.println("enter your password ");
                String password = scanner.nextLine();
                instaPayAccount.login(username, password);

            } else if (command == 3) {
                flag = false;
            }
        }


    }
}