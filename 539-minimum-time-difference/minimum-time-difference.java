class Solution {
    public int findMinDifference(List<String> timePoints) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < timePoints.size(); i++){
            int hrs = Integer.parseInt(timePoints.get(i).substring(0, 2));
            int min = Integer.parseInt(timePoints.get(i).substring(3));

            int totMinutes = hrs * 60 + min;
            list.add(totMinutes);
        }

        Collections.sort(list);

        int minDiff = Integer.MAX_VALUE;

        for(int i = 0; i < list.size()-1; i++){
            int diff = Math.abs(list.get(i) - list.get(i+1));
            minDiff = Math.min(minDiff, diff);
        }

        return Math.min(minDiff, (1440 - list.get(list.size()-1)) + list.get(0));
    }
}