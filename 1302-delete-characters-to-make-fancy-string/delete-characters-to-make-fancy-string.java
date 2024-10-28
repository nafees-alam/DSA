class Solution {
    public String makeFancyString(String s) {
        char[] ch = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        char prevChar = '#';
        for(int i = 0; i < ch.length; i++){
            if(ch[i] == prevChar){
                cnt++;
                if(cnt == 3){
                    ch[i] = '$';
                    cnt--;
                }
            } else{
                cnt = 1;
                prevChar = ch[i];
            }
        }

        for(int i = 0; i < ch.length; i++){
            if(ch[i] == '$'){
                continue;
            }

            sb.append(ch[i]);
        }

        return sb.toString();
    }
}