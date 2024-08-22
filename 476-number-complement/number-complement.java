class Solution {
    public int findComplement(int num) {
        int bitlength = Integer.toBinaryString(num).length();
        int bitmask = (1<<bitlength) - 1;
        return num^bitmask;
    }
}