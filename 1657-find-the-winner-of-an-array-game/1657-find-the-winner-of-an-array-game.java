class Solution {
    public int getWinner(int[] arr, int k) {
        Queue<Integer> queue = new ArrayDeque<>();
        int maxVal = arr[0];
        for (int i : arr) {
            queue.add(i);
            maxVal = Math.max(maxVal, i);
        }
        if (k > arr.length) {
            return maxVal;
        }
        int winCount = 0;
        int curr = queue.poll();
        while (winCount != k) {
            int next = queue.poll();
            if (next > curr) {
                curr = next;
                winCount = 1;
                queue.add(curr);
            } else {
                winCount++;
                queue.add(next);
            }
        }
        return curr;
    }
}