package lab01;

public class InsertionSort {

	public static void main(String[] args) {

		int[] numList = { 100, 250, 30, 425, 5, 80, 900, 375};
		
		for (int i = 1; i < numList.length; i++) {
			int temp = numList[i];
			int j = 0;
			for (j = i - 1; j >= 0 && temp < numList[j]; j--) {
				numList[j + 1] = numList[j];
				
			}
			numList[j + 1] = temp;
		}
		System.out.print("Insertion Sort result is ");
		for (int i = 0; i < numList.length; i++) {
			System.out.print(numList[i] + ", ");
		}			
		}
		
	}

