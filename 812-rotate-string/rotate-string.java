class Solution {
    public boolean rotateString(String s, String goal) {
        int st = -1;
        if(s.length() != goal.length()){
            return false;
        }
        
        s += s;

        return s.contains(goal);
    }
}