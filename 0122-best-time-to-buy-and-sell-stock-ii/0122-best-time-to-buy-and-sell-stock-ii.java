class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buy = prices[0];
        int sell = prices[0];

        for(int i = 1; i < prices.length; i++){
            int todayPrice = prices[i];

            if(todayPrice < sell){
                maxProfit += sell - buy;
                buy = todayPrice;
                sell = todayPrice;
            }
            else{
                sell = Math.max(sell, todayPrice);
            }
        }

        maxProfit += sell - buy;

        return maxProfit;
    }
}