class Solution {
    public int getLucky(String s, int k) {
        String temp = "";
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            temp += (s.charAt(i)-'a'+1);
        }

        System.out.println(temp);
        for(int j = 0; j < k; j++){
            ans = 0;
            for(int i = 0; i < temp.length(); i++){
                ans += temp.charAt(i)-'0';
            }
            temp = Integer.toString(ans);
        }
        

        return ans;
    }
}