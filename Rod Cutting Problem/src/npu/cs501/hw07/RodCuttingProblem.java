package npu.cs501.hw07;

import java.util.Arrays;

public class RodCuttingProblem {

	static int cutRodCounter = 0;

	static int cutMemorizedRodCntr = 0;

	static int[] s = new int[11];

	private static int cutRod(int p[], int n) {
		cutRodCounter++;
		if (n <= 0)
			return 0;
		int q = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++)
			q = Math.max(q, p[i] + cutRod(p, n - i - 1));

		return q;
	}

	private static int memoizedCutRod(int[] p, int n) {
		int r[] = new int[n + 1];
		Arrays.fill(r, Integer.MIN_VALUE);
		return memoizedCutRodAux(p, n, r);
	}

	private static int memoizedCutRodAux(int[] p, int n, int[] r) {
		cutMemorizedRodCntr++;

		int q;
		if (r[n] >= 0)
			return r[n];
		if (n == 0)
			q = 0;
		else {
			q = Integer.MIN_VALUE;
			for (int i = 1; i <= n; i++) {

				int temp = p[i - 1] + memoizedCutRodAux(p, n - i, r);
				if (q < temp) {
					q = temp;
					s[n] = i;
				}
			}
		}
		r[n] = q;
		return q;
	}

	private static void printCutRodSolution(int n) {
		while (n > 0) {
			System.out.print(s[n] + " ");
			n = n - s[n];
		}
	}

	public static void main(String[] args) {
		int priceArray[] = { 1, 5, 8, 9, 10, 17, 17, 20, 24, 30 };

		System.out.println("Length\tRev CR\tNum Calls CR\tRev MCR\tNum Calls MCR\tCut Pieces");
		int optRev = 0;

		for (int i = 1; i <= 10; i++) {
			cutRodCounter = 0;
			cutMemorizedRodCntr = 0;
			System.out.print(i + "\t");
			optRev = cutRod(priceArray, i);
			System.out.print(optRev + "\t");
			System.out.print(cutRodCounter + "\t\t");
			optRev = memoizedCutRod(priceArray, i);
			System.out.print(optRev + "\t");
			System.out.print(cutMemorizedRodCntr + "\t\t");
			printCutRodSolution(i);
			System.out.println();
		}
	}
}
