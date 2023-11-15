public class InstaPayTransferStrategy implements TransferStrategy
{
    @Override
    public void transfer(User sender, String recipientUsername, float amount) {
        InstaPayAccount instaPayAccount = InstaPayAccount.getInstance();
        User recipient = instaPayAccount.getUserByUsername(recipientUsername);

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
                System.out.println("Transferring to an InstaPay account is only valid for users registered with InstaPay.");
            }

        }
    }
