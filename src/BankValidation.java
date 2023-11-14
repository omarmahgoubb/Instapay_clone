import java.util.Random;
import java.util.Scanner;

public class BankValidation extends Validation{
    private String[] bankNumber = {"99999","11111","22222"};
    private String[] bankMobileNumber = {"01030","01250","01560"};
    private int[] otpNumbers = {123, 456, 789, 888, 111 , 222 , 333 , 444 } ;

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
    public boolean otpVerification()
    {

        int randomIndex = new Random().nextInt(otpNumbers.length);

        int randomNum = otpNumbers[randomIndex];
        System.out.println("OTP number is : " + randomNum);

        Scanner scanner = new Scanner(System.in);
        int testnumber;
        System.out.println("Please enter the otp number");
        testnumber =  scanner.nextInt();
        scanner.close();

        System.out.println("OTP number is : " + randomNum + " you entered number : " + testnumber );


         if (testnumber == randomNum)
         {
             System.out.println("OTP verified Successfully ");
             return true;
         }
         else
         {
             System.out.println("error in otp verification !!");
             return false;
         }
        //    System.out.println("done");
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



