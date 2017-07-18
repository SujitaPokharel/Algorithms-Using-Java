package hw05;

import java.util.Arrays;
import java.util.Random;

public class RandomizedQuickSort {

	public static void main(String[] args) throws ArrayIndexOutOfBoundsException {

		int[] originalArray = { 4, 1, 3, 2, 16, 9, 10, 14, 8, 7 };
		int p = 0;
		int r = originalArray.length - 1;

		System.out.println("\nThe original input array: " + Arrays.toString(originalArray));

		randomizedQuicksort(originalArray, p, r);
		System.out.println();
		System.out.println("\nThe final sorted array after performing the RandomizedQuickSort algorithm: " + Arrays.toString(originalArray));

	}
	
	
	//RandomizedQuickSort Method
	public static void randomizedQuicksort(int array[], int p, int r) {
		int q;
		if (p < r) {
			
			q = randomizedPartition(array, p, r);
			
			System.out.println("\n The Sub-Arrays after each of the randomizedPartition calls has completed:");
			System.out.print("Left: ");
			display(array, p, q - 1);
			System.out.print("Right: ");
			display(array, q + 1, r);
			
			quickSort(array, p, q - 1);
			quickSort(array, q + 1, r);
			
		}
	}
	//Randomized Partition method
	public static int randomizedPartition(int array[], int p, int r) {

		int i = random(array) /* p-1 */;
		System.out.println("Random Element is: " + array[i]);
		swap(array, i, r);
		return partition(array, p, r);
	}
	//To display the sub-arrays 
	public static void display(int array[], int m, int n) {
		for (int j = m; j <= n; j++)
			System.out.print(array[j] + " ");
	}	
	//To pick the elements randomly to make it Pivot element
	public static int random(int[] array) {
		Random generator = new Random();
		int rand = generator.nextInt(array.length);
		return array[rand];
	}
	//To swap the elements
	public static void swap(int arr[], int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		
	}
	//The simple partition method used in Randomized Partition method (Of simple Quick Sort)
	public static int partition(int array[], int p, int r) {
		int pivot = array[r];
		int i = p - 1;
		for (int j = p; j <= r - 1; j++) {
			if (array[j] < pivot) {
				i = i + 1;
				swap(array, i, j);
			}
		}
		swap(array, i + 1, r);
		return i + 1;
	}
	//The simple quickSort method used in Randomized quickSort method
	public static void quickSort(int arr[], int p, int r) {

		if (p < r) {
			
			int q = partition(arr, p, r);
			
			System.out.println();
			System.out.println("\n The Sub-Arrays after each partition calls");
			System.out.print("Left: ");
			display(arr, p, q - 1);
			System.out.print("Right: ");
			display(arr, q + 1, r);
			
			quickSort(arr, p, q - 1);
			quickSort(arr, q + 1, r);
		}

	}
}
