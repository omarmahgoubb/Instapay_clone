import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in) ;
        User user = new User();
        InstaPayAccount instaPayAccount = new InstaPayAccount(null , null , null);
        int command ;
        System.out.println("enter 1 for sign up  / enter  2 for signing in ");
        command = scanner.nextInt();
        if (command == 1)
        {
            user.Register();
        }
        else if (command == 2)
        {
            System.out.println("enter your username ");
            String username = scanner.nextLine();
            System.out.println("enter your password ");
            String password = scanner.nextLine();
            instaPayAccount.login(username,password) ;

        }


    }
}