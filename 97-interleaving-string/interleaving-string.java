class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), l = s3.length();
        
        // If lengths don't add up, it's impossible
        if (n + m != l) return false;
        
        // dp[i][j] means: can s3[0..i+j-1] be formed by interleaving s1[0..i-1] and s2[0..j-1]?
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        
        // Fill first column (using only s1)
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        
        // Fill first row (using only s2)
        for (int j = 1; j <= m; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        
        // Fill the rest
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char c = s3.charAt(i + j - 1);
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == c) ||
                           (dp[i][j - 1] && s2.charAt(j - 1) == c);
            }
        }
        
        return dp[n][m];
    }
}
