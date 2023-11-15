import java.util.ArrayList;
import java.util.Scanner;

public class InstaPayAccount {
    private static InstaPayAccount instance;
    public Scanner scanner = new Scanner(System.in);
    public static ArrayList<User> users = new ArrayList<>();

    private InstaPayAccount() {
    }

    public static InstaPayAccount getInstance() {
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


    private TransferStrategy transferStrategy;

    public void setTransferStrategy(TransferStrategy transferStrategy) {
        this.transferStrategy = transferStrategy;
    }

    public void transfer(User sender, String recipient, float amount) {
        if (transferStrategy != null) {
            transferStrategy.transfer(sender, recipient, amount);
        } else {
            System.out.println("Transfer strategy not set.");
        }
    }

    private User loggedInUser;

    public void login(String username, String password) {
        for (User user : users) {
            if (user.getUserName().equals(username) && user.password.equals(password)) {
                loggedInUser = user;
                System.out.println("Logged in as " + user.getUserName());
                return;
            }
        }
        System.out.println("Invalid username or password.");
    }
    public boolean isLoggedIn() {
        return loggedInUser != null;
    }
    public void inquireBalance()
    {
        if (isLoggedIn()) {
            System.out.println("Current balance for " + loggedInUser.getUserName() + ": $" + loggedInUser.getBalance());
        } else {
            System.out.println("User not logged in. Please log in first.");
        }
    }

}
