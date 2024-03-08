class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int val : nums){
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        int max = 0;
        for(Integer i : map.keySet()){
             max = Math.max(map.get(i), max);
        }

        int count = 0;
        for(Integer i : map.keySet()){
             if(map.get(i) == max){
                 count += max;
             }
        }

        return count;
    }
}