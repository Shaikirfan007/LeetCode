import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;
    long[][] comb; // Precomputed combinations

    public int numOfWays(int[] nums) {
        int n = nums.length;
        // Precompute binomial coefficients (Pascal's triangle)
        comb = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            comb[i][0] = comb[i][i] = 1;
            for (int j = 1; j < i; j++) {
                comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
            }
        }
        return (int)((dfs(nums) - 1 + MOD) % MOD); // subtract 1 to exclude original order
    }

    private long dfs(int[] nums) {
        if (nums.length <= 2) return 1;

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int root = nums[0];

        // Partition into left and right subtrees
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < root) left.add(nums[i]);
            else right.add(nums[i]);
        }

        long leftWays = dfs(left.stream().mapToInt(i -> i).toArray());
        long rightWays = dfs(right.stream().mapToInt(i -> i).toArray());

        // Ways = C(n-1, leftSize) * leftWays * rightWays
        return (((comb[nums.length - 1][left.size()] * leftWays) % MOD) * rightWays) % MOD;
    }
}
