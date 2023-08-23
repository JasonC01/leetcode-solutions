class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> counter = new HashMap<>();
        for (char c : s.toCharArray()) {
            counter.merge(c, 1, (a, b) -> a + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> Integer.compare(counter.get(b), counter.get(a)));
        pq.addAll(counter.keySet());
        StringBuilder sb = new StringBuilder();
        char prev = '0';
        HashSet<Character> skipped = new HashSet<>();
        while (!pq.isEmpty()) {
            Character curr = pq.poll();
//            System.out.println(curr);
//            System.out.println(counter.get(curr));
//            System.out.println(prev);
//            System.out.println(sb.toString());
//            System.out.println(pq);
            if (prev != curr) {
                prev = curr;
                counter.merge(curr, 0, (a, b) -> a - 1);
                sb.append(curr);
                if (counter.get(curr) > 0) {
                    pq.add(curr);
                }
                if (!skipped.isEmpty()) {
                    pq.addAll(skipped);
                    skipped.removeAll(skipped);
                }
            } else {
                if (pq.size() == 0) {
//                    System.out.println(sb.toString());
                    return "";
                } else {
                    skipped.add(curr);
                    continue;
                }
            }


        }
        return sb.toString();

    }
}