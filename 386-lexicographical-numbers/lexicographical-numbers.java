class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= 9; i++){
            solve(i, list, n);
        }

        return list;
    }

    public void solve(int currNum, List<Integer> list, int n){
        if(currNum > n){
            return;
        }

        list.add(currNum);

        for(int i = 0; i <= 9; i++){
            int newNum = currNum * 10 + i;
            if(newNum > n){
                return;
            }

            solve(newNum, list, n);
        }
    }
}