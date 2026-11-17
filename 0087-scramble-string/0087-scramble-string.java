class Solution {

    int[][][] dp;

    public boolean isScramble(String s1, String s2) {
        int n = s1.length();

        if (n != s2.length()) {
            return false;
        }

        dp = new int[n][n][n + 1];

        return solve(s1, s2, 0, 0, n);
    }

    private boolean solve(String s1, String s2, int i, int j, int len) {

        // If both substrings are equal
        if (s1.substring(i, i + len).equals(s2.substring(j, j + len))) {
            return true;
        }

        // Check memoization
        if (dp[i][j][len] != 0) {
            return dp[i][j][len] == 1;
        }

        // Check character frequencies
        int[] count = new int[26];

        for (int k = 0; k < len; k++) {
            count[s1.charAt(i + k) - 'a']++;
            count[s2.charAt(j + k) - 'a']--;
        }

        for (int c : count) {
            if (c != 0) {
                dp[i][j][len] = -1;
                return false;
            }
        }

        // Try every possible splitting position
        for (int k = 1; k < len; k++) {

            // Case 1: Without swapping
            if (solve(s1, s2, i, j, k) &&
                solve(s1, s2, i + k, j + k, len - k)) {

                dp[i][j][len] = 1;
                return true;
            }

            // Case 2: With swapping
            if (solve(s1, s2, i, j + len - k, k) &&
                solve(s1, s2, i + k, j, len - k)) {

                dp[i][j][len] = 1;
                return true;
            }
        }

        dp[i][j][len] = -1;
        return false;
    }
}