class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] freq = new int[k];

        for(int i = 0; i < arr.length; i++){
            int rem = ((arr[i] % k) + k) % k;
            freq[rem]++;
        }

        for(int i = 1; i < k; i++){
            if(freq[i] != freq[k-i]){
                return false;
            }
        }

        if(freq[0] % 2 != 0){
            return false;
        }

        return true;
    }
}