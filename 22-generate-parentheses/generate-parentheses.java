class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(0, 0, n, ans, "");
        return ans;
    }

    void helper(int i, int j, int n, List<String> list, String str){
        if(i == n && j == n){
            list.add(str);
            return;
        }

        if(i < n){
            helper(i+1, j, n, list, str+"(");
        }
        if(j < i){
            helper(i, j+1, n, list, str+")");
        }
    }
}