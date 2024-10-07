class Solution {
    public int minLength(String s) {
        int n = s.length();
        int i = 0;
        while(s.length() > 0 && i < s.length()-1){
            if(s.substring(i, i+2).equals("AB") || s.substring(i, i+2).equals("CD")){
                s = s.substring(0, i) + s.substring(i+2);
                i=0;
            } else {
                i++;
            }
        }

        return s.length();
    }
}