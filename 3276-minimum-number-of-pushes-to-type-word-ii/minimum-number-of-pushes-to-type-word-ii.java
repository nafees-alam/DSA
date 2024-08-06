class Solution {
    public int minimumPushes(String word) {
        int ans = 0;
        int count = 0;
        int[] freq = new int[26];

        for(char c : word.toCharArray()){
            freq[c-'a']++;
        }

        Arrays.sort(freq);

        for(int i = 25; i >= 0; i--){
            if(freq[i] > 0){
                ans += freq[i] * (count/8 + 1);
                count++;
            }
        }

        return ans;
    }
}