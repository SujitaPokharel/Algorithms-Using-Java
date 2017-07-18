package lab01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberOfCombinations {

	public static double combination(int n, int k) {
		
		double result = 0.0;
		int x = n - k;
		long nFactorial = recursion(n);
		long kFactorial = recursion(k);
		long xFactorial = recursion(x);
		result = nFactorial/ (kFactorial * xFactorial);
		return result;
	}
	
	public static long recursion(int a){ 
		
			long fact = a;
			long i = a;
			while (i > 1){
				fact = fact * (i - 1);
				i--;
			}
			return fact;
	}
	
	public static void startApplication(){
		
		System.out.println("Please Enter number of combinations: ");
	    Scanner input = new Scanner(System.in);
	    try{
		    int n = input.nextInt();
		    System.out.println("Please Enter number of objects taken at once: ");
			int k = input.nextInt();
			if(n>k && (n>0 && k>0)){
				System.out.println("The number of combinations for " + n + " items taken " + k + " at a time is " + combination(n, k));
			}
			else{
				System.out.println("Invalid Numbers! Please input positive Integers.");
		    	System.out.println();
				startApplication();
			}
	    }catch(InputMismatchException ex){
	    	System.out.println("Input is not valid. Please, enter only numbers.");
	    	System.out.println();
	    	startApplication();
	    }
		input.close();		
		
	}

	public static void main(String[] args) {
		
		startApplication();
	}

}
