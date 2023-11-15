import java.util.Scanner;

public class User {
    BankValidation validation1 = new BankValidation() ;
    WalletValidation validation2 = new WalletValidation() ;
    Scanner scanner = new Scanner(System.in) ;
    String type ;
    int accountype ;
    String userName ;
    String password ;
    String bankAccount ;
    String phoneNumber;
    String walletType;
    float balance ;

    User(){};
    public User(String userName, String password, String bankAccount, String phoneNumber, String type, float balance) {
        this.userName = userName;
        this.password = password;
        this.bankAccount = bankAccount;
        this.phoneNumber = phoneNumber;
        this.type = type;
        this.balance = balance;
    }


    public String getUserName() {
        return userName;
    }
    public String getBankAccount() {
        return bankAccount;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
    public float getBalance() {
        return balance;
    }

    public void deductFromBalance(double amount) {
        balance -= amount;
    }

    public boolean hasSufficientBalance(double amount) {
        return balance >= amount;
    }



    public void setUser(String userName, String password, String bankAccount, String phoneNumber ,String type) {
        this.userName = userName;
        this.password = password;
        this.bankAccount = bankAccount;
        this.phoneNumber = phoneNumber;
    }


    boolean Register() {
        System.out.println("Enter your phone number: ");
        phoneNumber = scanner.nextLine().toLowerCase();
        System.out.println("Enter either 1 for bankAccount or 2 for wallet ");
        accountype = scanner.nextInt();
        scanner.nextLine();

        if (accountype == 2) {
            type = "wallet";
            System.out.println("What is the type of your wallet? vodafone / cib / fawry");
            walletType = scanner.nextLine().toLowerCase();
            boolean isVerified = validation2.verificationWallet(walletType, phoneNumber);

            if (isVerified) {
                addUserToInstaPay(null, phoneNumber, type , balance);
                return true;
            }
        } else {
            type = "bankAccount";
            System.out.println("Enter your bank account number: ");
            bankAccount = scanner.nextLine();
            System.out.println("Enter your balance ");
            balance = scanner.nextFloat();
            scanner.nextLine();

            boolean isVerified = validation1.verificationOfBank(bankAccount, phoneNumber);

            if (isVerified) {
                addUserToInstaPay(bankAccount, phoneNumber, type , balance);
                return true;
            }
        }

        return false;
    }

    private void addUserToInstaPay(String bankAccount, String phoneNumber, String type, float balance) {
        InstaPayAccount account = InstaPayAccount.getInstance();
        account.addUser(bankAccount, phoneNumber, type , this.balance);
    }

}


