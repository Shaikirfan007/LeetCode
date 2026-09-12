import java.util.*;

class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(endGene)) return -1;

        // Queue for paths (gene + steps)
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);
        Map<String, Integer> stepsMap = new HashMap<>();
        stepsMap.put(startGene, 0);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            int steps = stepsMap.get(current);

            if (current.equals(endGene)) return steps;

            for (String next : bankSet) {
                if (!stepsMap.containsKey(next) && differsByOne(current, next)) {
                    stepsMap.put(next, steps + 1);
                    queue.offer(next);
                }
            }
        }
        return -1;
    }

    // Helper: check if two genes differ by exactly one character
    private boolean differsByOne(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
            if (diff > 1) return false;
        }
        return diff == 1;
    }
}
