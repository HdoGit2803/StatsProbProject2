import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
public class HoldCSV
{

	private ArrayList<Integer> x = new ArrayList<Integer>();
	private ArrayList<Double> y = new ArrayList<Double>();
	
	public HoldCSV()
	{
		
	}
	
	public void ReadFile(File name)
	{
		String[] hold;
		String buff;
		try
		{
			BufferedReader in = new BufferedReader(new FileReader(name));
			{
				while((buff = in.readLine()) != null)
				{
					hold = buff.split(",");
					x.add(Integer.parseInt(hold[0]));
					y.add(Double.parseDouble(hold[1]));
				}
				in.close();
			}
			
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
	
	public ArrayList<Integer> outX()
	{
		return x;
	}
	
	public ArrayList<Double> outY()
	{
		return y;
	}
}
