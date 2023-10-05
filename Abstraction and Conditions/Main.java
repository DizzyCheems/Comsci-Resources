import java.util.Scanner;
public class Main {
   public static void read ()
   {
      double weight; 
      double height;
      String result;
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter weight (Kilograms, Kg): ");
      weight = scan.nextDouble();
      System.out.print("Enter height (Meters, m): ");
      height = scan.nextDouble();
      result = classifyBMI( weight, height );
      System.out.println(result);
      scan.close();
   }
    public static double computeBMI(double weight, double height)
    {
        double bmi = weight / ( height * height);
        return bmi;
    }
   
   public static String classifyBMI(double weight, double height) 
    {
      double bmi = computeBMI(weight, height);
      if(bmi < 20)
      return "You are undershaped";
      else if(bmi < 26)
      return "You are in shape";
      else if(bmi < 30)
      return "To be honest you are not in shape";
      else if (bmi > 30)
      return " You are not in shape. Actually you are not even close";
      else
      return " You are not in shape. Actually you are not even close";
    }

   public static void main(String[] args) 
    {
      read();
    }
}
