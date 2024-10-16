class Solution {
    public String longestDiverseString(int a, int b, int c) {
        HashMap<Character, Integer> counter = new HashMap<>();
        counter.put('a', a);
        counter.put('b', b);
        counter.put('c', c);
        PriorityQueue<Character> pq = new PriorityQueue<>((x, y) -> Integer.compare(counter.get(y), counter.get(x)));
        pq.add('a');
        pq.add('b');
        pq.add('c');
        StringBuilder sb = new StringBuilder();
        Character temp = null;
        while (!pq.isEmpty()) {
            Character curr = pq.poll();
            if (counter.get(curr) == 0) {
                continue;
            }
            if (sb.length() >= 2 && sb.charAt(sb.length() - 2) == curr && sb.charAt(sb.length() - 1) == curr) {
                temp = curr;
            } else {
                sb.append(curr);
                counter.merge(curr, 0, (x, y) -> x - 1);
                if (counter.get(curr) > 0) {
                    pq.add(curr);
                }
                if (temp != null) {
                    pq.add(temp);
                    temp = null;
                }
            }
        }
        return sb.toString();
    }
}