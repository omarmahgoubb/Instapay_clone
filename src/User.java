import java.util.Scanner;

public class User
{
    private final String userName;
    private final String password;
    Scanner scanner = new Scanner(System.in) ;
    String phone ;
    String type ;
    String UserName ;
    String Password ;
    String bankAccount ;
    private final String phoneNumber;
    float Balance ;

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
        phone = scanner.nextLine().toLowerCase();
        System.out.println("Enter either bankAccount or wallet: ");
        type = scanner.nextLine().toLowerCase();
        /*
        bool isverfied = verify(bankAccount,phoneNumber,type);
        if(isverfied)
        {
        private void addUser(String bankAccount, String phoneNumber) {
         InstaPayAccount account = new InstaPayAccount(bankAccount , phone , type) ;
         account.adduser(bankAccount , phoneNumber , type );
    }
        */
        return true ;
    }


}
