import java.io.*;
import java.util.Scanner;
public class CSVTester
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		MakeCSV def = new MakeCSV();
		HoldCSV norm = new HoldCSV();
		File stat = new File("stat.CSV");
		int range;
		int bump;
		int windowValue;
		System.out.println("Enter the starting range from -100 to 100");
		range = sc.nextInt();
		System.out.println("Enter the amount the salter will minus or add by");
		bump = sc.nextInt();
		System.out.println("Enter the window value");
		windowValue = sc.nextInt();
		
		def.output(range);
		norm.ReadFile(stat);
		def.salter(stat, bump);
		def.smoother(stat, windowValue);
		System.out.println();

	}

}
