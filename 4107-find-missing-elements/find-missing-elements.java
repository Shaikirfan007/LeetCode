class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        int expected = nums[0];
        int i = 0;

        while (expected <= nums[nums.length - 1]) {
            if (i < nums.length && nums[i] == expected) {
                i++;
            } else {
                ans.add(expected);
            }
            expected++;
        }

        return ans;
    }
}