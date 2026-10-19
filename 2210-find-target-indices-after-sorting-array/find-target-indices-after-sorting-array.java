import java.util.*;

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        // Step 1: Sort the array
        Arrays.sort(nums);
        
        // Step 2: Collect indices where nums[i] == target
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                result.add(i);
            }
        }
        
        return result;
    }
}
