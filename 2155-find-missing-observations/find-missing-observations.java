class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sum = n;  //taken 1 at each n size array and its sum
        for(int i = 0; i < m; i++){
            sum += rolls[i];
        }
        int total = (n+m)*mean;
        int diff = total - sum;
        if(diff > n*5 || diff < 0){ // n*5 beacause will take 1 in arrays.fill, so no need to check for mulplied by 6 rather one minus i.e 5;
            return new int[0];
        }

        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        System.out.println(Arrays.toString(ans));
        

        int k = 0;
        while(diff > 0){
            int inc = Math.min(diff, 6-ans[k]);
            ans[k] += inc;
            diff -= inc;
            if(ans[k] == 6){
                k++;
            }
        }
        return ans;
    }
}