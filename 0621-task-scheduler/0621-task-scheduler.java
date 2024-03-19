class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> counter = new HashMap<>();
        HashMap<Character, Integer> prev = new HashMap<>();
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> Integer.compare(counter.get(b), counter.get(a)));
        int currTime = 0;
        for (char c : tasks) {
            counter.merge(c, 1, (a, b) -> a + 1);
        }
        pq.addAll(counter.keySet());
        while (!pq.isEmpty()) {
            boolean added = false;
            HashSet<Character> removed = new HashSet<>();
            while (!pq.isEmpty() && !added) {

                char curr = pq.poll();
                removed.add(curr);
                if (prev.containsKey(curr) && prev.get(curr) + n > currTime) {
                } else {
                    added = true;
                    counter.merge(curr, 0, (a, b) -> a - 1);
                    currTime++;
                    prev.put(curr, currTime);
                }
            }
            for (char c : removed) {
                if (counter.get(c) > 0) {
                    pq.add(c);
                }
            }
            if (!added) {
                currTime++;
            }
        }
        return currTime;
    }
}