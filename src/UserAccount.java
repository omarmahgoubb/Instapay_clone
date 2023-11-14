public class UserAccount {
    private String accountNumber;
    private double balance;
    public  UserAccount(String accountNumber, double balance)
    {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public String getAccountNumber()
    {
        return accountNumber;
    }
    public double getBalance()
    {
        return balance;
    }
    public void deductFromBalance(double amount)
    {
        balance -= amount;
    }
}


