package hw02;

public class MergeSortAlgo {

	public static void main(String[] args) {
		int[] array = { 95, 70, 82, 125, 48, 67, 18, 53 };

		System.out.println("Before Sorting (Given Array): ");
		printArray(array);
		System.out.println();
		System.out.println();

		array = mergeSort(array);

		System.out.print("Merge Sort Result is ");
		printArray(array);

	}

	public static int[] mergeSort(int[] array) {
		if (array.length <= 1) {
			return array;
		}

		int midpoint = array.length / 2;

		int[] leftArray = new int[midpoint];// since int will return the non
											// exact value.. no floating
											// values... so is less than left
											// array in case of odd numbers
		int[] rightArray;// not initializing because we are not sure about
							// midpoint being exact half of array

		if (array.length % 2 == 0) {
			rightArray = new int[midpoint];
		} else {
			rightArray = new int[midpoint + 1];
		}
		int[] resultingArray = new int[array.length];

		for (int i = 0; i < midpoint; i++) {
			leftArray[i] = array[i];
		}

		int x = 0; // since right array starts with midpoint.. but to reach till
					// end of original array it needs to start with 0
		for (int j = midpoint; j < array.length; j++) {
			if (x < rightArray.length) {
				rightArray[x] = array[j];
				x++;
			}

		}
		// Recursion
		leftArray = mergeSort(leftArray);
		rightArray = mergeSort(rightArray);

		resultingArray = mergeArray(leftArray, rightArray);
		return resultingArray;
	}

	public static int[] mergeArray(int[] leftArray, int[] rightArray) {
		int lengthOfResultingArray = leftArray.length + rightArray.length;
		int[] resultingArray = new int[lengthOfResultingArray];
		int indexOfLeft = 0;
		int indexOfRight = 0;
		int indexOfResulting = 0;

		// sometimes right array might be large in length than left array .. so
		// OR condition
		while (indexOfLeft < leftArray.length || indexOfRight < rightArray.length) {
			// this is AND because index cannot be more than length and to find
			// both array still has elements
			if (indexOfLeft < leftArray.length && indexOfRight < rightArray.length) {
				// checking which is large or equal for sorting
				if (leftArray[indexOfLeft] <= rightArray[indexOfRight]) {
					resultingArray[indexOfResulting] = leftArray[indexOfLeft];
					indexOfLeft++;
					indexOfResulting++;
				} else {
					resultingArray[indexOfResulting] = rightArray[indexOfRight];
					indexOfRight++;
					indexOfResulting++;
				}
			} else if (indexOfLeft < leftArray.length) {
				resultingArray[indexOfResulting] = leftArray[indexOfLeft];
				indexOfLeft++;
				indexOfResulting++;
			} else if (indexOfRight < rightArray.length) {
				resultingArray[indexOfResulting] = rightArray[indexOfRight];
				indexOfRight++;
				indexOfResulting++;
			}

		}

		return resultingArray;
	}

	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
}
