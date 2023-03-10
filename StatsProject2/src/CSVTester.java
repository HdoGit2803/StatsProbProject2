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
		int bump = 5;
		System.out.println("Enter the starting range from -100 to 100");
		range = sc.nextInt();
		
		def.output(range);
		norm.ReadFile(stat);
		def.salter(stat, bump, range);

	}

}
