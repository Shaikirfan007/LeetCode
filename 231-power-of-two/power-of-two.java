class Solution {
    public boolean isPowerOfTwo(int n) {
        // A power of two must be positive
        if (n <= 0) return false;
        
        // Bit trick: n & (n - 1) == 0 only if n is a power of two
        return (n & (n - 1)) == 0;
    }
}
