class Solution {
    public int maximumSwap(int num) {
        String str = Integer.toString(num);
        int[] maxRight = new int[10];
        Arrays.fill(maxRight, -1);

        for(int i = 0; i < str.length(); i++){
            int dig = str.charAt(i)-'0';
            maxRight[dig] = i;
        }

        for(int i = 0; i < str.length(); i++){
            int currDig = str.charAt(i)-'0';
            for(int j = 9; j > currDig; j--){
                if(i < maxRight[j]){
                    str = swap(str, i, maxRight[j]);
                    return Integer.parseInt(str);
                }
            }
        }

        return num;
    }

    String swap(String s, int i, int j){
        char[] ch = s.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;

        return new String(ch);
    }
}