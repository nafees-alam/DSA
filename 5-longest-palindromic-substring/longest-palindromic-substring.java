class Solution {
    public String longestPalindrome(String s) {
        int maxlen = Integer.MIN_VALUE;
        int sp = 0;
        int n = s.length();

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(solve(s, i, j) == 1){
                    if(j-i+1 > maxlen){
                        maxlen = j-i+1;
                        sp = i;
                    }
                }
            }
        }

        return s.substring(sp, sp+maxlen);
    }

    int solve(String s, int i, int j){
        if(i >= j){
            return 1;
        }
        if(s.charAt(i) == s.charAt(j)){
            return solve(s, i+1, j-1);
        }

        return 0;
    }
}