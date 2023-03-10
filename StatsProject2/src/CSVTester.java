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
		int interval;
		System.out.println("Enter the starting range from -100 to 100");
		range = sc.nextInt();
		System.out.println("Enter the range the salter will minus or add by 0 or greater");
		bump = sc.nextInt();
		System.out.println("Enter the window value 1 or greater");
		windowValue = sc.nextInt();
		System.out.println("Enter the interval of the plotted points 1 or greater");
		interval = 1;
		
		def.output(range,interval);
		norm.ReadFile(stat);
		def.salter(stat, bump);
		def.smoother(stat, windowValue);
		System.out.println();

	}

}
