package hw02;

public class SmallestAndGreatestNum {
	int number;

	public static int smallestNumber(int[] a) {
		int smallest = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] < smallest) {
				smallest = a[i];

			}

		}
		return smallest;
	}

	public static int largeNumber(int[] b) {
		int largest = b[0];
		int i = 1;
		while (i < b.length) {
			if (b[i] > largest) {
				largest = b[i];
			}
			i++;
		}
		return largest;
	}

	public static void main(String[] args) {

		int[] array = { 95, 70, 82, 125, 48, 63, 18, 53 };

		System.out.println("The smallest number is " + smallestNumber(array));
		System.out.println("The largest number is " + largeNumber(array));
	}
}
