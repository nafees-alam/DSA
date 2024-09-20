class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        return helper(expression);
    }

    public List<Integer> helper(String exp){
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < exp.length(); i++){
            if(exp.charAt(i) == '+' || exp.charAt(i) == '-' || exp.charAt(i) == '*'){
                //selection of two strings to be performed
                List<Integer> left = helper(exp.substring(0, i));
                List<Integer> right = helper(exp.substring(i+1));
                //calculation of operation between the two strings
                for(int l : left){
                    for(int r : right){
                        if(exp.charAt(i) == '+'){
                            res.add(l+r);
                        } else if(exp.charAt(i) == '-'){
                            res.add(l-r);
                        } else {
                            res.add(l*r);
                        }
                    }
                }
            }
        }

        if(res.size() == 0){
            int num = Integer.parseInt(exp);
            res.add(num);
            return res;
        }

        return res;
    }
}