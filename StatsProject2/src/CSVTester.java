import java.io.*;
public class CSVTester
{

	public static void main(String[] args)
	{
		MakeCSV def = new MakeCSV();
		HoldCSV norm = new HoldCSV();
		File stat = new File("stat.CSV");
		
		def.output();
		norm.ReadFile(stat);
		
		System.out.println(norm.outX());
		System.out.println(norm.outY());

	}

}
