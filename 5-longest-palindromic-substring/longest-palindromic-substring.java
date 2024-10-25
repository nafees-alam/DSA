class Solution {
    public String longestPalindrome(String s) {
        int maxlen = Integer.MIN_VALUE;
        int sp = 0;
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(solve(s, i, j, dp) == 1){
                    if(j-i+1 > maxlen){
                        maxlen = j-i+1;
                        sp = i;
                    }
                }
            }
        }

        return s.substring(sp, sp+maxlen);
    }

    int solve(String s, int i, int j, int[][] dp){
        if(i >= j){
            return 1;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s.charAt(i) == s.charAt(j)){
            return dp[i][j] = solve(s, i+1, j-1, dp);
        }

        return dp[i][j];
    }
}