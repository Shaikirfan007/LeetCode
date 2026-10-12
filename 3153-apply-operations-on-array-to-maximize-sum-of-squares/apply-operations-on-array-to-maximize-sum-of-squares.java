import java.util.*;

class Solution {
    public int maxSum(List<Integer> nums, int k) {
        final int MOD = 1_000_000_007;
        int[] bitCount = new int[32]; // count of set bits at each position
        
        // Count bits across all numbers
        for (int num : nums) {
            for (int b = 0; b < 32; b++) {
                if (((num >> b) & 1) == 1) {
                    bitCount[b]++;
                }
            }
        }
        
        // Build up to k numbers by greedily assigning bits
        long[] constructed = new long[k];
        for (int b = 31; b >= 0; b--) {
            for (int i = 0; i < bitCount[b] && i < k; i++) {
                constructed[i] |= (1L << b);
            }
        }
        
        // Sort and take the largest k numbers
        Arrays.sort(constructed);
        long result = 0;
        for (int i = k - 1; i >= 0; i--) {
            result = (result + constructed[i] * constructed[i]) % MOD;
        }
        
        return (int) result;
    }
}
