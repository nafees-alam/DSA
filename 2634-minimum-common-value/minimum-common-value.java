class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int val : nums1){
            set.add(val);
        }
        for(int i = 0; i < nums2.length; i++){
            if(set.contains(nums2[i])){
                list.add(nums2[i]);
            }
        }

        if(list.size() == 0){
            return -1;
        }

        Collections.sort(list);
        return list.remove(0);
    }
}