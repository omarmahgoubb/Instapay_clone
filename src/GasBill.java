public class GasBill extends Bill{
    public int gasConnectionNumber = 200 ;
    private int receiptAmount = 150;
    public GasBill(int gasConnectionNumber)
    {
        super("Gas");
    }
    public int getGasConnectionNumber()
    {
        return gasConnectionNumber;
    }

    public int getReceiptAmount()
    {
        return receiptAmount;
    }

    @Override
    public void deductBillFromAccount(UserAccount userAccount) {
        userAccount.deductFromBalance(getReceiptAmount() );
        System.out.println("Remaining balance "+ userAccount.getBalance());
    }
}
