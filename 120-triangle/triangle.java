class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return helper(triangle, 0, 0, dp);
    }

    int helper(List<List<Integer>> list, int idx, int i, int[][] dp){
        if(idx == list.size()){
            return 0;
        }

        if(dp[idx][i] != -1){
            return dp[idx][i];
        }

        int first = list.get(idx).get(i) + helper(list, idx+1, i, dp);
        int second = list.get(idx).get(i) + helper(list, idx+1, i+1, dp);

        return dp[idx][i] = Math.min(first, second);
    }
}