class Solution {
    public int minimumPushes(String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < word.length(); i++){
            map.put(word.charAt(i), map.getOrDefault(word.charAt(i), 0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> y.second - x.second);

        for(Character key : map.keySet()){
            pq.add(new Pair(key, map.get(key)));
        }

        int ans = 0;
        int count = 1;
        int loopCount = 0;
        while(!pq.isEmpty()){
            ans += count * pq.remove().second;
            loopCount++;
            if(loopCount % 8 == 0){
                count++;
            }
        }

        return ans;
    }
}

class Pair{
    char first;
    int second;

    public Pair(char s, int i){
        first = s;
        second = i;
    }
}