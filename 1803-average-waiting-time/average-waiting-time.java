class Solution {
    public double averageWaitingTime(int[][] customers) {
        int waitTime = 0;
        int totTime = customers[0][0];
        int n = customers.length;
        double ans = 0;

        for(int i = 0; i < n; i++){
            if(totTime < customers[i][0]){
                totTime = customers[i][0];
            }
            totTime += customers[i][1];
            waitTime = totTime - customers[i][0];
            ans += waitTime;
        }

        return ans/n;
    }
}