class Solution {
    int ans = 0;

    public int maximumRequests(int n, int[][] requests) {
        int[] inDegree = new int[n];
        helper(requests, inDegree, 0, 0);
        return ans;
    }

    public void helper(int[][] requests, int[] inDegree, int index, int count) {
        if (index > requests.length - 1) {
            for (int i : inDegree) {
                if (i != 0) {
                    return;
                }
            }
            ans = Math.max(ans, count);
            return;
        }
        inDegree[requests[index][0]]--;
        inDegree[requests[index][1]]++;
        helper(requests, inDegree, index + 1, count + 1);
        inDegree[requests[index][0]]++;
        inDegree[requests[index][1]]--;
        helper(requests, inDegree, index + 1, count);
    }
}