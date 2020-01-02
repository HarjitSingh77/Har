
import java.util.ArrayList; 
import java.util.Scanner;
public class perfectsum
{ 
	
	static boolean[][] dp; 
	
	static void display(ArrayList<Integer> v) 
	{ 
	System.out.println(v); 
	} 
	
	 
	 
	static void printSubsetsRec(int i,int arr[], int sum, 
										ArrayList<Integer> p) 
	{ 
		
		if (i == 0 && sum != 0 && dp[0][sum]) 
		{ 
			p.add(arr[i]); 
			display(p); 
			p.clear(); 
			return; 
		} 
	
		
		if (i == 0 && sum == 0) 
		{ 
			display(p); 
			p.clear(); 
			return; 
		} 
	
		
		if (dp[i-1][sum]) 
		{ 
			// Create a new vector to store path 
			ArrayList<Integer> b = new ArrayList<>(); 
			b.addAll(p); 
			printSubsetsRec( i-1,arr,sum, b); 
		} 
	
		 
		if (sum >= arr[i] && dp[i-1][sum-arr[i]]) 
		{ 
			p.add(arr[i]); 
			printSubsetsRec(i-1,arr,sum-arr[i], p); 
		} 
	} 
	
	
	static void printAllSubsets(int n,int arr[], int sum) 
	{ 
		if (n == 0 || sum < 0) 
		return; 
	
	
		dp = new boolean[n][sum + 1]; 
		for (int i=0; i<n; ++i) 
		{ 
			dp[i][0] = true; 
		} 
	
		 
		if (arr[0] <= sum) 
		dp[0][arr[0]] = true; 
	
		
		for (int i = 1; i < n; ++i) 
			for (int j = 0; j < sum + 1; ++j) 
				dp[i][j] = (arr[i] <= j) ? (dp[i-1][j] || 
										dp[i-1][j-arr[i]]) 
										: dp[i - 1][j]; 
		if (dp[n-1][sum] == false) 
		{ 
			System.out.println("There are no subsets with" + 
												" sum "+ sum); 
			return; 
		} 
	
		
		ArrayList<Integer> p = new ArrayList<>(); 
		printSubsetsRec( n-1,arr,sum, p); 
	} 
	

	public static void main(String args[]) 
	{ 
		Scanner sc=new Scanner(System.in);
                System.out.println("enter the num of array:");
                String num=sc.next();
                int n=Integer.parseInt(num);
                int arr[]=new int[n];
                
                for(int i=0;i<arr.length;i++)
                {
                   arr[i]=sc.nextInt();
                }
               
                System.out.println("enter the sum to calculate:");
                String s=sc.next();
                int sum=Integer.parseInt(s);
                
		printAllSubsets(n,arr, sum); 
	} 
} 
 
