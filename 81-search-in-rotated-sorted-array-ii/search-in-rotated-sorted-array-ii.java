class Solution {
    public boolean search(int[] nums, int target) {
        int pivot = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i-1] > nums[i]){
                pivot = i;
            }
        }

        return BinarySearch(nums,0,pivot-1,target) || BinarySearch(nums,pivot,nums.length-1,target);
    }

    static boolean BinarySearch(int[] nums, int start, int end, int target){
        while(start <= end){
            int mid = start + (end - start)/2;
            if(target == nums[mid]){
                return true;
            }
            else if(target > nums[mid]){
                start = mid+1;
            } else{
                end = mid-1;
            }
        }

        return false;
    }
}