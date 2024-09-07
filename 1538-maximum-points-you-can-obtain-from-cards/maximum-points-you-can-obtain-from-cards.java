class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int n = cardPoints.length;
        int r = n-1;

        for(int i = 0; i < k; i++){
            sum += cardPoints[i];
        }

        int max = sum;

        for(int i = k-1; i >= 0; i--){
            sum -= cardPoints[i];
            sum += cardPoints[r--];

            max = Math.max(sum, max);
        }

        return max;
    }
}