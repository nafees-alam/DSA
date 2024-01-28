class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        char board [][] = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        nQueenHelper(list, board, 0);
        return list;
    }

    static boolean isSafe(char [][] board, int row, int col){
        //vertical up
        for(int i = row-1; i >= 0; i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        //diagonal left
        for(int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        //diagonal right
        for(int i = row-1, j = col+1; i >= 0 && j < board.length; i--, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }

    static void nQueenHelper(List<List<String>> list, char [][] board, int row){
        //base case
        if(row == board.length){
            list.add(constructList(board));
            return;
        }

        for(int j = 0; j < board.length; j++){
            if(isSafe(board, row, j)){
                board[row][j] = 'Q';
                nQueenHelper(list, board, row+1); //function call
                board[row][j] = '.'; //backtracking
            }
        }
    }

    static List<String> constructList(char [][] board){

        List<String> helperList = new ArrayList<>();

        for(int i = 0; i < board.length; i++){
            String str = new String(board[i]);
            helperList.add(str);
        }

        return helperList;
    }
}