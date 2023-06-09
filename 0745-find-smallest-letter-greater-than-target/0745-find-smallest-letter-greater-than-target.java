class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        PriorityQueue<Character> pq = new PriorityQueue<>();
        for (char c : letters) {
            pq.add(c);
        }
        while (pq.size() > 0 && pq.peek() <= target) {
            pq.poll();
        }
        return pq.size() == 0 ? letters[0] : pq.poll();
    }
}