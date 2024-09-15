class Solution {
    public int findTheLongestSubstring(String s) {
        int maxlen = 0;
        int[] vowels = new int[5]; //a, e, i, o, u
        HashMap<String, Integer> map = new HashMap<>();
        String currState = "00000";
        map.put(currState, -1);

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'a'){
                vowels[0] = (vowels[0] + 1) % 2;
            } else if(s.charAt(i) == 'e'){
                vowels[1] = (vowels[1] + 1) % 2;
            } else if(s.charAt(i) == 'i'){
                vowels[2] = (vowels[2] + 1) % 2;
            } else if(s.charAt(i) == 'o'){
                vowels[3] = (vowels[3] + 1) % 2;
            } else if(s.charAt(i) == 'u'){
                vowels[4] = (vowels[4] + 1) % 2;
            }

            currState = "";
            for(int j = 0; j < 5; j++){
                currState += vowels[j];
            }

            if(map.containsKey(currState)){
                maxlen = Math.max(maxlen, i - map.get(currState));
            } else {
                map.put(currState, i);
            }
        }

        return maxlen;
    }
}