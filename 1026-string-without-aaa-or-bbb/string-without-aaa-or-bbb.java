class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();
        Pair curr = new Pair('0', 0);
        if(a >= b){
            curr.first = 'a';
            curr.second = a;
        } else if(b > a){
            curr.first = 'b';
            curr.second = b;
        }

        Pair curr2 = new Pair('0', 0);
        if(curr.first == 'a'){
            curr2.first = 'b';
            curr2.second = b;
        } else {
            curr2.first = 'a';
            curr2.second = a;
        }

        System.out.println(curr.first + ", " + curr.second);
        System.out.println(curr2.first + ", " + curr2.second);
        while(true){
            if(curr.second == 0){
                break;
            }

            if(curr.second >= 2){
                sb.append(curr.first);
                sb.append(curr.first);
                curr.second -= 2;
            } else if(curr.second == 1){
                sb.append(curr.first);
                curr.second = 0;
            }

            if(curr2.second == 0){
                break;
            }

            if(curr2.second - curr.second >= 2){
                sb.append(curr2.first);
                sb.append(curr2.first);
                curr2.second -= 2;
            } else if(curr2.second >= 1){
                sb.append(curr2.first);
                curr2.second--;
            }
        }

        return sb.toString();
    }
}

class Pair{
    char first;
    int second;

    public Pair(char i, int j){
        first = i;
        second = j;
    }
}