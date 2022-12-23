import java.util.*;
import java.util.ArrayList;
public class Main 
{
	public static void main(String[] args)
	{
        Scanner input = new Scanner(System.in);
		ArrayList<String> arr = new ArrayList<String>(4);
		arr.add("geeks");
		arr.add("for");
		arr.add("geeks");
        String find = input.nextLine();
		boolean ans = arr.contains(find);
		if (ans)
		{
		    System.out.print("Found Element: ");
			System.out.println(find);
		}
		else
		{
			System.out.println("The list does not contain the Element");
		}
	}
}
