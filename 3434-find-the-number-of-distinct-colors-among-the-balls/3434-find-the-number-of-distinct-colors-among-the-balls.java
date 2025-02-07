class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int[] res = new int[queries.length];
        HashMap<Integer, Integer> colourMap = new HashMap<>();
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int ball = query[0];
            int colour = query[1];
            if (colourMap.containsKey(ball)) {
                int currentColour = colourMap.get(ball);
                counter.merge(currentColour, 0, (a, b) -> a - 1);
                if (counter.get(currentColour) == 0) {
                    counter.remove(currentColour);
                }
            }
            colourMap.put(ball, colour);
            counter.merge(colour, 1, (a, b) -> a + 1);
            res[i] = counter.size();
        }
        return res;
    }
}