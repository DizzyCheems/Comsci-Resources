import java.io.*;
import java.util.*;

class Subject {
    String name;
	int id;
	
Subject(String name, int id, String dept)
	{
		this.name = name;
		this.id = id;
	
	}
    public String getSubjectName()
      {
        return this.name + " " + this.id;
      }
}

class Student {

	String name;
	private List<Subject> subjects;
	Student(String name, List<Subject> subjects)
	{

		this.name = name;
		this.subjects = subjects;
	}

	
	public List<Subject> getSubjects()
	{
	
		return subjects;
	}
}


class Institute {


	String instituteName;
	private List<Student> students;


	Institute(String instituteName,List<Student> students)
	{

		this.instituteName = instituteName;
		this.students = students;
	}

	public int getTotalSubjectInInstitute()
	{
		int noOfsubjects = 0;
		List<Subject> subjects;

		for (Student stud : students) {
			subjects = stud.getSubjects();

			for (Subject s : subjects) {
				noOfsubjects++;
			}
		}

		return noOfsubjects;
	}
}
public class Dummytest
 {
        public static List<Student> students = new ArrayList<Student>();
        public static Institute institute = new Institute ("BITS", students);
        public static boolean choice;
        public static int menu()
                {
                    Scanner input = new Scanner(System.in);
            /***************************************************/
            System.out.println("Choose from these choices");
            System.out.println("++++++++++++++++++++++++\n");
            System.out.println("1 - Display all Students in the School");
            System.out.println("2 - Display Subjects of Student 1");
            System.out.println("3 - Display Subjects of Student 2");
            System.out.println("4 - Display Subjects of Teacher 1");
            System.out.println("5 - Display Subjects of Teacher 2");
            System.out.println("6 - Terminate program");
            int choice = input.nextInt();
            return choice;      
                }
	public static void main(String[] args)
	{
	
		Subject s1 = new Subject("BSCS", 1, "STUD1");
		Subject s2 = new Subject("CSPC", 2, "STUD1");
		Subject s3 = new Subject("ITCC", 1, "STUD2");
		Subject s4 = new Subject("CSCC", 2, "STUD2");
		List<Subject> Name1 = new ArrayList<Subject>();
		Name1.add(s1);
		Name1.add(s2);
                Name1.add(s4);
		List<Subject> Name2 = new ArrayList<Subject>();
		Name2.add(s3);
		Student student1 = new Student("BSCS", Name1);
		Student student2 = new Student("ITCC", Name2);
		List<Student> students = new ArrayList<Student>();
		students.add(student1);
		students.add(student2);
		Institute institute = new Institute("BITS", students);
		System.out.print("Total subjects in institute: ");
		System.out.print(institute.getTotalSubjectInInstitute());
                
                
            while (choice != true)
            {   
            int select = menu();
            switch(select)
            {
            case 1:
            System.out.print("Total Students in Subject: ");
            System.out.println(institute.getTotalSubjectInInstitute());
            System.out.print("Total Teacher in Subject: ");
           // System.out.println(institute.getTotalTeacher());
            System.out.print("Subject 1:" + s1.getSubjectName());
            break;
            case 2:
            System.out.println("Total Subjects of Student 1:" + " " + Name1.size());
            break;
            case 3:
            System.out.println("Total Subjects of Student 2:" + " " + Name2.size());
            break;
            case 4:
          //  System.out.println("Total Subjects of Teacher 1:" + " " +  teacher.size());
            break;    
            case 5:
          //  System.out.println("Total Subjects of Teacher 2:" + " " +  teacher2.size());
            break;    
            case 6:
            System.out.println("Terminating Program...");        
            System.exit(1);
            }
         }
                
	}
}
