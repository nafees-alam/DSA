class Solution {
    public int minInsertions(String s) {
        int n = s.length();

        int[][] dp = new int[n][n];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }

        int ans = n - lps(s, 0, n-1, dp);
        return ans;
    }

    public int lps(String str, int s, int e, int[][] dp){
        if(s > e){
            return 0;
        }
        if(s == e){
            return 1;
        }

        if(dp[s][e] != -1){
            return dp[s][e];
        }

        if(str.charAt(s) == str.charAt(e)){
            return dp[s][e] = 2 + lps(str, s+1, e-1, dp);
        }

        return dp[s][e] = Math.max(lps(str, s+1, e, dp), lps(str, s, e-1, dp));
    }
}