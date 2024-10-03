class MyLinkedList {
    private ArrayList<Integer> list;
    public MyLinkedList() {
        list = new ArrayList<>();
    }
    
    public int get(int index) {
        if(list.isEmpty() || index >= list.size() || index < 0){
            return -1;
        }

        return list.get(index);
    }
    
    public void addAtHead(int val) {
        list.add(0, val);
    }
    
    public void addAtTail(int val) {
        list.add(list.size(), val);
    }
    
    public void addAtIndex(int index, int val) {
        if(index > list.size() || index < 0){
            return;
        }
        list.add(index, val);
    }
    
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= list.size() || list.isEmpty()){
            return;
        }
        list.remove(index);
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */