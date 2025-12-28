class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        int n = nums2.length;
        int[] ngr = new int[n];
        int[] ans = new int[nums1.length];

        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && st.peek() <= nums2[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                ngr[i] = st.peek();
            } else{
                ngr[i] = -1;
            }

            st.push(nums2[i]);
        }

        for(int i = 0; i < nums1.length; i++){
            int num = nums1[i];
            for(int j = 0; j < n; j++){
                if(nums2[j] == num){
                    ans[i] = ngr[j];
                }
            }
        }

        return ans;
    }
}