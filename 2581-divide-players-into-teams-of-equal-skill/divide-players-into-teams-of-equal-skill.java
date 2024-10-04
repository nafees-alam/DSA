class Solution {
    public long dividePlayers(int[] skill) {
        long totSum = 0;
        int n = skill.length;
        for(int i = 0; i < n; i++){
            totSum += skill[i];
        }

        if(n/2 % 2 == 0 && totSum % 2 != 0){
            return -1;
        }

        Arrays.sort(skill);

        int reqSum = (int)totSum/(n/2);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(skill[i], map.getOrDefault(skill[i], 0) + 1);
        }

        for(int key : map.keySet()){
            System.out.println(key + "->" + map.get(key));
        }

        System.out.println(reqSum);

        long ans = 0;
        
        for(int i = 0; i < n/2; i++){
            int key = skill[i];
            if(!map.containsKey(reqSum-key)){
                return -1;
            }

            ans += key * (reqSum - key);
            map.put(key, map.get(key) - 1);
            map.put(reqSum-key, map.get(reqSum-key)-1);
            if(map.get(key) == 0){
                map.remove(key);
            }
            if(map.containsKey(reqSum-key) && map.get(reqSum - key) == 0){
                map.remove(reqSum - key);
            }
        }

        return ans;
    }
}