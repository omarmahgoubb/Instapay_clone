public class BankAccountTransferStrategy implements TransactionStrategy {
    @Override
    public void transferToWallet(InstaPayAccount sourceUser, InstaPayAccount destinationUser, float amount) {
        // Implement the logic for transferring to a wallet
    }

    @Override
    public void transferToInstaPayAccount(InstaPayAccount sourceUser, InstaPayAccount destinationUser, float amount) {
        // Implement the logic for transferring to an InstaPay account
    }

    @Override
    public void transferToBankAccount(InstaPayAccount sourceUser, InstaPayAccount destinationUser, float amount) {
        // Implement the logic for transferring to a bank account
    }

    @Override
    public boolean checkTransferToBankAccount(InstaPayAccount sourceUser, float amount) {
        // Implement the logic for checking if transfer to bank account is valid
        return true; // Replace with actual logic
    }

    @Override
    public boolean checkBalance(InstaPayAccount sourceUser, float amount) {
        // Implement the logic for checking if the balance is sufficient
        return true; // Replace with actual logic
    }
}
