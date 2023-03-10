import java.math.*;
public class StatlLibraryTester
{
	public static void main(String[] arg)
	{
		int[] setA = {1,2,3,4};
		int[] setB = {1,2,3,4,5,6};
		int[] whole = {1,2,3,4,5,6,7,8};
		double[] arr = {1,2,3,4,5};
		
		StatsLibrary def = new StatsLibrary();
		
		System.out.println("Mean: " + def.mean(arr));
		System.out.println("Median: "+def.median(arr));
		System.out.println("Mode:"+def.mode(arr));
		System.out.println("Standard Deviation: "+def.standard(arr));
		
		System.out.println("Intersection: "+def.intersection(setA, setB));
		System.out.println("Union: "+def.union(setA, setB));
		System.out.println("Complement: "+def.complement(setA, whole));

		
		System.out.println("Binomial for Exactly: "+def.binomialExact(10, 7, .7));
		System.out.println("Binomial for least: "+def.binomialAtLeast(10, 9, 0.3));
		System.out.println("Binomial for most: "+def.binomialAtMost(5, 1, 0.3));
		System.out.println("Permuation: "+def.permutation(10, 9));
		System.out.println("Combination: "+def.combination(10, 9));
		System.out.println("Geometric: "+def.geometric(.3, 9));
		
	}
}
