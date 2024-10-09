class Solution {
    public int minAddToMakeValid(String s) {
        int openBrac = 0;
        int closeBrac = 0;
        int ans = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                openBrac++;
            } else {
                if(openBrac > 0){
                    openBrac--;
                } else {
                    closeBrac++;
                }
            }
        }

        return openBrac + closeBrac;
    }
}