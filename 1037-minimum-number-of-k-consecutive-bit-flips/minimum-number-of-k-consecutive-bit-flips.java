class Solution {
    public int minKBitFlips(int[] nums, int k) {

        int n = nums.length;
        int[] diff = new int[n + 1];

        int activeFlips = 0;
        int flips = 0;

        for (int i = 0; i < n; i++) {

            // Add/remove flips that affect the current position
            activeFlips += diff[i];

            // Effective value after considering active flips
            if ((nums[i] + activeFlips) % 2 == 0) {

                // Not enough elements remaining for a k-size flip
                if (i + k > n) {
                    return -1;
                }

                // Start a new flip
                flips++;
                activeFlips++;

                // This flip stops affecting positions from i + k
                diff[i + k]--;
            }
        }

        return flips;
    }
}