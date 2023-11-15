public class WaterBill extends Bill{
    public String connectionNumber;
    private int receiptAmount = 700;
    public WaterBill(String connectionNumber, double receipt)
    {
        super("Water");
        this.connectionNumber = connectionNumber;
    }
    public String getConnectionNumber()
    {
        return connectionNumber;
    }

    public int getReceiptAmount() {
        return receiptAmount;
    }

    @Override
    public void deductBillFromAccount(UserAccount userAccount) {
        userAccount.deductFromBalance(getReceiptAmount());
        System.out.println("Remaining balance: "+userAccount.getBalance());
    }
}
