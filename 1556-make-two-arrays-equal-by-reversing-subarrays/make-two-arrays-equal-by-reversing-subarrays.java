class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        for(int i = 0; i < arr.length; i++){
            int num = target[i];
            for(int j = i; j < arr.length; j++){
                if(arr[j] == num){
                    reverse(arr, i, j);
                    break;
                }
            }
        }

        for(int i = 0; i < arr.length; i++){
            if(arr[i] != target[i]){
                return false;
            }
        }

        return true;
    }

    static void reverse(int[] arr, int i, int j){
        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}