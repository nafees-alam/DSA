class Solution {
    public String largestNumber(int[] nums) {
        String[] str = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            str[i] = Integer.toString(nums[i]);
        }

        Arrays.sort(str, new Comparator<String>(){
            public int compare(String a, String b){
                String first = a + b;
                String second = b + a;

                return second.compareTo(first);
            }
        });

        if(str[0].equals("0")){
            return "0";
        }

        String ans = "";

        for(int i = 0; i < nums.length; i++){
            ans += str[i];
        }

        return ans;
    }

    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}