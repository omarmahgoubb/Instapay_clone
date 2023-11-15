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

    public BankValidation getValidation1() {
        return validation1;
    }

    public void setValidation1(BankValidation validation1) {
        this.validation1 = validation1;
    }

    public WalletValidation getValidation2() {
        return validation2;
    }

    public void setValidation2(WalletValidation validation2) {
        this.validation2 = validation2;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWalletType() {
        return walletType;
    }

    public void setWalletType(String walletType) {
        this.walletType = walletType;
    }


    public void setBalance(float balance) {
        this.balance = balance;
    }
    public float getBalance() {
        return balance;
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
        scanner.nextLine(); // Consume the newline character

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
            type = "bankaccount";
            System.out.println("Enter your bank account number: ");
            bankAccount = scanner.nextLine();
            System.out.println("Enter your balance ");
            balance = scanner.nextFloat();
            scanner.nextLine(); // Consume the newline character

            boolean isVerified = validation1.verificationOfBank(bankAccount, phoneNumber);

            if (isVerified) {
                addUserToInstaPay(bankAccount, phoneNumber, type , balance);
                return true;
            }
        }

        return false;
    }

    private void addUserToInstaPay(String bankAccount, String phoneNumber, String type, float balance) {
        InstaPayAccount account = new InstaPayAccount(bankAccount, phoneNumber, type);
        account.addUser(bankAccount, phoneNumber, type , this.balance);
    }

}


