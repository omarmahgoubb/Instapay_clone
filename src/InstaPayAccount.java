import java.util.ArrayList;
import java.util.Scanner;

public class InstaPayAccount {
    private static InstaPayAccount instance;
    public Scanner scanner = new Scanner(System.in);
    public static ArrayList<User> users = new ArrayList<>();

    
    private InstaPayAccount() // Private constructor 
    { 
    }

    
    public static InstaPayAccount getInstance() // Static method  
    {
        if (instance == null) {
            instance = new InstaPayAccount();
        }
        return instance;
    }


    public InstaPayAccount(String bankAccount, String phoneNumber, String type) {
    }


    public void addUser(String bankAccount, String phoneNumber, String type , float balance) {
        if ("bankAccount".equals(type)) {
            if (!userExists(bankAccount, phoneNumber)) {
                System.out.println("Enter a distinct username: ");
                String userName = scanner.nextLine();
                if (!isUsernameTaken(userName)) {
                    System.out.println("Enter a complex password: ");
                    String password = scanner.nextLine();
                    User user1 = new BankUser(userName, password, bankAccount, phoneNumber, type, balance) ;
                    users.add(user1);
                    System.out.println("User added successfully!");
                } else {
                    System.out.println("This username already exists. Please enter another distinct username.");
                }
            } else {
                System.out.println("User already exists.");
            }
        } else if ("wallet".equals(type)) {
            if (!userExists(phoneNumber)) {
                System.out.println("Enter a distinct username: ");
                String userName = scanner.nextLine();
                if (!isUsernameTaken(userName)) {
                    System.out.println("Enter a complex password: ");
                    String password = scanner.nextLine();
                    users.add(new WalletUser(userName, password, bankAccount, phoneNumber, type, balance));
                    System.out.println("User added successfully!");
                } else {
                    System.out.println("This username already exists. Please enter another distinct username.");
                }
            } else {
                System.out.println("User already exists.");
            }
        }
    }

    private boolean userExists(String bankAccount, String phone) {
        for (User user : users) {
            if (user.getBankAccount().equals(bankAccount) && user.getPhoneNumber().equals(phone)) {
                return true;
            }
        }
        return false;
    }

    private boolean userExists(String phone) {
        for (User user : users) {
            if (user.getPhoneNumber().equals(phone)) {
                return true;
            }
        }
        return false;
    }

    private boolean isUsernameTaken(String userName) {
        for (User user : users) {
            if (user.getUserName().equals(userName)) {
                return true;
            }
        }
        return false;
    }

    public User getUserByUsername(String username) {
        for (User user : users) {
            if (user.getUserName().equals(username)) {
                return user;
            }
        }
        return null;
    }


    public User login(String username, String password) {
        for (User user : users) {
            if (user.userName != null && user.password != null) {
                if (user.userName.equals(username) && user.password.equals(password)) {
                    System.out.println("Login successful!");
                    System.out.println("Username: " + user.userName);
                    System.out.println("Balance: $" + user.balance);
                    System.out.println("Account Type: " + user.type);
                    return user;
                }
            } else {
                System.out.println("Invalid user credentials");
            }
        }

        System.out.println("Wrong Email or Password");
        return null;
    }

     // private TransferStrategy transferStrategy;
    

    
}
