import java.util.Scanner;

public class User {
    private BankValidation validation1 = new BankValidation();
    private WalletValidation validation2 = new WalletValidation();
    private Scanner scanner = new Scanner(System.in);
    private String type;
    private String userName;
    private String password;
    private String bankAccount;
    private String phoneNumber;
    private String walletType;
    private float balance;

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

    public User(String userName, String password, String bankAccount, String phoneNumber, String type) {
        this.userName = userName;
        this.password = password;
        this.bankAccount = bankAccount;
        this.phoneNumber = phoneNumber;
        if ("bankAccount".equals(type)) {
            InstaPayAccount account = new InstaPayAccount(bankAccount, phoneNumber, type);
            account.addUser(this);
        } else if ("wallet".equals(type)) {
            InstaPayAccount account = new InstaPayAccount(null, phoneNumber, type);
            account.addUser(this);
        }
    }


    public boolean register() {
        System.out.println("Enter your bank account number: ");
        bankAccount = scanner.nextLine().toLowerCase();
        System.out.println("Enter your phone number: ");
        phoneNumber = scanner.nextLine().toLowerCase();
        System.out.println("Enter either bankAccount or wallet: ");
        type = scanner.nextLine().toLowerCase();

        if ("wallet".equals(type)) {
            System.out.println("What is the type of your wallet?");
            walletType = scanner.nextLine().toLowerCase();
        }

        System.out.println("Enter your balance: ");
        balance = scanner.nextFloat();

        boolean isVerified = validation1.verificationOfBank(bankAccount, phoneNumber);

        if (isVerified) {
            addUserToInstaPay(bankAccount, phoneNumber, type);
            return true;
        }

        return false;
    }

    private void addUserToInstaPay(String bankAccount, String phoneNumber, String type) {
        InstaPayAccount account = new InstaPayAccount(bankAccount, phoneNumber, type);
        account.addUser(bankAccount, phoneNumber, type, userName, password, balance);
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public float getBalance() {
        return balance;
    }

    public void transferToWallet(InstaPayAccount instaPayAccount, String recipientPhoneNumber, float amount) {
        instaPayAccount.transferToWallet(this, recipientPhoneNumber, amount);
    }

    public void transferToInstaPayAccount(InstaPayAccount instaPayAccount, String recipientUsername, float amount) {
        instaPayAccount.transferToInstaPayAccount(this, recipientUsername, amount);
    }


}
