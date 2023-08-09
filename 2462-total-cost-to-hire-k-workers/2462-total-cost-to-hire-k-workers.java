class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        Deque<Integer> q = new ArrayDeque<>();
        for (int i : costs) {
            q.add(i);
        }
        PriorityQueue<Integer> first = new PriorityQueue<>();
        PriorityQueue<Integer> second = new PriorityQueue<>();
        while (first.size() < candidates && !q.isEmpty()) {
            first.add(q.pollFirst());
        }
        while (second.size() < candidates && !q.isEmpty()) {
            second.add(q.pollLast());
        }
        long cost = 0;
        int hired = 0;
        boolean hiredFirst = true;
        while (hired < k) {
            if (second.isEmpty()) {
                cost += first.poll();
                hiredFirst = true;
            } else if (first.isEmpty()) {
                cost += second.poll();
                hiredFirst = false;
            } else {
                if (first.peek() <= second.peek()) {
                    cost += first.poll();
                    hiredFirst = true;
                } else {
                    cost += second.poll();
                    hiredFirst = false;
                }
            }
            if (!q.isEmpty()) {
                if (hiredFirst) {
                    first.add(q.pollFirst());
                } else {
                    second.add(q.pollLast());
                }
            }
            hired++;
        }
        return cost;
    }
}