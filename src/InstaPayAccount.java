import java.util.ArrayList;
import java.util.Scanner;

public class InstaPayAccount
{
    Scanner scanner = new Scanner(System.in) ;
    ArrayList <User> users = new ArrayList<>();
     float Balance ;

    public void addUser(String bankAccount, String phoneNumber , String type) {

        if (!userExists(bankAccount, phoneNumber)) {
            System.out.println("Enter a distinct username: ");
            String userName = scanner.nextLine();
            for (User user : users) {
                if (user.UserName.equals(userName))
                {
                    System.out.println("this username already exists , please enter another a distinct username");
                }

                }

            System.out.println("Enter a complex password: ");
            String password = scanner.nextLine();


            users.add(new User(userName, password, bankAccount, phoneNumber , type));

            System.out.println("User added successfully!");
        } else {
            System.out.println("User already exists.");
        }
    }
    private boolean userExists(String bankAccount, String phoneNumber) {
        for (User user : users) {
            if (user.bankAccount.equals(bankAccount) && user.phone.equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }
    }




