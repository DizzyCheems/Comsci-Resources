import java.util.Scanner;
public class Main{
    public static int n,i,maxNumber;
	public static int fibonacciRecursion(int n){
	if(n == 0)
	{
		return 0;
	}
	if(n == 1 || n == 2)
	{
			return 1;
	}
	return fibonacciRecursion(n-2) + fibonacciRecursion(n-1);
	}
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
	for(int i = 0; i < maxNumber; i++)
	{
			System.out.print(fibonacciRecursion(i)+ " ");
	}    
    }
    public static void main(String args[]) 
    {
        result();
	}
}