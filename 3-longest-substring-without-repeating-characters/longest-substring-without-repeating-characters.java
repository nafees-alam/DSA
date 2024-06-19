class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        for(int right = 0; right < s.length(); right++){
            if(!map.containsKey(s.charAt(right)) || map.get(s.charAt(right)) < left){
                map.put(s.charAt(right), right);
                ans = Math.max(ans, right-left + 1);
            } else {
                left = map.get(s.charAt(right)) + 1;
                map.put(s.charAt(right), right);
            }
        }
        return ans;
    }
}