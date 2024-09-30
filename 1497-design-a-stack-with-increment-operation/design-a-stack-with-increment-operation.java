class CustomStack {
    int[] st;
    int top;
    int size;
    public CustomStack(int maxSize) {
        st = new int[maxSize];
        top = -1;
        size = maxSize;
    }
    
    public void push(int x) {
        if(top == size-1){
            return;
        }
        ++top;
        st[top] = x;
    }
    
    public int pop() {
        if(top < 0){
            return -1;
        }
        return st[top--];
    }
    
    public void increment(int k, int val) {
        if(k > top){
            for(int i = 0; i <= top; i++){
                st[i] += val;
            }
        } else {
            for(int i = 0; i < k; i++){
                st[i] += val;
            }
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */