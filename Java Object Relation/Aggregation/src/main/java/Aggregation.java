    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    import java.util.*;
    /**
     *
     * @author favia-ju
     */
    class Student
    {
            String name;
            int id;
            String subject;
            Student(String name, int id, String dept)
            {
                    this.name = name;
                    this.id = id;
                    this.subject = dept;
            } 
      public String getStudentName()
      {
        return this.name + " " + this.id + " " + this.subject;
      }
    }
    class Faculty
    {
            String name;
            int id;
            String subject;
            Faculty(String name, int id, String dept)
            {
                    this.name = name;
                    this.id = id;
                    this.subject = dept;
            } 
      public String getFacultyName()
      {
        return this.name + " " + this.id + " " + this.subject;
      }
    }
    class Subject
    {
            String name;
            private List<Student> students;
            private List<Faculty> faculty;
            Subject(String name, List<Student> students, List<Faculty> faculty)
            {
                    this.name = name;
                    this.students = students;
                    this.faculty = faculty;
            }
            public List<Student> getStudents()
            {
                    return students;
            }

            public List<Faculty> getfaculty()
            {
                    return faculty;
            }
    }
    class Course 
    {
            String instituteName;
            private List<Subject> departments;
            Course(String instituteName,List<Subject> departments)
            {
                    this.instituteName = instituteName;
                    this.departments = departments;
            }
            public int getTotalStudentsInInstitute()
            {
                    int noOfStudents = 0;
                    List<Student> students;
                    for (Subject dept : departments)
                    {
                            students = dept.getStudents();
                            for (Student s : students)
                            {
                                    noOfStudents++;
                            }
                    }
                    return noOfStudents;
            }

            public int getTotalTeacher()
            {
                    int noOfteacher = 0;
                    List<Faculty> faculty;
                    for (Subject dept : departments)
                    {
                            faculty = dept.getfaculty();
                            for (Faculty t : faculty)
                            {
                                    noOfteacher++;
                            }
                    }
                    return noOfteacher;
            }
    }

    public class Aggregation 
    {
        public static List<Subject> departments = new ArrayList<Subject>();
        public static Course institute = new Course ("BITS", departments);
        public static boolean choice;
        public static int menu()
        {
            Scanner input = new Scanner(System.in);
            /***************************************************/
            System.out.println("Choose from these choices");
            System.out.println("++++++++++++++++++++++++\n");
            System.out.println("1 - Display all Students in the School");
            System.out.println("2 - Display Students in Course 1");
            System.out.println("3 - Display Students in Course 2");
            System.out.println("4 - Display Teacher in Course 1");
            System.out.println("5 - Display Teacher in Course 2");
            System.out.println("6 - Terminate program");
       
            int choice = input.nextInt();
            return choice;    
        }
            public static void main(String[] args)
            {
                    Scanner input = new Scanner(System.in);
                    System.out.print("Enter person1 name: ");
                    String name = input.nextLine();
                    System.out.print("Enter person1 ID: ");
                    String id1_val = input.nextLine();
                    System.out.print("Enter person1 course: ");
                    String department1 = input.nextLine();
                    int id1 = Integer.parseInt(id1_val);
                    Student s1 = new Student(name, id1, department1);
                    //datafield#2
                    System.out.print("Enter person2 name: ");
                    String name2 = input.nextLine();
                    System.out.print("Enter person2 ID: ");
                    String id2_val = input.nextLine();
                    System.out.print("Enter person2 course: ");
                    String department2 = input.nextLine();
                    int id2 = Integer.parseInt(id2_val);
                    Student s2 = new Student(name2, id2, department2);
                    Student s3 = new Student("John Doe", 3, "BSCS");        
                    //END OF USER INPUT
                    List<Student> course_1 = new ArrayList<Student>();
                    List<Student> course_2 = new ArrayList<Student>();
                    course_1.add(s1);
                    course_1.add(s2);
                    course_2.add(s3);
                    List<Faculty> teacher = new ArrayList<Faculty>();
                    List<Faculty> teacher2 = new ArrayList<Faculty>();
                    Faculty t1 = new Faculty("Sir?", 2, "EE");
                    Faculty t2 = new Faculty("Ha?", 1, "CSE");
                    teacher2.add(t2);
                    teacher.add(t1);
                    Subject Subject1 = new Subject("Subject1", course_1, teacher);
                    Subject Subject2 = new Subject("Subject2", course_2, teacher2);
                    departments.add(Subject1);
                    departments.add(Subject2);
       while (choice != true)
        {   
            int select = menu();
            switch(select)
            {
            case 1:
            System.out.print("Total Students in Subject: ");
            System.out.println(institute.getTotalStudentsInInstitute());
            System.out.print("Total Teacher in Subject: ");
            System.out.println(institute.getTotalStudentsInInstitute());
            System.out.print("DATA:" + s1.getStudentName());
            break;
            case 2:
            System.out.println("Total Students in Course 1:" + " " + course_1.size());
            break;
            case 3:
            System.out.println("Total Students in Course 2:" + " " + course_2.size());
            break;
            case 4:
            System.out.println("Total Faculty in Course 1:" + " " +  teacher.size());
            break;    
            case 5:
            System.out.println("Total Faculty in Course 2:" + " " +  teacher2.size());
            break;    
            case 6:
            System.out.println("Terminating Program...");        
            System.exit(1);
            }
         }
       }
    }
