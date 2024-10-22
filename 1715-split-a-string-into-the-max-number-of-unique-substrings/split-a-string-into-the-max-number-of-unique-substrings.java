class Solution {
    public int maxUniqueSplit(String s) {
        HashSet<String> HashSet = new HashSet<>();
        int[] maxCnt = {0};
        solve(s, HashSet, 0, 0, maxCnt);
        return maxCnt[0];
    }

    void solve(String s, Set<String> set, int idx, int cnt, int[] maxCnt){
        if(idx >= s.length()){
            maxCnt[0] = Math.max(maxCnt[0], cnt);
            return;
        }

        for(int j = idx; j < s.length(); j++){
            String str = s.substring(idx, j+1);
            if(!set.contains(str)){
                set.add(str);
                solve(s, set, j+1, cnt+1, maxCnt);
                set.remove(str);
            }
        }
    }
}