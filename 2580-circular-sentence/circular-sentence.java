class Solution {
    public boolean isCircularSentence(String s) {
        String[] str = s.split(" ");

        if(str.length == 1 && str[0].charAt(0) == str[0].charAt(str[0].length()-1)){
            return true;
        } else if(str.length == 1){
            return false;
        }
        
        char ch = str[0].charAt(str[0].length()-1);
        for(int i = 1; i < str.length; i++){
            if(str[i].charAt(0) != ch){
                return false;
            }
            ch = str[i].charAt(str[i].length()-1);
        }
        if(ch == str[0].charAt(0))
        return true;

        return false;
    }
}