class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum = (sum + nums[i]) % p;
        }

        int target = sum % p;
        if(target == 0){
            return 0;
        }

        int cnt = n;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int currSum = 0;

        for(int i = 0; i < n; i++){
            currSum = (currSum+nums[i]) % p;
            int remain = (currSum - target + p) % p;
            if(map.containsKey(remain)){
                cnt = Math.min((i - map.get(remain)), cnt);
            }

            map.put(currSum, i);
        }

        return cnt == n ? -1 : cnt;
    }
}