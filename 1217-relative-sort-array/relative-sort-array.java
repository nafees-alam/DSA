class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int[] ans = new int[n];
        int count = 0;

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            map.put(arr1[i], map.getOrDefault(arr1[i], 0)+1);
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < map.get(arr2[i]); j++){
                ans[count] = arr2[i];
                count++;
            }
            map.remove(arr2[i]);
        }

        int[] rem = new int[n-count];
        int count2 = 0;

        for(int i = 0; i < n; i++){
            if(map.containsKey(arr1[i])){
                for(int j = 0; j < map.get(arr1[i]); j++){
                    rem[count2] = arr1[i];
                    count2++;
                }
                map.remove(arr1[i]);
            }
        }

        Arrays.sort(rem);

        for(int val : rem){
            ans[count] = val;
            count++;
        }

        return ans;
        
    }
}