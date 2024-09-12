class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int cnt = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < allowed.length(); i++){
            set.add(allowed.charAt(i));
        }

        for(int i = 0; i < words.length; i++){
            cnt++;
            String str = words[i];
            for(int j = 0; j < str.length(); j++){
                if(!set.contains(str.charAt(j))){
                    cnt--;
                    break;
                }
            }
        }

        return cnt;
    }
}