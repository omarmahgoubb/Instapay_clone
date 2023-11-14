public class ElectricityBill  extends Bill{
    public String electricMeter;
    public  ElectricityBill(String electricMeter, double receipt)
    {
        super("Electricity", receipt);
        this.electricMeter = electricMeter;
    }

    @Override
    public void deductBillFromAccount(UserAccount userAccount) {
        userAccount.deductFromBalance(getReceipt());
        System.out.println("Remaining balance: "+ userAccount.getBalance());
    }
}


