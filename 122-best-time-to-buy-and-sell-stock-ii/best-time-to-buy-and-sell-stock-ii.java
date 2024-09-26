class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int start = prices[0];
        for(int i = 0; i < prices.length; i++){
            if(start > prices[i]){
                start = prices[i];
            } else {
                ans += prices[i] - start;
                start = prices[i];
            }
        }

        return ans;
    }
}