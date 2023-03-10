import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
public class MakeCSV
{
	private ArrayList<String> load = new ArrayList<String>();
	public MakeCSV()
	{
		
	}
	
	static void output(int range)
	{
		
		try
		{
			PrintWriter write = new PrintWriter("stat.CSV");
					for(int i = range;i<=100;i++)
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
	
	static void salter(File name,int bump,int range)
	{
		Random rand = new Random();
		String buff;
		String[] hold;
		String newFile = "";
		double newY;
		try
		{
			BufferedReader in = new BufferedReader(new FileReader(name));
			while((buff = in.readLine()) != null)
			{
				hold = buff.split(",");
				newY = Double.parseDouble(hold[1]) + rand.nextInt(bump)-bump;
				newFile += hold[0] + "," + String.valueOf(newY) + "\n";
			}
			in.close();
			PrintWriter write = new PrintWriter(name);
			write.print(newFile);
			write.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.print("File Not Found");
		}
		catch(IOException e)
		{
			System.out.print("I0Exeption");
		}

	}
	
	
	
	
	
	
}
