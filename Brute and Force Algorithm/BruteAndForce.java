package hw02;

public class BruteAndForce {
	public static void main(String[] args) {

		int[] price = { 100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106, 101, 79, 94, 90, 97 };

		System.out.println("Given List of price from Day 0 to Day 16: ");

		for (int i = 0; i < price.length; i++) {
			System.out.print(price[i] + " ");
		}
		System.out.println();
		System.out.println();

		int lengthOfPrice = price.length;

		System.out.println("The change in price daily form Day 1 to Day 16: ");

		int[] profitLossArray = new int[lengthOfPrice - 1];
		
		for (int i = 0; i < lengthOfPrice - 1; i++) {

			profitLossArray[i] = price[i + 1] - price[i];

			System.out.print(profitLossArray[i] + " ");
		}
		
		System.out.println();
		System.out.println();
		maxTotalProfit(profitLossArray);

	}

	public static int maxTotalProfit(int[] profitLossArray) {

		int maxProfit = Integer.MIN_VALUE;
		int maxBuyDate = 0;
		int maxSellDate = 0;
		int actualBuyDate = 0;
		int actualSellDate = 0;
		int sum = 0;
		int actualProfit = 0;

		for (int i = 0; i < profitLossArray.length - 1; i++) {
			sum = profitLossArray[i] + profitLossArray[i + 1];
			actualProfit = sum;
			actualBuyDate = i;
			actualSellDate = i + 1;
			for (int j = i + 2; j < profitLossArray.length - 1; j++) {
				actualProfit += profitLossArray[j];

				if (sum < actualProfit) {
					sum = actualProfit;
					actualSellDate = j;
				}
			}

			if (sum > maxProfit) {
				maxProfit = sum;
				maxSellDate = actualSellDate + 1;
				maxBuyDate = actualBuyDate;
			}

		}
		System.out.println("The maximum profit is " + maxProfit + ".");
		System.out.println("Buy on day " + maxBuyDate + " and sell on day " + maxSellDate + ".");
		return maxProfit;
	}

}
