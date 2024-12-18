class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(prices[i] - prices[j] >= 0){
                    ans[i] = prices[i] - prices[j];
                    break;
                }
            }

            if(ans[i] == -1) ans[i] = prices[i];
        }

        return ans;
    }
}