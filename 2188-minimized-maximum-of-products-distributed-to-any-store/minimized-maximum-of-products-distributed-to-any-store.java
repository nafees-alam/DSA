class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int max = 0;
        for(int i = 0; i < quantities.length; i++){
            max = Math.max(max, quantities[i]);
        }

        int st = 1;
        int en = max;
        int ans = 0;

        while(st <= en){
            int mid = st + (en - st)/2;
            if(canDist(mid, n, quantities)){
                ans = mid;
                en = mid-1;
            } else{
                st = mid+1;
            }
        }

        return ans;
    }

    boolean canDist(int k, int shops, int[] arr){
        for(int val : arr){
            shops -= (val + k -1)/k;  //Math.ceil
            if(shops < 0){
                return false;
            }
        }

        return true;
    }
}