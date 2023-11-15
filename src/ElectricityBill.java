public class ElectricityBill extends Bill{
    public String electricMeter;
    private int receiptAmount = 500;
    public  ElectricityBill(String electricMeter, double receipt)
    {
        super("Electricity");
        this.electricMeter = electricMeter;
    }

    public int getReceiptAmount() {
        return receiptAmount;
    }

    @Override
    public void deductBillFromAccount(UserAccount userAccount) {
        userAccount.deductFromBalance( getReceiptAmount());
        System.out.println("Remaining balance: "+ userAccount.getBalance());
    }
}
