import java.io.*;

public class CSVTester
{

	public static void main(String[] args)
	{
		MakeCSV def = new MakeCSV();
		HoldCSV norm = new HoldCSV();
		File stat = new File("stat.CSV");
;
		
		//range of csv from x to 100 where x is between -100 to 100
		int range = 0;
		//random generated number that the salter will salt the graph by
		int bump = 3;
		//the window value for the smoother
		int windowValue = 3;
		//interval in which the points will be plotted
		int interval = 1;

		
		def.output(range,interval);
		norm.ReadFile(stat);
		def.salter(stat, bump);
		def.smoother(stat, windowValue,range);
		def.smoother(stat, windowValue,range);
		def.smoother(stat, windowValue,range);
		System.out.println();
		

	}

}
