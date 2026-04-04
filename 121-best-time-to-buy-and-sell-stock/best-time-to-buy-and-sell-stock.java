class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int sell = 0;
        int ans = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < prices[buy]){
                buy = i;
                sell = i;
            }
            if(prices[sell] < prices[i]){
                sell = i;
            }
            ans = Math.max(prices[sell] - prices[buy], ans);
        }

        return ans;
    }
}