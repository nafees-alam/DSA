class Solution {
    public long minimumSteps(String s) {
        char[] arr = s.toCharArray();
        int swapCnt = 0;
        long ans = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == '0'){
                ans += swapCnt;
            } else {
                swapCnt++;
            }
        }

        return ans;
    }
}