public class MaxProfit {
    /*
        완전 탐색: 시간초과
     */
    public static int maxProfitBruteForce(int[] prices) {
        int result = 0;
        if (prices.length < 2) {
            return 0;
        }
        for (int i = 0; i < prices.length; i++) {
            int oneBuy = prices[i];
            int oneSell;
            int twoBuy;
            int twoSell;
            for (int j = i + 1; j < prices.length; j++) {
                oneSell = prices[j];
                if (j + 2 >= prices.length) {
                    result = Math.max(result, (oneSell - oneBuy));
                } else {
                    for (int r = j + 1; r < prices.length; r++) {
                        twoBuy = prices[r];
                        for (int k = r + 1; k < prices.length; k++) {
                            twoSell = prices[k];
                            if ((oneSell - oneBuy) >= 0 && (twoSell - twoBuy) >= 0) {
                                result = Math.max(result, (oneSell - oneBuy) + (twoSell - twoBuy));
                            } else if ((oneSell - oneBuy) >= 0) {
                                result = Math.max(result, (oneSell - oneBuy));
                            }
                        }
                    }
                }
            }
        }
        return result;
    }


    /*
        dp로 풀기
        Runtime: 3 ms, faster than 99.29% of Java online submissions for Best Time to Buy and Sell Stock III.
        Memory Usage: 55.9 MB, less than 25.09% of Java online submissions for Best Time to Buy and Sell Stock III.
     */
    public static int maxProfitDp(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int oneBuy = -100000;
        int oneSell = 0;
        int twoBuy = -100000;
        int twoSell = 0;

        for (int price : prices) {
            oneBuy = Math.max(oneBuy, -price);
            oneSell = Math.max(oneSell, price + oneBuy);
            twoBuy = Math.max(twoBuy, oneSell - price);
            twoSell = Math.max(twoSell, twoBuy + price);
        }

        return twoSell;
    }

    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfitBruteForce(prices));
        System.out.println(maxProfitDp(prices));
    }
}
