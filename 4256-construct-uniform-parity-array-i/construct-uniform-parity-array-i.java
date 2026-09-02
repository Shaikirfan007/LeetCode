class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;

        // If all numbers are even or all are odd, it's trivially true
        boolean allEven = true, allOdd = true;
        for (int num : nums1) {
            if (num % 2 == 0) allOdd = false;
            else allEven = false;
        }
        if (allEven || allOdd) return true;

        // Otherwise, check if we can use differences
        // Key observation:
        // nums2[i] = nums1[i] - nums1[j]
        // Parity of (a - b) = parity of (a + b) since subtraction ≡ addition mod 2
        // So (a - b) is even if a and b have same parity, odd if different parity.

        // If there exists at least one even and one odd in nums1,
        // then we can always construct nums2 all odd:
        // - Pick nums2[i] = nums1[i] if nums1[i] is odd
        // - Pick nums2[i] = nums1[i] - (some even) if nums1[i] is even
        // That makes everything odd.
        boolean hasEven = false, hasOdd = false;
        for (int num : nums1) {
            if (num % 2 == 0) hasEven = true;
            else hasOdd = true;
        }

        return hasEven && hasOdd; // if both exist, we can make all odd
    }
}
