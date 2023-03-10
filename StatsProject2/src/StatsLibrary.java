/*
 * A Statistics Library with method that could be 
 * used to solved Homework problem
 */
import java.math.*;
import java.util.ArrayList;
public class StatsLibrary
{
	public StatsLibrary()
	{
		
	}
	
	/*
	 * take in an array of numbers than return their mean
	 * @param arr = the array of numbers taken in
	 * @param total = the total after all number in the array been added together
	 */
	public double mean(double[] arr)
	{
		double total = 0;
		for(int i = 0;i<arr.length;i++)
		{
			total += arr[i];
		}
		return total/arr.length;
	}
	
	/*
	 * take in an array of number then return the median
	 * @param arr = the array of number taken in
	 * @param med = the median
	 */
	public double median(double[] arr)
	{
		double med = 0;
		//figures out whether the array is even in size or odd then decide the median based on that
		if(arr.length%2==0)
		{
			med = (arr[arr.length/2] + arr[(arr.length/2) - 1])/2;
		}
		else
		{
			med = arr[arr.length/2];
		}
		return med;
	}
	
	/*
	 * takes in an array of numbers then return the mode
	 * return no mode if there are 2 or more numbers with the highest frequency
	 * @param arr = the array filled with numbers taken in
	 * @param index = index of where a number equal to the current mode is in the array
	 * @param count = count how many duplicate of a number in the array
	 * @param max = the current highest amount of duplicates in the array
	 * @param max2 = check if the current max is truly the highest frequency
	 */
	public String mode(double[] arr)
	{
		int index = 0;
		int count = 0;
		int max = 1;
		int max2 = 0;
		
		//goes through each element in the array
		for(int i = 0;i<arr.length;i++)
		{
			//look at the following elements in the array and look for duplicates
			for(int y = 0;y<arr.length;y++)
			{
				//if there a duplicate found then add 1 to count
				if(arr[y] == arr[i])
				{
					count++;
				}
			}
			/*
			 * if count is greater the current greatest max
			 * then index = i and max equal the current count
			 * else if the current count is equal to the current max and 
			 * the current number being counted is not the same as the current mode then
			 * max2 = count
			 */
			if(count>max)
			{
				index = i;
				max = count;
			}
			else if(count == max && arr[i] != arr[index])
			{
				max2 = count;
			}
			count = 0;
		}
		/*
		 * if max and max2 are the same then there no mode
		 * else return the mode
		 */
		if(max == max2)
		{
			return "No mode";
		}
		else
		{
			String temp = String.valueOf(arr[index]);
			return temp;
		}

	}
	
	/*
	 * method to calculate and return the standard deviation of an array of numbers
	 * @param arr = the array of numbers taken in
	 * @param meanP = the mean of the array of numbers
	 * @param calc = what will be used to store the results of the calculations
	 */
	public double standard(double[] arr)
	{
		double meanP = 0;
		double calc = 0;
		
		meanP = mean(arr);
		
		/*
		 * minus every element in the array by meanP then squares it
		 * then add the result to calc
		 */
		for(int i =0;i<arr.length;i++)
		{
			calc += (arr[i] - meanP)*(arr[i] - meanP);
		}
		calc = calc/arr.length;
		return Math.sqrt(calc);
	}
	
	/*
	 * method to find the intersection of 2 sets
	 * @param arr1 = an array representing set 1
	 * @param arr2 = an array representing set 2
	 * @param set = a new set that represent the intersection of set 1 and set 2
	 */
	public ArrayList<Integer> intersection(int[] arr1,int[] arr2)
	{
		ArrayList<Integer> set = new ArrayList<Integer>();
		
		//look through each element in set1
		for(int i = 0;i<arr1.length;i++)
		{
			//then look at each element in set2
			for(int y = 0;y<arr2.length;y++)
			{
				//if the 2 elements match then add that element to @param set
				if(arr1[i]==arr2[y])
				{
					set.add(arr1[i]);
				}
			}
		}
		return set;
	}
	
	/*
	 * method to find the union of 2 sets
	 * @param arr1 = an array representing set 1
	 * @param arr2 = an array representing set 2
	 * @param set = a new set that represent the union of set 1 and set 2
	 */
	public ArrayList<Integer> union(int[] arr1,int[] arr2)
	{
		ArrayList<Integer> set = new ArrayList<Integer>();
		
		//first add every element in set1 to @param set
		for(int i = 0;i<arr1.length;i++)
		{
			set.add(arr1[i]);
		}
		
		/*
		 * look at every element in set2
		 * if there an element not already in @param set
		 * then add the element to @param set
		 */
		for(int i = 0;i<arr2.length;i++)
		{
			if(!set.contains(arr2[i]))
			{
				set.add(arr2[i]);
			}
		}
		
		return set;
	}
	
