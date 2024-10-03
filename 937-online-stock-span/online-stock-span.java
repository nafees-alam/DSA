class StockSpanner {
    ArrayList<Integer> prices;
    public StockSpanner() {
        prices = new ArrayList<>();
    }
    
    public int next(int price) {
        int cnt = 0;
        prices.add(price);
        int i = prices.size()-1;

        while(i >= 0 && prices.get(i) <= price){
            cnt++;
            i--;
        }

        return cnt;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */