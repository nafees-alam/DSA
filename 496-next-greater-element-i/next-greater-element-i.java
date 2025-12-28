class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        int n = nums2.length;
        // int[] ngr = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[nums1.length];

        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && st.peek() <= nums2[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                map.put(nums2[i], st.peek());
            } else{
                map.put(nums2[i], -1);
            }
            st.push(nums2[i]);
        }

        for(int i = 0; i < nums1.length; i++){
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
}