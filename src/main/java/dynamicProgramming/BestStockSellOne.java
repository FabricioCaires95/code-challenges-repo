package dynamicProgramming;

public class BestStockSellOne {

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6};
        System.out.println(maxProfit(prices));

        System.out.println(maxProfit2(prices));

        System.out.println(maxProfit3(prices));
    }


    public static int maxProfit(int[] prices) {
        int smallerPrice = Integer.MAX_VALUE;
        int overallProfit = 0;
        int priceToSold = 0;

        for (int price: prices) {
            if (price < smallerPrice) {
                smallerPrice = price;
            }
            priceToSold = price - smallerPrice;

            if (priceToSold > overallProfit) {
                overallProfit = priceToSold;
            }
        }

        return overallProfit;
    }

    //{7, 1, 5, 3, 6, 4};
    public static int maxProfit2(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }

            maxProfit = Math.max(maxProfit, prices[i] - minPrice);

        }
        return maxProfit;
    }

    public static int maxProfit3(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }
}
