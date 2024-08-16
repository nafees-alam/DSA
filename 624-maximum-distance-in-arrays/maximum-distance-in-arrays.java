class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int max = (int)-1e4;
        int smallest = arrays.get(0).get(0);
        int biggest = arrays.get(0).get(arrays.get(0).size()-1);
        for(int i = 1; i < arrays.size(); i++){
            max = Math.max(max, Math.abs(smallest - arrays.get(i).get(arrays.get(i).size()-1)));
            max = Math.max(max, Math.abs(biggest - arrays.get(i).get(0)));
            smallest = Math.min(smallest, arrays.get(i).get(0));
            biggest = Math.max(biggest, arrays.get(i).get(arrays.get(i).size()-1));
        }

        return max;
    }
}