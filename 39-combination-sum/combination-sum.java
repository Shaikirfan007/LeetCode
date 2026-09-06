import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start,
                           List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current)); // found a valid combination
            return;
        }
        if (target < 0) return; // invalid path

        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]); // choose
            backtrack(candidates, target - candidates[i], i, current, result); 
            current.remove(current.size() - 1); // undo choice (backtrack)
        }
    }
}
