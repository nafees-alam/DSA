class Solution {
    public boolean exist(char[][] board, String word) {
        char[] wordArr = word.toCharArray();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == wordArr[0]){
                    if(ifExist(i,j, board, wordArr, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static boolean ifExist(int i, int j, char[][] board, char[] wordArr, int idx){
        if(idx == wordArr.length){
            return true;
        }

        if(i < 0 || j < 0 || i == board.length || j == board[0].length || board[i][j] != wordArr[idx]) {
            return false;
        }

        char ch = board[i][j];
        board[i][j] = '#';

        boolean res = ifExist(i+1, j, board, wordArr, idx+1) ||
                      ifExist(i-1, j, board, wordArr, idx+1) ||
                      ifExist(i, j+1, board, wordArr, idx+1) ||
                      ifExist(i, j-1, board, wordArr, idx+1);
        board[i][j] = ch;
        return res;
    }
    
}