public class Question63 {
    /**
     *                买卖股票的最佳时机
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。如果你最多只
     * 允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的
     * 最大利润。注意你不能在买入股票前卖出股票。
     */

    //leetcode
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;

        int maxCur = 0, maxSoFar = 0;
        for (int i = 1; i < prices.length; i++) {
            maxCur += prices[i] - prices[i - 1];
            maxCur = Math.max(0, maxCur);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }


    //剑指Offer
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;

        int min = prices[0]; //保存数组前i-1个数字的最小值，即之前股票的最低价
        int maxDiff = prices[1] - min;

        for (int i = 2; i < prices.length; i++) {
            if (prices[i - 1] < min)
                min = prices[i - 1];

            int curDiff = prices[i] - min;
            if (curDiff > maxDiff)
                maxDiff = curDiff;
        }
        return maxDiff > 0 ? maxDiff : 0;
    }
}
