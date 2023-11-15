abstract class Bill
{
    private String billType;
    public Bill(String billType)
    {
        this.billType = billType;
    }
    public String getBillType()
    {
        return billType;
    }
    public abstract int getReceiptAmount();

    public abstract void deductBillFromAccount(UserAccount userAccount);
}

