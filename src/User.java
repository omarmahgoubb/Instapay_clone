import java.util.Scanner;

public class User {
    BankValidation validation1 = new BankValidation() ;
    WalletValidation validation2 = new WalletValidation() ;
    Scanner scanner = new Scanner(System.in) ;
    String type ;
    String userName ;
    String password ;
    String bankAccount ;
    String phoneNumber;
    String walletType;
    float balance ;

    public User(String userName, String password, String bankAccount, String phoneNumber ,String type) {
        this.userName = userName;
        this.password = password;
        this.bankAccount = bankAccount;
        this.phoneNumber = phoneNumber;
    }


    boolean Register ()
    {

        System.out.println("Enter your bank account number: ");
        bankAccount = scanner.nextLine().toLowerCase();
        System.out.println("Enter your phone number: ");
        phoneNumber = scanner.nextLine().toLowerCase();
        System.out.println("Enter either bankAccount or wallet: ");
        type = scanner.nextLine().toLowerCase();
        if (type == "wallet")
        {
            System.out.println("what is the type of your wallet ");
            walletType = scanner.nextLine().toLowerCase() ;

        }
        System.out.println("Enter your balance ");
        balance = scanner.nextFloat();

        boolean isVerified = validation1.verificationOfBank(bankAccount, phoneNumber);

        if (isVerified) {
            addUserToInstaPay(bankAccount, phoneNumber, type);
            return true;
        }

        return true ;

    }
    private void addUserToInstaPay(String bankAccount, String phoneNumber, String type) {
        InstaPayAccount account = new InstaPayAccount(bankAccount, phoneNumber, type);
        account.addUser(bankAccount, phoneNumber, type);
    }
    public void setBalance(float balance) {
        this.balance = balance;
    }
    public float getBalance() {
        return balance;
    }
}


