import java.util.*;

class Solution {
    public String lexGreaterPermutation(String s, String target) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars); // start with smallest order
        boolean[] used = new boolean[chars.length];
        StringBuilder result = new StringBuilder();
        
        if (dfs(chars, target, 0, used, result)) {
            return result.toString();
        }
        return "";
    }

    private boolean dfs(char[] chars, String target, int index, boolean[] used, StringBuilder result) {
        if (index == chars.length) {
            return result.toString().compareTo(target) > 0;
        }
        
        for (int i = 0; i < chars.length; i++) {
            if (used[i]) continue;
            // Skip duplicates
            if (i > 0 && chars[i] == chars[i-1] && !used[i-1]) continue;
            
            result.append(chars[i]);
            used[i] = true;
            
            // Prune: if prefix already greater, fill rest greedily
            if (result.toString().compareTo(target.substring(0, index+1)) >= 0) {
                if (dfs(chars, target, index+1, used, result)) return true;
            }
            
            // backtrack
            used[i] = false;
            result.deleteCharAt(result.length()-1);
        }
        return false;
    }
}
