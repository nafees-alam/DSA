class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n][m];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }

        int cnt = lcs(word1, word2, n-1, m-1, dp);

        return ((n - cnt) + (m - cnt));
    }

    public int lcs(String s1, String s2, int idx1, int idx2, int[][] dp){
        if(idx1 < 0 || idx2 < 0){
            return 0;
        }
        if(dp[idx1][idx2] != -1){
            return dp[idx1][idx2];
        }

        if(s1.charAt(idx1) == s2.charAt(idx2)){
            return dp[idx1][idx2] = 1 + lcs(s1, s2, idx1-1, idx2-1, dp);
        }

        return dp[idx1][idx2] = Math.max(lcs(s1, s2, idx1-1, idx2, dp), lcs(s1, s2, idx1, idx2-1, dp));
    }
}