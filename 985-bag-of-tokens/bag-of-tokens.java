class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int res = 0;
        int score = 0;
        int  l = 0;
        int r = tokens.length - 1;
        Arrays.sort(tokens);

        while(l <= r){
            if(power >= tokens[l]){
                power -= tokens[l];
                l += 1;
                score += 1;
            } else if(score > 0){
                power += tokens[r];
                r -= 1;
                score -= 1;
            } else {
                break;
            }
            res = Math.max(res,score);
        }

        return res;
    }
}