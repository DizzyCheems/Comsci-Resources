import java.util.Scanner;
class Faviastack {
    public int arr[];
    public int top;
    public int capacity;
    public Faviastack(int size ) 
    {
        arr = new int[size];
        capacity = size;
        top = -1;
        
    }
    public void push(int x)
    {
       if(isFull())
       {
           System.out.println("OverFlow\nProgram Terminated\n");
           System.exit(1);
       }
       System.out.println("\nInserting " + x + " top = " + (top+1));
       arr[++top] = x;
      
    }
    public int pop()
    {
        if(isEmpty())
        {
            System.out.println("UnderFlow\nProgram Terminated");
        }
        
        System.out.println("\nRemoving" + peek() + "top = " + (top-1 ));
        return arr[top--];
    }
    
    public int peek()
    {
        if (!isEmpty()) {
            return arr[top];
        }
        else {
            System.exit(-1);
        }
 
        return -1;
    }
            
    public int size()
    {
        return top + 1;
    }
    public Boolean isEmpty()
    {
        return top == -1;
    }
    public Boolean isFull()
    {
        return top == capacity - 1;
    }
    public void Display()
    {
         System.out.println("Printing Stack elements .....");
         for(int i = 0; i <=top;i++) 
         {
             System.out.print(arr[i] + " ");
             
         }
         System.out.print(" top = " + top );
         System.out.println("\n");
    }
     public int clear()
    {
        top = -1;
        return top;
    }
}

public class Main {
    public static boolean choice;
    public static int menu() 
    {
        Scanner input = new Scanner(System.in);
        /***************************************************/
        System.out.println("Choose from these choices");
        System.out.println("++++++++++++++++++++++++\n");
        System.out.println("1 - To Put value inside a stack");
        System.out.println("2 - To Remove value to a stack");
        System.out.println("3 - To Peek inside the stack");
        System.out.println("4 - To delete entire stack");
        System.out.println("5 - Check if empty");
        System.out.println("6 - Display Stack");
        System.out.println("7 - To delete entire stack");
        System.out.println("8 - Check if Full");
        System.out.println("9 - Terminate program");
        int choice = input.nextInt();
        return choice;    
    }
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);  
        System.out.print("Enter amount of stacks:");
        int n= input.nextInt(); 
        Faviastack s = new Faviastack(n);
     
    while (choice != true)
{
        int select = menu();
        switch(select)
        {
            case 1:
        System.out.print("value to push to stack:");        
        n = input.nextInt();
        s.push(n);
        break;
            case 2:
        System.out.print("value to pop to stack:");        
        n = input.nextInt();
           s.pop();
            break;
            case 3:
           System.out.print("Stack Element at the Top is:" + s.peek() + " ");
            break;
            case 4:
           s.clear(); 
            break;
            case 5:
              if (s.isEmpty()) 
              {
            System.out.println("The stack is empty");
              }
             else 
             
              {
            System.out.println("The stack is not empty");
              }
           break;
            case 6:
           s.Display();     
           break;
            case 7:
           s.clear();
           break;
            case 8:
           if (s.isFull()) 
              {
            System.out.println("Stack is Full");
              }
             else 
              {
            System.out.println("The stack is not Full");
              }
             break;
            case 9:
           System.exit(1);
        }
    }
}
}