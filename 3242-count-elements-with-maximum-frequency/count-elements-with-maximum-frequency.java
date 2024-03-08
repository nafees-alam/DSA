class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int val : nums){
            if(map.containsKey(val)){
                map.put(val, map.get(val) + 1);
            } else {
                map.put(val , 1);
            }
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