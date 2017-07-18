package hw05;

import java.util.Arrays;

public class CountingSort {
	
	public static void main(String[] args) throws ArrayIndexOutOfBoundsException {

		int[] originalArray = { 6, 0, 2, 0, 1, 3, 4, 6, 1, 3, 2};
		System.out.println("\nThe original input array A: " + Arrays.toString(originalArray));
		System.out.println();
		
		int k = ComputeMax(originalArray);
		
		int[] arrayB = new int[originalArray.length];
		
		countingSort(originalArray, arrayB, k);
		
	}
	
	public static int ComputeMax(int []array){
		int maxValue = Integer.MIN_VALUE;
		for(int i = 0; i < array.length; i++){
			if(array[i] > maxValue)
				maxValue = array[i];
		}
		return maxValue;
	}
	
	//Counting Sort method
	public static void countingSort(int[] A, int[] B, int k){
		int[] C = new int[k+1];
		for(int i = 0; i <= k; i++){
			C[i] = 0;
		}
		
		for(int j = 0; j <= A.length-1; j++){
			C[A[j]] = C[A[j]]+1;
		}
		System.out.println("The counting array C after the counting (lines 4-5 in pseudocode) has completed: " + Arrays.toString(C)); 
		System.out.println();
		
		for (int i = 1; i <= k ; i++){
			C[i] = C[i] + C[i-1];
		}
		System.out.println("The counting array C after the summing (lines 7-8 in pseudocode) has completed: " + Arrays.toString(C));
		System.out.println();
		
		for(int j = A.length-1; j>=0; j--){
			B[C[A[j]]-1] = A[j];
			C[A[j]] = C[A[j]] - 1;
		}
		System.out.println("The final sorted array B after performing the Counting Sort algorithm: " + Arrays.toString(B));
		System.out.println();
	}
}
