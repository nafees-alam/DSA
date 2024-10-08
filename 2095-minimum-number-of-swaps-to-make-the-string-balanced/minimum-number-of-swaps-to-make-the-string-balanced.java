class Solution {
    public int minSwaps(String s) {
        char[] ch = s.toCharArray();
        int closeBracket = 0;
        int openBracket = 0;
        int j = s.length()-1;
        int ans = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(i > j){
                break;
            }
            if(ch[i] == '['){
                openBracket++;
            } else {
                closeBracket++;
            }

            if(closeBracket > openBracket){
                while(j > i){
                    if(ch[j] == '['){
                        swap(ch, i, j);
                        ans++;
                        openBracket++;
                        closeBracket--;
                        break;
                    }
                    j--;
                }
            }
        }

        return ans;
    }

    void swap(char[] ch, int i, int j){
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
}