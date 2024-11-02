class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i < numRows; i++){
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    temp.add(1);
                } else if(i > 0 && j - 1 >= 0 && j+1 <= i){
                    int req = list.get(i-1).get(j-1) + list.get(i-1).get(j);
                    temp.add(req);
                }
            }

            list.add(temp);
        }

        return list;
    }
}