class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int n = s.length();
        int[] dp = new int[n + 1];
        
        // Base case: empty string has 1 way to decode
        dp[0] = 1;
        
        // First character check
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        
        for (int i = 2; i <= n; i++) {
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));
            
            // If single digit is valid (1–9)
            if (oneDigit >= 1 && oneDigit <= 9) {
                dp[i] += dp[i - 1];
            }
            
            // If two digits are valid (10–26)
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[n];
    }
}
