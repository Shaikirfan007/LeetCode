import java.util.*;

class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);

        HashMap<Long, Integer> dp = new HashMap<>();
        int ans = 0;

        for (int x : nums) {
            long num = x;

            int useAsX = dp.getOrDefault(num - 1, 0) + 1;
            int useAsXPlus1 = dp.getOrDefault(num, 0) + 1;

            dp.put(num, Math.max(dp.getOrDefault(num, 0), useAsX));
            dp.put(num + 1,
                   Math.max(dp.getOrDefault(num + 1, 0), useAsXPlus1));

            ans = Math.max(ans,
                    Math.max(dp.get(num), dp.get(num + 1)));
        }

        return ans;
    }
}