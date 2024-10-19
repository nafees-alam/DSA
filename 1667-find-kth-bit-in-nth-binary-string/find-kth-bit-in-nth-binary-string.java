class Solution {
    public char findKthBit(int n, int k) {
        if(n == 1 && k == 1){
            return '0';
        }

        StringBuilder sb = new StringBuilder();
        sb.append('0');


        if(n > 1){
            for(int i = 1; i < n; i++){
                StringBuilder temp = new StringBuilder(sb);
                sb.append("1");
                for(int j = 0; j < temp.length(); j++){
                    if(temp.charAt(j) == '0'){
                        temp.setCharAt(j, '1');
                    } else {
                        temp.setCharAt(j, '0');
                    }
                }
                temp.reverse();
                sb.append(temp);
            }
        }

        // System.out.println(sb.toString());

        return sb.charAt(k-1);
    }
}