class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int cnt = 0;
        int[] idxCounter = new int[]{-1, -1, -1};

        for(int i = 0; i < n; i++){
            idxCounter[s.charAt(i) - 'a'] = i;
            if(idxCounter[0] != -1 && idxCounter[1] != -1 && idxCounter[2] != -1){
                cnt += (1 + Math.min(idxCounter[0], Math.min(idxCounter[1], idxCounter[2])));
            }
        }

        return cnt;
    }
}