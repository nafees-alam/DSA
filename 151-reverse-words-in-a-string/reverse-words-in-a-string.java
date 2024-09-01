class Solution {
    public String reverseWords(String s) {
        String ans = "";
        String[] str = s.split(" +");
        for(int i = str.length-1; i >= 0; i--){
            ans += str[i] + " ";
        }
        ans = ans.trim();
        return ans;
    }
}