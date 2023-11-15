

public class WalletValidation extends   Validation{

    private String[] vodafonemobilenumbers = { "01012345678" ,"01098765432"};
    private String[] cibMobileNumbers = {"1234" , "56789"};
    private String[] fawryMobileNumbers = {"1111","2222"} ;

    public boolean vodafoneMobileNumberVerify (String mobileNum )
    {
        for (String num : vodafonemobilenumbers)
        {
            if (num.equals(mobileNum) )
            {
                System.out.println("");
                System.out.println("mobile number is verified successfully in Vodafone ");
                return true;
            }
        }
        System.out.println("mobile number not verified in Vodafone");
        return false ;
    }
    public boolean cibMobileNumberVerify (String mobileNum )
    {
        for (String num : cibMobileNumbers)
        {
            if (num.equals(mobileNum) )
            {
                System.out.println("");
                System.out.println("mobile number is verified successfully in CIB ");
                return true;
            }
        }
        System.out.println("mobile number not verified");
        return false ;
    }

    public boolean fawryMobileVerify (String mobileNum )
    {
        for (String num : fawryMobileNumbers)
        {
            if (num.equals(mobileNum) )
            {
                System.out.println("");
                System.out.println("mobile number is verified successfully  in fawry ");
                return true;
            }
        }
        System.out.println("mobile number not verified");
        return false ;
    }

    public boolean mobileNumberVerify(String type , String number)
    {

        if (type == "vodafone")
        {
             if (vodafoneMobileNumberVerify(number))
                 return true;
        }
        else if (type == "cib")
        {
            if (cibMobileNumberVerify(number))
                return true;

        }
        else if (type =="fawry")
        {
            if (fawryMobileVerify(number))
                return true;
        }

            return false;

    }


    public boolean verificationWallet (String type , String MobileNum)
    {
       if (mobileNumberVerify(type , MobileNum) && otpVerification() )
       {
           System.out.println(" ");
           System.out.println("Wallet account verified succefully !!");
           System.out.println(" ");
           return true;
       }
        else
            return false;
    }



}
