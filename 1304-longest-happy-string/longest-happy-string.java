class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((p, q)-> q.second - p.second);
        pq.add(new Pair('a', a));
        pq.add(new Pair('b', b));
        pq.add(new Pair('c', c));
        StringBuilder sb = new StringBuilder();

        while(true){
            Pair curr = pq.remove();
            if(curr.second == 0){
                break;
            }
            char currChar = curr.first;
            int currCnt = curr.second;
            int tempCnt = currCnt;
            if(currCnt >= 2){
                sb.append(currChar);
                sb.append(currChar);
                currCnt -= 2;
            } else if(currCnt == 1){
                sb.append(currChar);
                currCnt = 0;
            }

            Pair curr2 = pq.remove();
            if(curr2.second == 0){
                break;
            }
            char currChar2 = curr2.first;
            int currCnt2 = curr2.second;
            if(currCnt2 - currCnt >= 2){
                sb.append(currChar2);
                sb.append(currChar2);
                currCnt2 -= 2;
            } else if(currCnt >= 1){
                sb.append(currChar2);
                currCnt2--;
            }

            pq.add(new Pair(currChar, currCnt));
            pq.add(new Pair(currChar2, currCnt2));
        }

        return sb.toString();
    }
}

class Pair{
    char first;
    int second;

    Pair(char i, int j){
        first = i;
        second = j;
    }
}