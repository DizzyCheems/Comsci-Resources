import java.util.ArrayList;
import java.util.*;
public class Main {
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
			System.out.println(find);
		else
			System.out.println("Element NOT found");

	}
}
