class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        List<Integer> minRows = new ArrayList<>();
        List<Integer> maxCol = new ArrayList<>();

        for(int i = 0; i < n; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < m; j++){
                if(min > matrix[i][j]){
                    min = matrix[i][j];
                }
            }
            minRows.add(min);
        }

        for(int j = 0; j < m; j++){
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < n; i++){
                if(max < matrix[i][j]){
                    max = matrix[i][j];
                }
            }
            maxCol.add(max);
        }

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == minRows.get(i) && matrix[i][j] == maxCol.get(j)){
                    list.add(matrix[i][j]);
                }
            }
        }

        return list;
    }
}