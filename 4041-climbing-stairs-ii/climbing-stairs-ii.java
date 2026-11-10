class Solution {
    public int climbStairs(int n, int[] costs) {

        long[] dp = new long[n + 1];
        long INF = Long.MAX_VALUE / 2;

        for (int i = 1; i <= n; i++) {
            dp[i] = INF;
        }

        dp[0] = 0;

        for (int i = 1; i <= n; i++) {

            for (int jump = 1; jump <= 3; jump++) {

                int prev = i - jump;

                if (prev >= 0) {
                    dp[i] = Math.min(
                        dp[i],
                        dp[prev] + costs[i - 1] + (long) jump * jump
                    );
                }
            }
        }

        return (int) dp[n];
    }
}