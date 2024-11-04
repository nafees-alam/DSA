class Solution {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();

        int cnt = 0;
        char ch = word.charAt(0);
        for(int i = 0; i < word.length(); i++){
            if(cnt == 9){
                sb.append(cnt);
                sb.append(ch);
                cnt = 0;
            }
            if(word.charAt(i) == ch){
                cnt++;
            } else{
                if(cnt > 0){
                    sb.append(cnt);
                    sb.append(ch);
                }
                cnt = 1;
                ch = word.charAt(i);
            }
        }

        sb.append(cnt);
        sb.append(ch);

        return sb.toString();
    }
}