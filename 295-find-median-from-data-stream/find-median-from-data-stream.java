class MedianFinder {
    private PriorityQueue<Integer> left_max_heap;
    private PriorityQueue<Integer> right_min_heap;

    public MedianFinder() {
        left_max_heap = new PriorityQueue<>((x, y) -> y - x);
        right_min_heap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // add in heaps
        if(left_max_heap.isEmpty() || num < left_max_heap.peek()){
            left_max_heap.add(num);
        } else {
            right_min_heap.add(num);
        }

        //balance
        int sizeDiff = (left_max_heap.size() - right_min_heap.size());
        if(sizeDiff > 1){
            right_min_heap.add(left_max_heap.remove());
        } else if(left_max_heap.size() < right_min_heap.size()){
            left_max_heap.add(right_min_heap.remove());
        }
    }
    
    public double findMedian() {
        if(right_min_heap.size() == left_max_heap.size()){
            return (right_min_heap.peek() + left_max_heap.peek()) / 2.0;
        } else {
            return left_max_heap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */