/*
 * program that plot a function in this case y = 2x + 1
 * into a csv then another method salt the y data in that same csv
 * then a 3rd method to smooth the csv
 */
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
	
	/*
	 * program the prints the x and y of y = 2x+1 into a csv
	 * @param range = the range from x to 100 where the function y = 2x+1 would start and end where x is @range
	 * @param inter = the interim in which the function y = 2x+1 would be plotted/written into the csv
	 */
	static void output(int range,int inter)
	{
		int count = inter;
		try
		{
			PrintWriter write = new PrintWriter("stat.CSV");
					for(int i = range;i<=100;i++)
					{
						double y;
						y = 2*i + 1;
						if(count == inter||i==100)
						{
							write.print(i + "," + y);
							write.println();
							count = 0;
						}
						count++;
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
	
	/*
	 * program that would take in a csv and salt the data then write that back into the same csv
	 * @param name = the name of the csv taken in a being overwritten
	 * @param bump = the range that a randomly generated number would add or subtract from the data y
	 */
	static void salter(File name,int bump)
	{
		Random rand = new Random();
		String buff;
		String[] hold;
		String newFile = "";
		double newY;
		try
		{
			/*
			 * this uses a buffer reader to read each line of the csv and then
			 * seperate the current x and the current y into the array @hold that temp stores them
			 * then the salted Y @newY is then calculated then both the current x and newY is added into a string @newFile
			 */
			BufferedReader read = new BufferedReader(new FileReader(name));
			while((buff = read.readLine()) != null)
			{
				hold = buff.split(",");
				newY = Double.parseDouble(hold[1]) + rand.nextInt(bump*2)-bump;
				newFile += hold[0] + "," + String.valueOf(newY) + "\n";
			}
			read.close();
			/*
			 * write the content of @newFile into the csv that taken in
			 * the PrinteWriter @writeSalt also does the same into a new csv call salt
			 * this is to make it easier for me to check on the salted data before it been smoothed
			 */
			PrintWriter write = new PrintWriter(name);
			PrintWriter writeSalt = new PrintWriter("salt.CSV");
			writeSalt.print(newFile);
			write.print(newFile);
			write.close();
			writeSalt.close();
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
	
	/*
	 * program that takes in a csv preferably one that been salted and then smooth the data
	 * @param name = name of the csv taken in
	 * @param walue = the window value of the smoother
	 * @param range = the range that the csv from x to 100 started at where range is x
	 */
	static void smoother(File name,int walue,int range)
	{
		String[] hold;
		String buff;
		double smooth = 0;
		String newFile = "";
		ArrayList<Double> y = new ArrayList<Double>();
		int x = range;
		int idex = 0;
		try
		{
			/*
			 * read each line of the csv and add the y data into an arraylist @y
			 */
				BufferedReader go = new BufferedReader(new FileReader(name));
				while((buff = go.readLine()) != null)
				{
					hold = buff.split(",");
					y.add(Double.parseDouble(hold[1]));
				}
				go.close();
				
				while(idex<y.size())
				{
					smooth = 0;
					int count1 = 0;
					int count2 = 0;
					int copy = idex;
					
					/*
					 * add the current index to @smooth 
					 * then also add the previous x index
					 * where x is the window value
					 * stops if it hits the first index since there nothing before that one
					 */
					while(((copy-count1)>=0)&(count1<=walue))
					{
						smooth += y.get(copy-count1);
						count1++;
					}	
					
					/*
					 * same as above exept it does not add the current index
					 * and it add the following x values
					 * stops if it hits the last index since there nothing beyond that
					 */
					while(((copy+count2)<y.size()-1)&(count2<walue))
					{
						count2++;
						smooth += y.get(copy+count2);
					}
					
					//if by some chance both count1 and 2 equals 0 then count1 = 1 so that there wont be a divide by zero situation
					if(count1 == 0 & count2 ==0)
					{
						count1 = 1;
					}
					
					//calculate the mean
					smooth = smooth/(count1+count2);
					
					/*
					 * change the current index of y to the current mean
					 * then add the current position of x and the current mean to the string @newFile
					 */
					y.set(idex, smooth);
					newFile += x + "," + String.valueOf(smooth) + "\n";
					x++;
					idex++;
					
				}
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
