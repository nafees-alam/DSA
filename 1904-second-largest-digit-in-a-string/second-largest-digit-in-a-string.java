class Solution {
    public int secondHighest(String s) {
        s = s.replaceAll("\\D","");
        if(s.length() < 2){
            return -1;
        }
        int[] arr = new int[s.length()];
        for(int i =0; i < arr.length; i++){
            arr[i] = s.charAt(i)-'0';
        }

        int prevMax = -1;
        int max = -1;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                prevMax = max;
                max = arr[i];
            } else if(arr[i] != max && arr[i] > prevMax){
                prevMax = arr[i];
            }
        }

        return prevMax;
    }
}