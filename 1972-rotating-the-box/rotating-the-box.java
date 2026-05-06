class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;

        for(int i = 0; i < m; i++){
            int empty = n-1;
            for(int j = n-1; j >= 0; j--){
                if(boxGrid[i][j] == '*'){
                    empty = j-1;
                } else if(boxGrid[i][j] == '#') {
                    char temp = boxGrid[i][empty];
                    boxGrid[i][empty] = '#';
                    boxGrid[i][j] = temp;
                    empty--;
                }
            }
        }

        for(char[] c : boxGrid){
            System.out.println(Arrays.toString(c));
        }

        //transpose
        char[][] ans = transpose(boxGrid);
        //reverse to get 90 clockwise
        for(int i = 0; i < ans.length; i++){
            int s = 0;
            int e = ans[0].length - 1;

            while(s < e){
                char temp = ans[i][s];
                ans[i][s] = ans[i][e];
                ans[i][e] = temp;
                s++;
                e--;
            }
        }

        return ans;
    }

    static char[][] transpose(char[][] matrix){
        char[][] temp = new char[matrix[0].length][matrix.length];

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                temp[j][i] = matrix[i][j];
            }
        }

        return temp;
    }
}