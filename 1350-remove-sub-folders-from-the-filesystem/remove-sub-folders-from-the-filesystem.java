class Solution {
    public List<String> removeSubfolders(String[] folder) {
        int n = folder.length;
        Arrays.sort(folder, Comparator.comparingInt(String::length));
        LinkedHashSet<String> set = new LinkedHashSet<>();

        for(int i = 0; i < n; i++){
            String[] str = folder[i].split("/");
            String temp = "";
            for(int j = 1; j < str.length; j++){
                temp += "/" + str[j];
                if(set.contains(temp)){
                    break;
                }
                if(j == str.length-1){
                    set.add(temp);
                }
            }
        }

        List<String> ans = new ArrayList<>();
        for(String val : set){
            ans.add(val);
        }

        return ans;
    }
}