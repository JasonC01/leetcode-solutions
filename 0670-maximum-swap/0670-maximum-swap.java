class Solution {
    public int maximumSwap(int num) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? Integer.compare(b[1], a[1]) : Integer.compare(b[0], a[0]));
        char[] chars = String.valueOf(num).toCharArray();
        List<int[]> arr = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            arr.add(new int[]{Integer.parseInt(String.valueOf(chars[i])), i});
            pq.add(arr.get(i));
        }
        int[] toswap = new int[2];
        for (int i = 0; i < chars.length && !pq.isEmpty(); i++) {
            int[] curr = pq.peek();
            if (Integer.parseInt(String.valueOf(chars[i])) < curr[0]) {
                toswap[0] = i;
                toswap[1] = curr[1];
                break;
            }
            pq.remove(arr.get(i));
        }
        char temp = chars[toswap[0]];
        chars[toswap[0]] = chars[toswap[1]];
        chars[toswap[1]] = temp;
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            sb.append(c);
        }
        return Integer.parseInt(sb.toString());
    }
}