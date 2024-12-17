class Solution {
     public String repeatLimitedString(String s, int repeatLimit) {
        HashMap<Character, Integer> counter = new HashMap<>();
        for (char c : s.toCharArray()) {
            counter.merge(c, 1 , (a, b) -> a + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> Character.compare(b, a));
        pq.addAll(counter.keySet());
        StringBuilder sb = new StringBuilder();
        int samecount = 0;
        Character reserved = null;
        while (!pq.isEmpty()) {
            char curr = pq.poll();
            counter.merge(curr, 0, (a, b) -> a - 1);
            if (sb.isEmpty() || sb.charAt(sb.length() - 1) == curr) {
                samecount++;
            } else {
                samecount = 1;
            }
            if (reserved != null) {
                pq.add(reserved);
                reserved = null;
            }
            sb.append(curr);
            if (samecount == repeatLimit) {
                if (counter.get(curr) > 0) {
                    reserved = curr;
                }
                continue;
            }
            if (counter.get(curr) > 0) {
                pq.add(curr);
            }
        }
        return sb.toString();
    }
}