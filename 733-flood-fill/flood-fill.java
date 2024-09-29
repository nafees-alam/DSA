class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color){
            return image;
        }

        int m = image.length;
        int n = image[0].length;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr, sc));
        int initialColor = image[sr][sc];
        image[sr][sc] = color;

        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();

            for(int i = 0; i < 4; i++){
                int nrow = row + dr[i];
                int ncol = col + dc[i];

                if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && image[nrow][ncol] == initialColor){
                    q.add(new Pair(nrow, ncol));
                    image[nrow][ncol] = color;
                }
            }
        }

        return image;
    }
}

class Pair{
    int first;
    int second;

    public Pair(int i, int j){
        first = i;
        second = j;
    }
}