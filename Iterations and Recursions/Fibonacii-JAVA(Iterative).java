import java.util.Scanner;
public class Main 
{
    public static int maxNumber; 
	public static int previousNumber = 0;
	public static int nextNumber = 1;
    public static void read()
    {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter maximum number of terms for your Fibonacii Series:");
    maxNumber = input.nextInt();   
    input.close();
    }
    public static void result()
    {	
    read();    
	System.out.print("Your Series of "+maxNumber+" terms is:");
	        for (int i = 1; i <= maxNumber; ++i)
	        {
	            System.out.print(previousNumber+" ");
	            int sum = previousNumber + nextNumber;
	            previousNumber = nextNumber;
	            nextNumber = sum;
	        }
    }
	public static void main(String[] args) 
	{
	    result();
	}
}