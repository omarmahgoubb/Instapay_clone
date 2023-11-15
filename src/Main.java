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
                instaPayAccount.login(username, password);
                int command2=0;
             System.out.println("1:Transfer to Wallet , 2:Transfer to Another instapay account , 3:Inquire about his balance");
                switch (command2)
                {
                    case 1:
                        instaPayAccount.login(username, password);
                        String receivername;
                        float amount;
                        scanner.nextLine();
                        System.out.println("enter the reciever name");
                        receivername = scanner.nextLine();
                        System.out.println("enter the amount ");
                        amount = scanner.nextFloat();
                        instaPayAccount.transfer(user, receivername, amount);
                        break;
                    case 2:
                        instaPayAccount.login(username, password);
                        String receiver="";
                        float Amount=0;
                        scanner.nextLine();
                        System.out.println("enter the reciever ");
                        receiver= scanner.nextLine();
                        System.out.println("enter the amount ");
                        Amount = scanner.nextFloat();
                        instaPayAccount.transfer(user, receiver, Amount);
                        break;
                    case 3:
                        instaPayAccount.inquireBalance();
                    

                }


            } else if (command == 3)
            {
                flag = false;
            }
        }
    }
}