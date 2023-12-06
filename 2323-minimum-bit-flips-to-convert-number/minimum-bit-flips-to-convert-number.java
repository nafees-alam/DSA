class Solution {
    public int minBitFlips(int start, int goal) {
        int count = 0;
       while(start > 0 || goal > 0){
           int n1 = start & 1;
           int n2 = goal & 1;
           if(n1 != n2){
               count++;
           }
           start = start >> 1;
           goal = goal >> 1;
       }

       return count; 
    }
}