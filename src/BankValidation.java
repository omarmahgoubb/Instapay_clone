
public class BankValidation extends Validation{
    private String[] bankNumber = {"99999","11111","22222"};
    private String[] bankMobileNumber = {"01030","01250","01560"};


    public boolean verifyBankMobileNumber (String num)
    {
        for (String number : bankMobileNumber)
        {
            if (num.equals(num) )
            {
                System.out.println("Mobile Bank number is verified ");
                return true;
            }
        }
        System.out.println("Mobile bank number is not verified !! ");
        return false ;
    }

    

    public boolean verifyBankNumber(String banknum)
    {
        for (String num : bankNumber)
        {
            if (num.equals(banknum) )
            {
                System.out.println("bank number is verified ");
                return true;
            }
        }
        System.out.println("bank number not verified !! ");
        return false ;

    }




    public boolean verificationOfBank (String Banknumber , String BankMobileNumber)
    {
        if (verifyBankNumber(Banknumber) && verifyBankMobileNumber(BankMobileNumber) && otpVerification())
        {
            System.out.println(" ");
            System.out.println("Bank account verified succefully !!");
            System.out.println(" ");
            return true;
        }

        else
            return false;



    }





    }



