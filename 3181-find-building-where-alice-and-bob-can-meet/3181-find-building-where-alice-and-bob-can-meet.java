class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int[][] newQ = new int[queries.length][3];
        for (int i = 0; i < queries.length; i++) {
            newQ[i] = new int[]{Math.min(queries[i][0], queries[i][1]), Math.max(queries[i][0], queries[i][1]), i};
        }
        Arrays.sort(newQ, (a, b) -> Integer.compare(b[1], a[1]));
        Stack<int[]> s = new Stack<>();
        int[] ans = new int[queries.length];
        for (int i = 0; i < ans.length; i++) {
            int[] query = newQ[i];
            for (int j = (i > 0 ? newQ[i - 1][1] : heights.length - 1); j >= query[1]; j--) {
                while (!s.isEmpty() && s.peek()[0] <= heights[j]) {
                    s.pop();
                }
                s.push(new int[]{heights[j], j});
            }
            // for (int[] arr : s) {
            //     System.out.println(Arrays.toString(arr));
            
            // }
            // System.out.println("//");
            if (query[0] == query[1] || heights[query[1]] > heights[query[0]]) {
                ans[query[2]] = query[1];
            } else {
                int index = bSearch(s, heights[query[0]]);
                // System.out.println(Arrays.toString(query));
                // System.out.println(index);
                ans[newQ[i][2]] = s.get(index)[0] > heights[query[0]] ? s.get(index)[1] : -1;
            }
        }
        return ans;
    }
    
    public int bSearch(Stack<int[]> s, int target) {
        int low = 0;
        int high = s.size() - 1;
        while (low < high) {
            int mid = (int) Math.ceil((low + high) / 2.0);
            if (s.get(mid)[0] > target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}