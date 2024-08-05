class Solution {
    public String kthDistinct(String[] arr, int k) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int cnt = 0;
        for(int i = 0; i < arr.length; i++){
            if(map.get(arr[i]) == 1){
                cnt++;
                if(cnt == k){
                    return arr[i];
                }
            }
        }

        return "";
    }
}