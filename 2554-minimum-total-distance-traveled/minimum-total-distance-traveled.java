class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> Integer.compare(a[0], b[0]));

        // List to hold available factories according to their capacities
        List<Integer> fact = new ArrayList<>();
        for (int[] f : factory) {
            for (int j = 0; j < f[1]; j++) {
                fact.add(f[0]);
            }
        }

        long[][] dp = new long[robot.size()][fact.size()];
        for (long[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return solve(robot, fact, 0, 0, dp);
    }

    long solve(List<Integer> robot, List<Integer> fact, int i, int j, long[][] dp) {
        if (i >= robot.size()) {
            return 0;
        }
        if (j >= fact.size()) {
            return Long.MAX_VALUE/2;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Take the factory for the current robot
        long take = Math.abs(robot.get(i) - fact.get(j)) + solve(robot, fact, i + 1, j + 1, dp);
        // Skip the current factory
        long notTake = solve(robot, fact, i, j + 1, dp);

        return dp[i][j] = Math.min(take, notTake);
    }
}