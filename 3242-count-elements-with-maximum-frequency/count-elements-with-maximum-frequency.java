class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        //putting nums array values in map
        for(int val : nums){
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        //getting the max frequency of a number
        int max = 0;
        for(Integer i : map.keySet()){
             max = Math.max(map.get(i), max);
        }

        //getting the total freq if other elememts have same--
        //--max freq by adding their frequencies as total freq
        int totalFreq = 0;
        for(Integer i : map.keySet()){
             if(map.get(i) == max){
                 totalFreq += max;
             }
        }

        return totalFreq;
    }
}