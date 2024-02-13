class Solution {
    public String firstPalindrome(String[] words) {
        for(int i = 0; i < words.length; i++){
            if(isPalindrome(words[i])){
                return words[i];
            }
        }
        return "";
    }

    static boolean isPalindrome(String str){
        for(int i = 0, j = str.length()-1; i < str.length() && j >= 0; i++, j--){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
        }

        return true;
    }
}