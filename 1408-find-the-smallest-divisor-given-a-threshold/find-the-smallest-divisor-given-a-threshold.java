class Solution {

    public int smallestDivisor(int[] nums, int limit) {

        int low = 1;
        int high = Integer.MIN_VALUE;

        for (int num : nums) {
            high = Math.max(high, num);
        }

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (isPossible(nums, mid, limit)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean isPossible(int[] nums, int divisor, int limit) {

        int sum = 0;

        for (int num : nums) {
            sum += (num + divisor - 1) / divisor;   // ceil(num/divisor)
        }

        return sum <= limit;
    }
}