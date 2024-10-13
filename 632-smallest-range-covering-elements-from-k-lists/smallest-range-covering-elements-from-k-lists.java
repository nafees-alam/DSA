class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        int[] res = {-1000000, 1000000};
        int[] idxArr = new int[k];

        while(true){
            int maxEle = Integer.MIN_VALUE;
            int minEle = Integer.MAX_VALUE;
            int minEleListIdx = 0;
            for(int i = 0; i < k; i++){
                int listIdx = i;
                int eleIdx = idxArr[i];
                int element = nums.get(listIdx).get(eleIdx);

                if(element < minEle){
                    minEle = element;
                    minEleListIdx = listIdx;
                }

                maxEle = Math.max(maxEle, element);
            }

            if((maxEle - minEle) < (res[1] - res[0])){
                res[0] = minEle;
                res[1] = maxEle;
            }

            int nextIdx = idxArr[minEleListIdx] + 1;

            if(nextIdx >= nums.get(minEleListIdx).size()){
                break;
            }

            idxArr[minEleListIdx] = nextIdx;
        }

        return res;
    }
}