class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        //boundary cases
        if(nums[0] != nums[1]){
            return nums[0];
        }
        if(nums[n-2] != nums[n-1]){
            return nums[n-1];
        }

        int s = 1;
        int e = n-2;

        while(s <= e){
            int mid = s + (e - s)/2;

            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]){
                return nums[mid];
            } else if(nums[mid] == nums[mid-1]){
                if((mid-1) % 2 == 0){
                    s = mid + 1;
                } else {
                    e = mid-1;
                }
            } else {
                if((mid+1) % 2 == 0){
                    e = mid - 1;
                } else {
                    s = mid+1;
                }
            }
        }

        return -1;
    }
}