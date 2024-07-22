class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        TreeMap<Integer, String> tm = new TreeMap<>(Collections.reverseOrder());
        String[] ans = new String[names.length];

        for(int i = 0; i < names.length; i++){
            tm.put(heights[i], names[i]);
        }

        int j = 0;
        for(Integer key : tm.keySet()){
            ans[j] = tm.get(key);
            j++;
        }

        return ans;
    }
}