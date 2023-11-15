import java.util.ArrayList;
import java.util.Scanner;

public class InstaPayAccount {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<User> users = new ArrayList<>();

    public InstaPayAccount(String bankAccount, String phoneNumber, String type) {
    }


    public void addUser(String bankAccount, String phoneNumber, String type, float balance) {
        if ("bankAccount".equals(type)) {
            if (!userExists(bankAccount, phoneNumber)) {
                System.out.println("Enter a distinct username: ");
                String userName = scanner.nextLine();
                if (!isUsernameTaken(userName)) {
                    System.out.println("Enter a complex password: ");
                    String password = scanner.nextLine();
                    users.add(new BankUser(userName, password, bankAccount, phoneNumber, type, balance));
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


    public void transferToWallet(User sender, String recipientPhoneNumber, float amount) {
        if ("wallet".equals(sender.getType())) {
            for (User user : users) {
                if (user.getPhoneNumber().equals(recipientPhoneNumber)) {
                    sender.setBalance(sender.getBalance() - amount);
                    System.out.println("Transferred $" + amount + " to Wallet: " + recipientPhoneNumber);
                    System.out.println("Remaining balance: $" + sender.getBalance());
                    return;
                }
            }
            System.out.println("Recipient wallet not found.");
        } else {
            System.out.println("Transferring to a wallet is only valid for users registered with a wallet.");
        }
    }

    public void transferToInstaPayAccount(User sender, String recipientUsername, float amount) {
        User recipient = getUserByUsername(recipientUsername);

        if (recipient != null) {
            if (sender.getBalance() >= amount) {
                sender.setBalance(sender.getBalance() - amount);
                recipient.setBalance(recipient.getBalance() + amount);

                System.out.println("Transferred $" + amount + " to InstaPay account: " + recipientUsername);
                System.out.println("Remaining balance for " + sender.getUserName() + ": $" + sender.getBalance());
                System.out.println("New balance for " + recipient.getUserName() + ": $" + recipient.getBalance());
            } else {
                System.out.println("Insufficient balance for the transfer.");
            }
        } else {
            System.out.println("Recipient InstaPay account not found.");
        }
    }

    public void login(String username, String password) {
        for (User user : users) {
            if (user.userName.equals(username) && user.password.equals(password)) {
                System.out.println(user.userName);
                System.out.println(user.balance);
                System.out.println(user.type);
            }
            else
            {
                System.out.println("Wrong Email or Password");
            }
        }

    }
}
