public class UserAccount {
    private boolean hasBankAccount;
    private boolean hasWalletAccount;
    private String accountNumber;
    private double balance;
    public  UserAccount(String accountNumber,boolean hasBankAccount,boolean hasWalletAccount, double balance)
    {
        this.accountNumber = accountNumber;
        this.hasBankAccount = hasBankAccount;
        this.hasWalletAccount = hasBankAccount;
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
    public boolean hasSufficientBalance(double amount)
    {
        return balance >= amount;
    }

    public boolean HasBankAccount()
    {
        return hasBankAccount;
    }

    public boolean HasWalletAccount()
    {
        return hasWalletAccount;
    }
}
