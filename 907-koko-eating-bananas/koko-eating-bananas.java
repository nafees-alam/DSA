class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = max(piles);
        int ans = 0;
        int s = 1;
        int e = max;
        while(s <= e){
            int mid = s + (e - s)/2;
            int tothrs = totHrs(piles, mid);
            if(tothrs <= h){
                e = mid-1;
            } else {
                s = mid+1;
            }
        }

        return s;
    }

    public int max(int[] arr){
        int max = 0;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(arr[i], max);
        }

        return max;
    }

    public int totHrs(int[] arr, int t){
        int tothrs = 0;
        for(int i = 0; i < arr.length; i++){
            tothrs += Math.ceil((double)(arr[i])/(double)(t));
        }

        return tothrs;
    }
}