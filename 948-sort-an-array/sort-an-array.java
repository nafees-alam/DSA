class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }

    static void mergeSort(int[] arr, int si, int ei){
        if(si >= ei){
            return;
        }
        int mid = si + (ei - si)/2;
        //left part
        mergeSort(arr, si, mid);
        //right part
        mergeSort(arr, mid+1, ei);
        //merge
        merge(arr, si, mid, ei);
    }

    static void merge(int[] arr, int si, int mid, int ei){
         int[] temp = new int[ei-si+1];

         int i = si;
         int j = mid+1;
         int k = 0;

         while(i <= mid && j <= ei){
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
         }

         while(i <= mid){
            temp[k++] = arr[i++];
         }
         while(j <= ei){
            temp[k++] = arr[j++];
         }

         for(i = si, k = 0; k < temp.length; i++, k++){
            arr[i] = temp[k];
         }
    }
}