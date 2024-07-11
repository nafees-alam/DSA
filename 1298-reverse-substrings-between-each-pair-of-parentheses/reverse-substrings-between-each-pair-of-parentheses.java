class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                Queue<Character> q = new LinkedList<>();
                while(st.peek() != '('){
                    q.add(st.pop());
                }
                st.pop();
                while(!q.isEmpty()){
                    st.push(q.remove());
                }
            } else {
                st.push(s.charAt(i));
            }
        }

        char[] ca = new char[st.size()];
        int i = st.size() - 1;
        while(i >= 0){
            ca[i] = st.pop();
            i--;
        }

        return new String(ca);  
    }
}