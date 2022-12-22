public class Main {
 
public static int sumEven() {
    int sum = 0;
  for(int i = 0 ; i <=100 ; ++i) {
      if(i % 2 == 0) sum+=i;
  }
     return sum;
}
public static int sumOdd() { 
    int sum = 0;
    for(int i = 0 ; i<=100; ++i) {
        if(i % 2 != 0) sum+=i;
    }
    return sum;
}

public static void displaySum()
{
    System.out.println("Sum of all Even numbers  = " + sumEven()); 
    System.out.println("Sum of all Odd numbers = " + sumOdd());
}

public static void main(String[] args ) 
{
    displaySum();
}
}

