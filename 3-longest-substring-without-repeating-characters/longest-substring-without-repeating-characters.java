class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxCnt = 0;
        for(int i = 0; i < s.length(); i++){
            HashSet<Character> set = new HashSet<>();
            int cnt = 0;
            for(int j = i; j < s.length(); j++){
                if(set.contains(s.charAt(j))){
                    break;
                }
                set.add(s.charAt(j));
                cnt++;
            }

            maxCnt = Math.max(cnt, maxCnt);
        }

        return maxCnt;
    }
}