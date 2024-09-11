class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int cnt = 0;
        int r = n-1;
        int l = n-1;
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();

        while(l >= 0){
            map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0)+1);
            if(map.size() == 3){
                while(map.size() == 3){
                    cnt += l+1;
                    map.put(s.charAt(r), map.get(s.charAt(r))-1);
                    if(map.get(s.charAt(r)) == 0){
                        map.remove(s.charAt(r));
                    }

                    r--;
                }
            }

            l--;
        }

        return cnt;
    }
}