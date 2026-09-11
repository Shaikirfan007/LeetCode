import java.util.*;

class Solution {
    public int totalNumbers(int[] digits) {
        // Frequency of digits in input
        int[] freq = new int[10];
        for (int d : digits) {
            freq[d]++;
        }

        Set<Integer> set = new HashSet<>();

        // Check all 3-digit numbers
        for (int num = 100; num <= 999; num++) {
            if (num % 2 != 0) continue; // must be even

            int[] temp = Arrays.copyOf(freq, 10);
            int x = num;
            boolean valid = true;

            // Check digits of num
            for (int i = 0; i < 3; i++) {
                int d = x % 10;
                if (temp[d] == 0) {
                    valid = false;
                    break;
                }
                temp[d]--;
                x /= 10;
            }

            if (valid) {
                set.add(num);
            }
        }

        return set.size();
    }
}
