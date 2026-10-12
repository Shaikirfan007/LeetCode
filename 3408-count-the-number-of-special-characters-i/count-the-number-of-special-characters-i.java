import java.util.*;

class Solution {
    public int numberOfSpecialChars(String word) {
        // Sets to track lowercase and uppercase letters
        Set<Character> lower = new HashSet<>();
        Set<Character> upper = new HashSet<>();
        // Traverse the string
        for (char ch : word.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                lower.add(ch);
            } else if (Character.isUpperCase(ch)) {
                upper.add(ch);
            }
        }
        int count = 0;
        // Check for letters that appear in both cases
        for (char ch : lower) {
            if (upper.contains(Character.toUpperCase(ch))) {
                count++;
            }
        }
        return count;
    }
}
