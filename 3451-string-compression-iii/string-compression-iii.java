class Solution {
    public String compressedString(String word) {
        String s = "";

        int cnt = 0;
        char ch = word.charAt(0);
        for(int i = 0; i < word.length(); i++){
            if(cnt == 9){
                s += 9;
                s += ch;
                cnt = 0;
            }
            if(word.charAt(i) == ch){
                cnt++;
            } else{
                if(cnt > 0){
                    s += cnt;
                    s += ch;
                }
                cnt = 1;
                ch = word.charAt(i);
            }
        }

        s += cnt;
        s += ch;

        return s;
    }
}