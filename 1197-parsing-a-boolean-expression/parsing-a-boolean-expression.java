class Solution {
    public boolean parseBoolExpr(String exp) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < exp.length(); i++){
            ArrayList<Character> list = new ArrayList<>();
            if(exp.charAt(i) == ')'){
                while(!st.isEmpty() && st.peek() != '('){
                    list.add(st.pop());
                }
                st.pop(); //popped '('
                char operator = st.pop();
                boolean temp = solve(list, operator);
                st.push(temp == true ? 't' : 'f');
            } else {
                st.push(exp.charAt(i));
            }
        }
        
        return st.pop() == 't' ? true : false;
    }

    boolean solve(ArrayList<Character> list, char op){
        if(op == '|'){
            for(int i = 0; i < list.size(); i++){
                if(list.get(i) == 't'){
                    return true;
                }
            }
            return false;
        } else if(op == '&'){
            for(int i = 0; i < list.size(); i++){
                if(list.get(i) == 'f'){
                    return false;
                }
            }
            return true;
        } else {
            return list.get(0) == 'f' ? true : false;
        }
    }
}