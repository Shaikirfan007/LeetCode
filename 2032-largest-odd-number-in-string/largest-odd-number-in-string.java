class Solution {
    public String largestOddNumber(String num) {
        // Traverse from the end of the string
        for (int i = num.length() - 1; i >= 0; i--) {
            int digit = num.charAt(i) - '0'; // convert char to int
            if (digit % 2 == 1) { // check if odd
                return num.substring(0, i + 1); // return substring up to this odd digit
            }
        }
        // No odd digit found
        return "";
    }
}
