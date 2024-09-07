class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int maxCnt = 0;
        int n = s.length();

        while(r < n){
            if(map.containsKey(s.charAt(r)) && map.get(s.charAt(r)) >= l){
                l = map.get(s.charAt(r)) + 1;
            }

            maxCnt = Math.max(r-l+1, maxCnt);
            map.put(s.charAt(r), r);
            r++;
        }

        return maxCnt;
    }
}