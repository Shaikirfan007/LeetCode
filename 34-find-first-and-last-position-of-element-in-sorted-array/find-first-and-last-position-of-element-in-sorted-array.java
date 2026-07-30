class Solution {

    public int[] searchRange(int[] nums, int target) {

        int first = firstOccurrence(nums, target);
        int last = lastOccurrence(nums, target);

        return new int[]{first, last};
    }

    public int firstOccurrence(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;
        int first = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] >= target) {

                if (nums[mid] == target)
                    first = mid;

                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return first;
    }

    public int lastOccurrence(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;
        int last = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] <= target) {

                if (nums[mid] == target)
                    last = mid;

                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return last;
    }
}