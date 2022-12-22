
import java.util.Scanner;
public class GCD-Java
{
    public static int m,n;
    public static void read()
    {
        Scanner input= new Scanner(System.in);  
        System.out.print("Enter the value of m:");
         n= input.nextInt();  
        System.out.print("Enter the value of n:");
         m= input.nextInt(); 
         input.close();
    }
    
    public static void output()
    {
        read();
        int result = gcd(n,m);
        System.out.print("The GCD of both values is: " +result); 
       
    }
    
    public static int gcd(int n, int m)
    {
        
     int p = m;
     int q = n;
     while (p%q !=0)
     {
          int r = p%q;
          p=q;
          q=r;
     }
    return q;
    }

    public static void main(String[] args)
    {
        output();
    }
    
}


