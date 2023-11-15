public class BillPayment {
    public void payBill(Bill bill,UserAccount userAccount)
    {
        if (userAccount.HasBankAccount())
        {
            System.out.println("Paying the "+ bill.getBillType() + "from your bank account");
            if(userAccount.hasSufficientBalance(bill.getReceiptAmount()))
            {
                userAccount.deductFromBalance(bill.getReceiptAmount());
                System.out.println("Bill paid successfully.");
            }
            else
            {
                System.out.println("Your balance isn't enough to pay the bill.");
            }
        }
        else if (userAccount.HasWalletAccount())
        {
            System.out.println("Paying the" + bill.getBillType() + "from your wallet account");
            if(userAccount.hasSufficientBalance(bill.getReceiptAmount()))
            {
                userAccount.deductFromBalance(bill.getReceiptAmount());
                System.out.println("Bill paid successfully.");
            }
            else
            {
                System.out.println("Your balance isn't enough to pay the bill.");
            }
        }
        else
        {
            System.out.println("Error to pay the bill, it isn't a valid account.");
        }
    }
}
