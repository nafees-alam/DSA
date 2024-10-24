class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int zeroCnt = 0;
        for(int i = 0; i < arr.length; i++){
            set.add(arr[i]);
            if(arr[i] == 0)
            zeroCnt++;
        }

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0 && zeroCnt > 1) return true;
            if(arr[i] != 0 && set.contains(arr[i]/2) && arr[i] % 2 == 0){
                return true;
            }
        }

        return false;
    }
}