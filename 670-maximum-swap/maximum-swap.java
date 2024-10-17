class Solution {
    public int maximumSwap(int num) {
        int[] arr = Arrays.stream(String.valueOf(num).split(""))
                     .mapToInt(Integer::parseInt) 
                     .toArray();
        
        int[] maxRight = new int[arr.length];
        maxRight[arr.length-1] = arr.length-1;
        for(int i = arr.length-2; i >= 0; i--){
            if(arr[i] <= arr[maxRight[i+1]]){
                maxRight[i] = maxRight[i+1];
            } else{
                maxRight[i] = i;
            }
        }

        for(int i = 0; i < arr.length; i++){
            if(arr[i] < arr[maxRight[i]]){
                int temp = arr[i];
                arr[i] = arr[maxRight[i]];
                arr[maxRight[i]] = temp;
                break;
            }
        }

        int ans = 0;
        int exp = arr.length-1;
        for(int k = 0; k < arr.length; k++){
            ans += Math.pow(10, exp) * arr[k];
            exp--;
        }

        return ans;
    }
}