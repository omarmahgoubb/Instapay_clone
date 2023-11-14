abstract class Bill {
    public String billType;
    public double receipt;
    public Bill(String billType,double receipt)
    {
        this.billType = billType;
        this.receipt = receipt;
    }
    public String getBillType()
    {
        return billType;
    }
    public double getReceipt()
    {
        return receipt;
    }
    public abstract void deductBillFromAccount(UserAccount userAccount);
}



