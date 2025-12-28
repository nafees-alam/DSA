class Solution {
    public int countNegatives(int[][] grid) {
        int ans = 0;
        for(int i = 0; i < grid.length; i++){
            int s = 0;
            int e = grid[i].length-1;
            if(grid[i][e] >= 0) continue;
            while(s <= e){
                int mid = s + (e-s)/2;
                if(grid[i][s] < 0){
                    ans += grid[i].length-s;
                    break;
                }else if(grid[i][mid] >= 0){
                    s = mid+1;
                } else{
                    e = mid;
                }
            }
        }

        return ans;
    }
}