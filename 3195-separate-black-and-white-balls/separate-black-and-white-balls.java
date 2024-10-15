class Solution {
    public long minimumSteps(String s) {
        char[] arr = s.toCharArray();
        int swapIdx = -1;
        long ans = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == '1'){
                swapIdx = i;
                break;
            }
        }

        for(int i = 0, j = 1; i < arr.length && j < arr.length; i++, j++){
            if(arr[i] == '1' && arr[j] == '0'){
                slide(arr, i, j);
                ans += j - swapIdx;
                swapIdx++;
            }
        }

        return ans;
    }

    void slide(char[] arr, int i, int j){
        char temp = arr[j];
        for(int k = j; k > i; k--) {
            arr[k] = arr[k - 1];
        }
        arr[i] = temp;
    }
}