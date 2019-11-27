package cn.wxy.leetcode;

/**
 * 买卖股票的最佳时机
 *
 * @autor wxyidea
 * @create 2019-07-07
 **/
public class StockTrade {

    /**
     * 该题可以使用贪心算法来解决：用prices[i]表示今天的股票价格，prices[i+1]表示明天的股票价格，
     * 只要prices[i+1]>prices[i]，就在第i天买入，并在第i+1天卖出；重复上述过程，直到i=prices.length-2结束
     *
     * @param prices
     * @return 最大利润
     */
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1])
                maxProfit += prices[i + 1] - prices[i];
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        // test maxProfit method

    }
}
