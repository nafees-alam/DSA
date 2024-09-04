class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Pair> set = new HashSet<>();
        for(int[] arr : obstacles){
            set.add(new Pair(arr[0], arr[1]));
        }

        int x = 0;
        int y = 0;
        int maxDist = 0;

        //pointing to north
        Pair dir = new Pair(0, 1);

        for(int i = 0; i < commands.length; i++){
            int tempX = dir.x;
            int tempY = dir.y;
            if(commands[i] == -2){  //left
                dir.x = -tempY;
                dir.y = tempX;
            } else if(commands[i] == -1){ // right
                dir.x = tempY;
                dir.y = -tempX;
            } else {
                for(int j = 0; j < commands[i]; j++){
                    int newX = x + dir.x;
                    int newY = y + dir.y;

                    Pair temp = new Pair(newX, newY);

                    if(set.contains(temp)){
                        break;
                    }

                    x = newX;
                    y = newY;
                }
            }

            maxDist = Math.max(maxDist, x*x+y*y);
        }

        return maxDist;
    }
}

class Pair{
    int x;
    int y;

    public Pair(int i, int j){
        x = i;
        y = j;
    }

     @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return x == pair.x && y == pair.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}