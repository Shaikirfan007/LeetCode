class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        int pos0 = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                pos0 = i;
                break;
            }
        }

        // Check cyclic increasing
        boolean inc = true;
        for (int i = 0; i < n; i++) {
            if (nums[(i + 1) % n] != (nums[i] + 1) % n) {
                inc = false;
                break;
            }
        }

        int ans = Integer.MAX_VALUE;

        if (inc) {
            // rotate left pos0 times
            ans = Math.min(ans, pos0);

            // simulate rotating right (reverse + rotate + reverse)
            ans = Math.min(ans, (n - pos0) + 2);
        }

        // Check cyclic decreasing
        boolean dec = true;
        for (int i = 0; i < n; i++) {
            if (nums[(i + 1) % n] != (nums[i] - 1 + n) % n) {
                dec = false;
                break;
            }
        }

        if (dec) {
            // Reverse first, then rotate
            ans = Math.min(ans, 1 + (n - 1 - pos0));

            // Rotate first, then reverse
            ans = Math.min(ans, 1 + (pos0 + 1));
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}