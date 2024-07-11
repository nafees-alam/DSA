class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int ans = 0;
        int openBrac = 0;
        int closBrac = 0;
        for(int i = 0; i < s.length(); i++){
           if(s.charAt(i) == '('){
            st.push(s.charAt(i));
           } else {
            if(st.isEmpty()){
                ans++;
            }
             else{
                st.pop();
            }
           }
        }

        if(st.isEmpty()){
            return ans;
        }

        return ans + st.size();

    }
}