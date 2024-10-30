class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();

        //removeValisParenthesis;
        removeValid(st, s);

        List<Integer> list = new ArrayList<>();

        //addIndexes
        addIndexes(st, s, list);

        int maxlen = 0;
        for(int i = 0; i < list.size()-1; i++){
            maxlen = Math.max(maxlen, list.get(i+1)-list.get(i)-1);
        }

        return maxlen;
    }

    public void removeValid(Stack<Integer> st, String s){
        int i = 0;
        while(i < s.length()){
            if(s.charAt(i) == '('){
                st.push(i);
            } else if(st.isEmpty() || s.charAt(st.peek()) == ')'){
                st.push(i);
            } else{
                st.pop();
            }
            i++;
        }
    }

    public void addIndexes(Stack<Integer> st, String s, List<Integer> list){
        list.add(0, s.length());
        while(!st.isEmpty()){
            list.add(0, st.pop());
        }

        list.add(0, -1);
    }
}