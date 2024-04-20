class Solution {
    public boolean lemonadeChange(int[] bills) {
        boolean ans = true;
        int count[] = new int[3];
        for(int i = 0; i < bills.length; i++){
            //count
            if(bills[i] == 5){
                count[0]++;
            } else if(bills[i] == 10){
                if(count[0] < 1){
                    return false;
                }
                count[1]++;
                count[0]--;
            } else {
                if(count[0] >= 1 && count[1] >= 1){
                    count[0]--;
                    count[1]--;
                } else if(count[0] > 2){
                    count[0] -= 3;
                } else{
                    ans = false;
                }
            }

        }

        return ans;
    }
}