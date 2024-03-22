class Solution {
    public String largestOddNumber(String num) {
        int ptr = -1;
        for(int i = 0; i < num.length(); i++){
            if(num.charAt(i)%2 != 0){
                ptr = i;
            }
        }


        return num.substring(0, ptr+1);
    }
}