class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>((a, b) -> Long.compare(b, a));
        
        for (int i = 0; i < nums.length; i++) {
            pq.add((long) nums[i]);
        }

        long ans = 0;
        
        for (int i = 0; i < k; i++) {
            long temp = pq.remove();
            ans += temp;
            long ceil = (temp + 2) / 3;
            pq.add(ceil);
        }

        return ans;
    }
}
