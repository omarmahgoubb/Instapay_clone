public interface TransactionStrategy
{
    void transferToWallet(InstaPayAccount sourceUser, InstaPayAccount destinationUser, float amount);
    void transferToInstaPayAccount(InstaPayAccount sourceUser, InstaPayAccount destinationUser, float amount);
    void transferToBankAccount(InstaPayAccount sourceUser, InstaPayAccount destinationUser, float amount);
    boolean checkTransferToBankAccount(InstaPayAccount sourceUser, float amount);
    boolean checkBalance(InstaPayAccount sourceUser, float amount);
}
