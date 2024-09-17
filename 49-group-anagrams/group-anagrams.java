class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        List<String> str = new ArrayList<>(Arrays.asList(strs));

        while(str.size() > 0){
            String curr = str.get(0);
            str.remove(0);
            List<String> temp = new ArrayList<>();
            temp.add(curr);
            for(int i = 0; i < str.size(); i++){
                if(isAnagram(curr, str.get(i))){
                    temp.add(str.get(i));
                    str.remove(i);
                    i--;
                }
            }
            if(temp.size() > 0){
                list.add(temp);
            }
        }
        return list;
    }

    boolean isAnagram(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s1.length(); i++){
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }

        for(int i = 0; i < s2.length(); i++){
            if(!map.containsKey(s2.charAt(i))){
                return false;
            } else {
                map.put(s2.charAt(i), map.get(s2.charAt(i))-1);
                if(map.get(s2.charAt(i)) == 0){
                    map.remove(s2.charAt(i));
                }
            }
        }

        return true;
    }
}