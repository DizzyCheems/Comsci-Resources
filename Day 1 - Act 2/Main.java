import java.util.Scanner;
public class Main
{
    public static int sum(int n)
    {
        int sum = 0 ;
        for (int i=1;i<=n;i++)
        {
            sum+=i;
        }
        return sum;
    }
    public static void main(String[]argv)
    {
        Scanner input= new Scanner(System.in);  
        System.out.print("Enter the value of n:");
        int n= input.nextInt();  
        System.out.print("The total sum of numbers 1 ->" +n); 
        System.out.print("is" +sum(n));
        
    }
}



