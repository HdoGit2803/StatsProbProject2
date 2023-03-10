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
						double y;
						y = 2*i + 1;
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
	
	static void salter(File name,int bump)
	{
		Random rand = new Random();
		String buff;
		String[] hold;
		String newFile = "";
		double newY;
		try
		{
			BufferedReader read = new BufferedReader(new FileReader(name));
			while((buff = read.readLine()) != null)
			{
				hold = buff.split(",");
				newY = Double.parseDouble(hold[1]) + rand.nextInt(bump*2)-bump;
				newFile += hold[0] + "," + String.valueOf(newY) + "\n";
			}
			read.close();
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
	
	static void smoother(File name,int walue)
	{
		String[] hold;
		String buff;
		double smooth = 0;
		String newFile = "";
		ArrayList<Double> y = new ArrayList<Double>();
		int idex = 0;
		try
		{
				BufferedReader go = new BufferedReader(new FileReader(name));
				while((buff = go.readLine()) != null)
				{
					hold = buff.split(",");
					y.add(Double.parseDouble(hold[1]));
				}
				go.close();
				
				BufferedReader read = new BufferedReader(new FileReader(name));
				while((buff = read.readLine()) != null)
				{
					smooth = 0;
					hold = buff.split(",");
					int count1 = 0;
					int count2 = 0;
					int copy = idex;
					
					while((copy>0)&(count1<=walue))
					{
						copy--;
						smooth += y.get(copy);
						count1++;
					}	
					copy = idex;
					while((copy<y.size()-1)&(count2<=walue))
					{
						copy++;
						smooth += y.get(copy);
						count2++;
					}
					smooth = smooth/(count1+count2);
					newFile += hold[0] + "," + String.valueOf(smooth) + "\n";
					idex++;
					
				}
				read.close();
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
