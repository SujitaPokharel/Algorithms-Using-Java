package hw04;

import java.util.Arrays;

public class HeapSort {
	private static int heapSize;

	public static void heapSort(int array[]) {
		buildMaxHeap(array);
		System.out.println("\nThe array after buildMaxHeap has completed: " + Arrays.toString(array));

		for (int i = heapSize - 1; i >= 0; i--) {
			swap(array, 0, i);
			heapSize = heapSize - 1;
			maxHeapify(array, 0);
		}
	}

	public static void buildMaxHeap(int array[]) {
		heapSize = array.length;
		for (int i = (array.length / 2) - 1; i >= 0; i--)
			maxHeapify(array, i);

	}

	public static void maxHeapify(int array[], int i) {

		int left = left(i);
		int right = right(i);
		int largest = -1;

		if (left <= heapSize && array[left] > array[i])
			largest = left;
		else
			largest = i;

		if (right <= heapSize && array[right] > array[largest])
			largest = right;

		if (largest != i) {
			swap(array, i, largest);
			maxHeapify(array, largest);
		}
	}

	public static int left(int i) {
		return 2 * i + 1;
	}

	public static int right(int i) {
		return 2 * i + 2;
	}

	/* Function to swap two numbers in an array */
	public static void swap(int arr[], int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static void main(String[] args) {

		int[] originalArray = { 10, 15, 8, 12, 5, 2, 20, 7, 18 };

		System.out.println("\nThe original input array: " + Arrays.toString(originalArray));

		heapSort(originalArray);
		System.out.println("\nThe final sorted array after performing the Heapsort algorithm: " + Arrays.toString(originalArray));

	}
}
