class Solution {
    public boolean isValid(String s) {
        Stack <Character> stk = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            //opening
            if(ch == '(' || ch == '{' || ch == '['){
                stk.push(ch);
            }
            else{
                // check if there is any opening bracket in test case or not
                if(stk.isEmpty()){
                    return false;
                }

                //closing
                if(stk.peek() == '(' && ch == ')'
                   || stk.peek() == '{' && ch == '}'
                   || stk.peek() == '[' && ch == ']') {
                       stk.pop();
                   }
                else {
                    return false;
                }
            }
        }
        // if anything left in stack
        if(!stk.isEmpty()) {
            return false;
        }
        return true;
    }
}