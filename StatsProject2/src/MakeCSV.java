import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
public class MakeCSV
{
	private ArrayList<String> load = new ArrayList<String>();
	public MakeCSV()
	{
		
	}
	
	static void output()
	{
		try
		{
			PrintWriter write = new PrintWriter("stat.CSV");
					for(int i = 0;i<=100;i++)
					{
						double y = 1;
						y = Math.pow(i, 2)+2*i+1;
						write.print(i + "," + y);
						write.println();
						
					}
			write.close();
			
		}
		catch(FileNotFoundException e)
		{
			System.out.print("File Not Found");
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.print("Error out of Bound Exception");
		}
		
		
	}
	
	
	
	
	
	
}
