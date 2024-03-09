class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int min = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;

        while(i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                min = Math.min(nums1[i], min);
                j++;
            } else if(nums1[i] > nums2[j]){
                j++;
            } else {
                i++;
            }
        }

        if(min == Integer.MAX_VALUE){
            return -1;
        }
        return min;
    }
}