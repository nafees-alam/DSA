class Solution {
    public int heightChecker(int[] heights) {
        int ans = 0;
        int n = heights.length;

        int[] expected = heights.clone();
        Arrays.sort(expected);
        for(int i = 0; i < n; i++){
            if(heights[i] != expected[i]){
                ans++;
            }
        }

        return ans;
    }
}