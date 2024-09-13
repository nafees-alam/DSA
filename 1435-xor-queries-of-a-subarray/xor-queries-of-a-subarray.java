class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] ans = new int[queries.length];
        int[] preXor = new int[arr.length];
        preXor[0] = arr[0];

        for(int i = 1; i < arr.length; i++){
            preXor[i] = preXor[i-1] ^ arr[i];
        }

        for(int i = 0; i < queries.length; i++){
            int s = queries[i][0];
            int e = queries[i][1];

            if(s == 0){
                ans[i] = preXor[e];
            } else {
                ans[i] = preXor[s-1] ^ preXor[e];
            }
        }

        return ans;
    }
}