class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> counter = new HashMap<>();
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> Integer.compare(counter.get(b), counter.get(a)));
        for (char c : tasks) {
            counter.merge(c, 1, (a, b) -> a + 1);
        }
        pq.addAll(counter.keySet());
        int time = 0;
        Queue<int[]> idle = new ArrayDeque<>();
        while (!pq.isEmpty() || !idle.isEmpty()) {
            if (!pq.isEmpty()) {
                char curr = pq.poll();
                counter.merge(curr, 0, (a, b) -> a - 1);
                if (counter.get(curr) > 0) {
                    idle.add(new int[]{curr, time + n});
                }
            }
            while (!idle.isEmpty() && idle.peek()[1] <= time) {
                pq.add((char) idle.poll()[0]);
            }
            time++;
        }
        return time;
    }
}