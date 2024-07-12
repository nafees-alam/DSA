class Solution {
    public int[] sortArray(int[] nums) {
       mergeSort(nums, 0, nums.length-1);
       return nums;
    }

    static void merge(int[] arr, int si, int mid, int ei){
        int[] temp = new int[ei - si + 1];

        int i = si;
        int j = mid+1;
        int k = 0;

        while(i <= mid && j <= ei){
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
            } else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        //if some are left
        while(i <= mid){
            temp[k++] = arr[i++];
        }
        while(j <= ei){
            temp[k++] = arr[j++];
        }

        //add temp to arr
        for(int l = 0, m = si; l < temp.length; m++, l++){
            arr[m] = temp[l];
        }
    }

    static void mergeSort(int[] arr, int si, int ei){
        if(si >= ei){
            return;
        }

        int mid = si+(ei-si)/2;
        //left
        mergeSort(arr, si, mid);
        //right
        mergeSort(arr, mid+1, ei);
        //merge left+right
        merge(arr, si, mid, ei);
    }
}