import java.util.ArrayList;
import java.util.Scanner;

public class InstaPayAccount {
    Scanner scanner = new Scanner(System.in) ;
    ArrayList <User> users = new ArrayList<>();
    float Balance ;

    public InstaPayAccount(String bankAccount, String phoneNumber, String type) {
    }

    public void addUser(String bankAccount, String phoneNumber , String type) {
        if (type == "bankAccount") {
            if (!userExists(bankAccount, phoneNumber)) {
                System.out.println("Enter a distinct username: ");
                String userName = scanner.nextLine();
                for (User user : users) {
                    if (user.userName == userName) {
                        System.out.println("this username already exists , please enter another a distinct username");
                    }

                }

                System.out.println("Enter a complex password: ");
                String password = scanner.nextLine();
                users.add(new BankUser(userName, password, bankAccount, phoneNumber, type));

                System.out.println("User added successfully!");
            } else {
                System.out.println("User already exists.");
            }
        }
        else if (type == "wallet")
        {
            if (!userExists(phoneNumber)) {
                System.out.println("Enter a distinct username: ");
                String userName = scanner.nextLine();
                for (User user : users) {
                    if (user.userName == userName) {
                        System.out.println("this username already exists , please enter another a distinct username");
                    }

                }

                System.out.println("Enter a complex password: ");
                String password = scanner.nextLine();
                users.add(new WalletUser(userName, password, bankAccount, phoneNumber, type));

                System.out.println("User added successfully!");
            } else {
                System.out.println("User already exists.");
            }
        }
    }
    private boolean userExists(String BankAccount, String phone) {
        for (User user : users) {
            if (user.bankAccount.equals(BankAccount) && user.phoneNumber.equals(phone)) {
                return true;
            }
        }
        return false;
    }
    private boolean userExists(String phone) {
        for (User user : users) {
            if (user.phoneNumber.equals(phone)) {
                return true;
            }
        }
        return false;
    }
}




