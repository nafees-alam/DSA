class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int m = meetings.length;
        int[] ans = new int[n];
        Arrays.sort(meetings, Comparator.comparingDouble(o -> o[0]));
        long[] lastAvailableAt = new long[n];

        for(int[] meet : meetings){
            int start = meet[0];
            int end = meet[1];
            int duration = end - start;
            boolean found = false;

            long earlyAvailRoomTime = Long.MAX_VALUE;
            int earlyAvailRoom = 0;

            for(int i = 0; i < n; i++){
                if(lastAvailableAt[i] <= start){
                    ans[i]++;
                    lastAvailableAt[i] = end;
                    found = true;
                    break;
                }

                if(lastAvailableAt[i] < earlyAvailRoomTime){
                    earlyAvailRoom = i;
                    earlyAvailRoomTime = lastAvailableAt[i];
                }
            }

            if(!found){
                lastAvailableAt[earlyAvailRoom] += duration;
                ans[earlyAvailRoom]++;
            }
        }
        

        int max = 0;
        int idx = -1;

        for(int j = 0; j < ans.length; j++){
            if(ans[j] > max){
                max = ans[j];
                idx = j;
            }
        }

        return idx;
    }
}

class Pair{
    int first;
    int second;

    Pair(int i, int j){
        first = i;
        second = j;
    }
}