class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        int minValue = Integer.MAX_VALUE;
        for(int i = 0; i < n-1; i++){
            if(minValue > arr[i+1] - arr[i]){
                minValue = arr[i+1] - arr[i];
            }
        }

        for(int i = 0; i < n-1; i++){
            if(arr[i+1] > arr[i] && arr[i+1] - arr[i] == minValue){
                    List<Integer> list = new ArrayList<>();
                    list.add(arr[i]);
                    list.add(arr[i+1]);
                    ans.add(list);
                }
        }

        return ans;
    }
}