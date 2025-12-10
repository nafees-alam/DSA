class Solution {
    public void setZeroes(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    for(int l = 0; l < matrix[0].length; l++){
                        if(matrix[i][l] != 0)
                        matrix[i][l] = -22;
                    }
                    for(int l = 0; l < matrix.length; l++){
                        if(matrix[l][j] != 0)
                        matrix[l][j] = -22;
                    }
                }
            }
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == -22)
                matrix[i][j] = 0;
            }
        }
    }
}