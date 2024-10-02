class Solution {
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] tempArr = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            tempArr[i] = arr[i];
        }

        Arrays.sort(tempArr);
        int j = 1;
        for(int i = 0; i < tempArr.length; i++){
            if(i > 0 && tempArr[i-1] == tempArr[i]){
                continue;
            }

            map.put(tempArr[i], j++);
        }

        for(int i = 0; i < arr.length; i++){
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }
}