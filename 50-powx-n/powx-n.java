class Solution {
    public double myPow(double x, int n) {
        // Handle negative exponent
        long exp = n; // use long to avoid overflow when n = Integer.MIN_VALUE
        if (exp < 0) {
            x = 1 / x;
            exp = -exp;
        }

        double result = 1.0;
        double base = x;

        while (exp > 0) {
            if ((exp % 2) == 1) { // if odd
                result *= base;
            }
            base *= base; // square the base
            exp /= 2;     // halve the exponent
        }

        return result;
    }
}
