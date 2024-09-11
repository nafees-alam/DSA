class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(isPalindrome(s, i, j)){
                        String temp = s.substring(i, j+1);
                        if(temp.length() > ans.length()){
                            ans = temp;
                        }
                    }
                }
            }
        }

        return ans;
    }

    public boolean isPalindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}