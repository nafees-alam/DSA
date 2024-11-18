class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] ans = new int[code.length];
        for(int i = 0; i < code.length; i++){
            int temp = 0;
            if(k > 0){
                int idx = i+1;
                int n = k;
                while(n > 0){
                    idx = idx % code.length;
                    temp += code[idx++];
                    n--;
                }
            } else if(k < 0){
                int idx = i-1;
                int n = k;
                while(n < 0){
                    idx = (idx) % code.length;
                    if(idx < 0)
                    idx = (idx) % code.length + code.length;
                    temp += code[idx--];
                    n++;
                }
            } else{
                temp = 0;
            }

            ans[i] = temp;
        }

        return ans;
    }
}