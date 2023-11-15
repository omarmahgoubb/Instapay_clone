public class BillPayment
{
    public void payBill(Bill bill, User user) {
        if ("bankAccount".equals(user.type)) {
            System.out.println("Paying the " + bill.getBillType() + " from your bank account");
            if (user.hasSufficientBalance(bill.getReceiptAmount())) {
                user.deductFromBalance(bill.getReceiptAmount());
                System.out.println("Bill paid successfully.");
            } else {
                System.out.println("Your balance isn't enough to pay the bill.");
            }
        } else if ("wallet".equals(user.type)) {
            System.out.println("Paying the " + bill.getBillType() + " from your wallet account");
            if (user.hasSufficientBalance(bill.getReceiptAmount())) {
                user.deductFromBalance(bill.getReceiptAmount());
                System.out.println("Bill paid successfully.");
            } else {
                System.out.println("Your balance isn't enough to pay the bill.");
            }
        } else {
            System.out.println("Error: Cannot pay the bill. It isn't a valid account.");
        }
    }
}
