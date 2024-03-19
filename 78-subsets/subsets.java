class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        recursion(nums, 0, ans, new ArrayList<>());
        return ans;
    }

    static void recursion(int[] arr, int idx, List<List<Integer>> ans, List<Integer> ds){
        if(idx == arr.length){
            ans.add(new ArrayList<>(ds));
            return;
        }

        ds.add(arr[idx]);
        recursion(arr, idx+1, ans, ds);
        ds.remove(ds.size() - 1);
        recursion(arr, idx+1, ans, ds);
    }
}