	/*
	 * method to find the complement 
	 * @param arr1 = an array representing set 1
	 * @param whole = a set representing S for all elements possible
	 * @param set = the set representing the complement of set1
	 */
	public ArrayList<Integer> complement(int[] arr1,int[] whole)
	{
		ArrayList<Integer> set = new ArrayList<Integer>();
		
		//goes through each element in the @param whole
		for(int i = 0;i<whole.length;i++)
		{
			boolean contain = true;
			//check if there an element in set1 that matches the current element for whole
			for(int y = 0; y<arr1.length;y++)
			{
				//if there is a matching element set contain to false
				if(whole[i] == arr1[y])
				{
					contain = false;
				}
			}
			/*
			 * if contain is true then that mean there no element in set1 that matches the current element whole[i]
			 * then we add that element of whole[i] to @param set
			 */
			if(contain)
			{
				set.add(whole[i]);
			}
		}
		return set;
	}

	
	/*
	 * method to calculate permuation
	 * @param n = the parameter n in a permutation formula
	 * @param r = the parameter r in a permutation formula
	 * @param factN = the factorial of n
	 * @param factNR = the factorial of n-r
	 */
	public BigInteger permutation(int n, int r)
	{
		BigInteger factN = new BigInteger("1");
		BigInteger factNR = new BigInteger("1");
		
		//calculate n!
		for(int i = 1;i<=n;i++)
		{
			factN = factN.multiply(BigInteger.valueOf(i));
		}
		
		//calculate (n-r)!
		for(int i = 1;i<=(n-r);i++)
		{
			factNR = factNR.multiply(BigInteger.valueOf(i));
		}
		
		return factN.divide(factNR);
		
	}
	
	/*
	 * method to calculate combination
	 * @param n = the parameter n in a permutation formula
	 * @param r = the parameter r in a permutation formula
	 * @param factN = the factorial of n
	 * @param factNR = the factorial of n-r
	 * @param factR = factorial of r
	 */
	public BigInteger combination(int n, int r)
	{
		BigInteger factN = new BigInteger("1");
		BigInteger factNR = new BigInteger("1");
		BigInteger factR = new BigInteger("1");
		
		//calculate n!
		for(int i = 1;i<=n;i++)
		{
			factN = factN.multiply(BigInteger.valueOf(i));
		}
		
		//calculate (n-r)!
		for(int i = 1;i<=(n-r);i++)
		{
			factNR = factNR.multiply(BigInteger.valueOf(i));
		}
		
		//calculate r!
		for(int i = 1;i<=r;i++)
		{
			factR = factR.multiply(BigInteger.valueOf(i));
		}
		
		return factN.divide(factNR.multiply(factR));
		
	}
	
	/*
	 * method to calculate binomial distribution
	 * @param n = parameter of n in a binomial formula
	 * @param y = the parameter y in a binomial formula
	 * @param p = the parameter p in a binomial formula
	 * @param comp = the result of the calculated combination of n and y
	 * @param succ = the success chance p changed to BigDecimal
	 */
	public BigDecimal binomialExact(int n, int y, double p)
	{
		BigDecimal comp = new BigDecimal(combination(n,y));
		BigDecimal succ = new BigDecimal(p);
		
		succ = succ.pow(y);
		
		//calculate q in bigDecimal
		BigDecimal fail = new BigDecimal(1-p);
		
		fail = fail.pow((n-y));
		comp = comp.multiply(succ);
		comp = comp.multiply(fail);
		
		//round off the result to not have a big number
		return comp.setScale(8,RoundingMode.CEILING);
	}
	
	/*
	 * a modified method of the binomial calculator to calculate 
	 * for situation where they want to find at least probabilities
	 * @param out = a parameter to track all the calculations taking place
	 */
	public BigDecimal binomialAtLeast(int n, int y, double p)
	{
		BigDecimal out = new BigDecimal(0);
		
		/*
		 * do binomial distribution of every
		 * every outcome from y to n
		 * add the results together onto @param out
		 */
		for(int i = y; i<=n; i++)
		{
			out = out.add(binomialExact(n,i,p));
		}
		return out.setScale(8,RoundingMode.CEILING);
		
		
	}
	
	/*
	 * modified version of the binomialExact but
	 * for situation where they want probabilities for at most
	 * @param out = a parameter to track all the calculations taking place
	 */
	public BigDecimal binomialAtMost(int n, int y, double p)
	{
		BigDecimal out = new BigDecimal(0);
		/*
		 * do the binomial method for
		 * all the results between 0 and y including 0 and y
		 * add them all up onto @param out
		 */
		for(int i = y; i>=0; i--)
		{
			out = out.add(binomialExact(n,i,p));
		}
		return out.setScale(8,RoundingMode.CEILING);
	}
	
	/*
	 * method to do geometric distribution
	 * @param p = the parameter p probability of success
	 * @param y = the parameter y in the geometric formula
	 * @param q = the probability of failure
	 */
	public BigDecimal geometric(double p,int y)
	{
		double q = 1-p;
		BigDecimal Geo = new BigDecimal(q);
		Geo = Geo.pow(y-1);
		Geo = Geo.multiply(BigDecimal.valueOf(p));
		return Geo.setScale(8,RoundingMode.CEILING);
		
	}

	
}
