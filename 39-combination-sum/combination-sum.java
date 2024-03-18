class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        findCombination(0, target, candidates, ans, ds);

        return ans;
    }

    static void findCombination(int idx, int target, int[] arr, List<List<Integer>> ans, List<Integer> ds){
        if(idx == arr.length){
            return;
        }

        if(target == 0){
             ans.add(new ArrayList(ds));
             return;
        }

        if(arr[idx] <= target){
            ds.add(arr[idx]);
            findCombination(idx, target-arr[idx], arr, ans, ds);
            ds.remove(ds.size() - 1);
        }

        findCombination(idx+1, target, arr, ans, ds);
    }
}