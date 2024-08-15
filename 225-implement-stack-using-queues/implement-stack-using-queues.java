class MyStack {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    public MyStack() {
        
    }
    
    public void push(int x) {
        q1.add(x);
    }
    
    public int pop() {
        int size = q1.size();
        for(int i = 0; i < size -1; i++){
            q2.add(q1.remove());
        }
        int ans = q1.remove();
        while(!q2.isEmpty()){
            q1.add(q2.remove());
        }

        return ans;
    }
    
    public int top() {
        int size = q1.size();
        for(int i = 0; i < size -1; i++){
            q2.add(q1.remove());
        }
        int ans = q1.remove();
        q2.add(ans);
        while(!q2.isEmpty()){
            q1.add(q2.remove());
        }

        return ans;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */