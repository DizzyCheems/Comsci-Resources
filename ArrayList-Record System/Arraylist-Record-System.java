import java.util.*; 
import java.util.stream.Stream;
public class Main 
{
   public static boolean choice;
   public static void main(String[] args)  
   { 
    Student persons = new Student();
    while (choice != true)
    {   
        int select = persons.menu();
        switch(select)
        {
        case 1:
        System.out.println("Enter Student Credentials: ");        
        persons.program();
        break;
        case 2:
        persons.display();
        break;
        case 3:
        Scanner input = new Scanner (System.in);
        System.out.print("Filter by Course: ");
        String find = input.nextLine();
        for(int i=0; i<persons.student.size(); i++)
        {
        Stream<String> stream = Stream.of(persons.student.get(i));
        stream.filter(str -> str.contains(find)).forEach(System.out::println);
        }
        break;
        case 4:
        System.out.println("Terminating Program...");        
        System.exit(1);
        }
     }
   } 
}
class Student 
{
  public static String firstName, middleName, lastName, birthDate, course, yearlevel,age, fullname;
  public static ArrayList<String>student = new ArrayList<>();
  public static List<String> list = new ArrayList<>();
    public static void program()
    {
        Scanner input = new Scanner (System.in);
        String fullname = getfullname();
        student.add(fullname); 
        
    }
     public static void display()
     {
        System.out.println("List of All Students:");
        for (int i=0; i<student.size(); i++)
        {
           Collections.sort(student);
           System.out.println(student.get(i)); 
        }
        System.out.println();
    }
 
     public static String getfirstname()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Student First Name: ");
        String firstName = input.nextLine();
        return firstName;
    }
    public static String getmiddlename()
    {
        Scanner input = new Scanner(System.in);
       System.out.print("Enter Student Middlename: ");
       String  middleName = input.nextLine();
        return middleName;
        
    }
    public static String getlastname()
    {
        Scanner input = new Scanner(System.in);
       System.out.print("Enter Student Last Name: ");
       String  lastName = input.nextLine();
        return lastName;
    }
    public static String getfullname()
    {
        String f = getfirstname();
        String m = getmiddlename();
        String l = getlastname();
        String c = getCourse();
        String person_age = getAge();
        String fullname = (fix(f)) + " " + (fix(m)) + " " + (fix(l)) + " " + person_age + " " + (fix(c));
       // String fullname = person_age + " " + (fix(f)) + " " + (fix(m)) + " " + (fix(l)) + " " + (fix(c));
        return fullname;
    }
    public static String getCourse()
    {
       Scanner input = new Scanner(System.in);
       System.out.print("Enter Student Course: ");
       String course = input.nextLine();
       return course;
    }
    public static String getAge()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Birthyear: ");
        int birthyear = input.nextInt();
        int age= 2022 - birthyear ;
        String student_age = String.valueOf(age);
        return student_age;
    }

      public static int menu()
    {
        Scanner input = new Scanner(System.in);
        /***************************************************/
        System.out.println("Choose from these choices");
        System.out.println("++++++++++++++++++++++++\n");
        System.out.println("1 - Enter Student");
        System.out.println("2 - Display Students");
        System.out.println("3 - Filter Students");
        System.out.println("4 - Terminate program");
        int choice = input.nextInt();
        return choice;    
    }
         public static  String fix(String str) {

      if (str == null || str.length() == 0) return str;

      return str.substring(0, 1).toUpperCase() + str.substring(1);
}
}