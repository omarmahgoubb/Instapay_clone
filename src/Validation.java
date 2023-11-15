import java.util.Random;
import java.util.Scanner;

public abstract class  Validation {
 private int[] otpNumbers = {123, 456, 789, 888, 111 , 222 , 333 , 444 } ;
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
 }
}
