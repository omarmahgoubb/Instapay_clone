public class WalletTransferStrategy implements TransferStrategy
{
    @Override
    public void transfer(User sender, String recipientPhoneNumber, float amount) {

            for (User user : InstaPayAccount.users)
            {
                if (user.getPhoneNumber().equals(recipientPhoneNumber))
                {
                    sender.setBalance(sender.getBalance() - amount);
                    System.out.println("Transferred $" + amount + " to Wallet: " + recipientPhoneNumber);
                    System.out.println("Remaining balance: $" + sender.getBalance());
                    return;
                }
            }
            System.out.println("Recipient wallet not found.");
        }
        }
