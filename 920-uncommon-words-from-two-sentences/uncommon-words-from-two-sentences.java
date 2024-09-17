class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        List<String> list = new ArrayList<>();
        String[] str1 = s1.split(" ");
        String[] str2 = s2.split(" ");

        HashMap<String, Integer> map1 = new HashMap<>();
        for(int i = 0; i < str1.length; i++){
            map1.put(str1[i], map1.getOrDefault(str1[i], 0) + 1);
        }

        HashMap<String, Integer> map2 = new HashMap<>();
        for(int i = 0; i < str2.length; i++){
            map2.put(str2[i], map2.getOrDefault(str2[i], 0) + 1);
        }

        for(String key : map2.keySet()){
            if(!map1.containsKey(key) && map2.get(key) == 1){
                list.add(key);
            }
        }

        for(String key : map1.keySet()){
            if(!map2.containsKey(key) && map1.get(key) == 1){
                list.add(key);
            }
        }

        return list.toArray(new String[0]);
    }
}