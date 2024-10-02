class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int val : nums){
            set.add(val);
        }

        int maxlen = 0;

        for(int num : set){
            if(!set.contains(num-1)){
                int len = 1;
                while(set.contains(num+len)){
                    len++;
                }

                maxlen = Math.max(len, maxlen);
            }
        }

        return maxlen;
    }
}