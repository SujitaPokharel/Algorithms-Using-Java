package hw03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PermuteArrays {
	public static void main(String[] args) {
		System.out.println("PERMUTE BY SORTING");
		System.out.println();
		// hardcoded array
		int[] permuteAarray = arrayForPermuteBySorting();
		System.out.println("Original Array (Before permuteBySorting) is : " + Arrays.toString(permuteAarray));

		permuteBySorting(permuteAarray);
		System.out.println();

		// Random generated array
		int[] permuteRandomAarray = randomArrayForPermuteBySorting();
		System.out.println("Randomly generated Original Array (Before permuteBySorting) is : " + Arrays.toString(permuteRandomAarray));

		permuteBySorting(permuteRandomAarray);
		System.out.println();
		
		System.out.println();
		System.out.println("RANDOMIZE IN PLACE");
		System.out.println();
		// hardcoded array
		int[] randomizeInPlaceArray = arrayForRandomizeInPlace();
		System.out.println("Original Array (Before randomizeInPlace) is: " + Arrays.toString(randomizeInPlaceArray));

		System.out.print("Randomized Array is: ");
		randomizeInPlace(randomizeInPlaceArray);
		System.out.println();

		// Random generated array
		int[] randomizeInPlaceRandomArray = RandomArrayForRandomizeInPlace();
		System.out.println("Randomly generated Original Array (Before randomizeInPlace) is: " + Arrays.toString(randomizeInPlaceRandomArray));

		System.out.print("The Randomized Array is: ");
		randomizeInPlace(randomizeInPlaceRandomArray);
		System.out.println();

	}

	public static int[] arrayForPermuteBySorting() {
		int[] arrayForPermuteBySorting = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
		return arrayForPermuteBySorting;
	}

	public static int[] randomArrayForPermuteBySorting() {
		int[] randomArrayForPermuteBySorting = new int[20];
		for (int i = 0; i < randomArrayForPermuteBySorting.length; i++) {
			randomArrayForPermuteBySorting[i] = (int) (Math.random() * 20);
		}
		return randomArrayForPermuteBySorting;
	}

	public static int[] arrayForRandomizeInPlace() {
		int[] arrayForRandomizeInPlace = { 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120 };
		return arrayForRandomizeInPlace;
	}

	public static int[] RandomArrayForRandomizeInPlace() {
		int[] RandomArrayForRandomizeInPlace = new int[20];
		for (int i = 0; i < RandomArrayForRandomizeInPlace.length; i++) {
			RandomArrayForRandomizeInPlace[i] = (int) (Math.random() * (120 - 100) + 100);
		}
		return RandomArrayForRandomizeInPlace;
	}

	public static void permuteBySorting(int[] list) {

		// Randomly generated priorities
		int[] randomArray = new int[20];
		for (int j = 0; j < randomArray.length; j++) {
			randomArray[j] = (int) (Math.random() * ((int) Math.pow(20, 3)));
		}
		System.out.println("Random Priorities Array is :" + Arrays.toString(randomArray));

		int[] nums = list; // array
		int length = nums.length;
		// new list
		List<PrioritizedValue<Integer>> comparatorList = new ArrayList<PrioritizedValue<Integer>>(length);

		// putting values into list
		for (int i = 0; i < length; i++) {
			comparatorList.add(new PrioritizedValue<Integer>(nums[i], randomArray[i]));
		}
		Collections.sort(comparatorList);
		int[] permuted = new int[length];
		for (int i = 0; i < length; i++) {
			permuted[i] = comparatorList.get(i).value;
		}
		System.out.println("Permuted Array is: " + Arrays.toString(permuted));

	}

	public static void randomizeInPlace(int[] list) {
		int[] array = list;
		Random r = new Random();
		for (int i = array.length - 1; i > 0; i--) {

			int k = r.nextInt(i);

			int temp = array[k];

			array[k] = array[i];
			array[i] = temp;

		}
		System.out.println(Arrays.toString(array));

	}

	static class PrioritizedValue<T> implements Comparable<PrioritizedValue<T>> {

		final T value;
		final int priority;

		PrioritizedValue(T value, int priority) {
			this.value = value;
			this.priority = priority;
		}

		@Override
		public int compareTo(PrioritizedValue other) {
			return Integer.valueOf(this.priority).compareTo(other.priority);
		}
	}
}
