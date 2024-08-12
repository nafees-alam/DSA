class KthLargest {
    int k;
    int[] nums;
    private PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
       this.k = k;
       this.nums = nums;
       pq = new PriorityQueue<>(k);
       for(int i =0; i < nums.length; i++){
            pq.add(nums[i]);
            if(pq.size() > k) pq.remove();
       } 
    }

    public int add(int val) {
        pq.add(val);
        if(pq.size() > k) pq.remove();
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */