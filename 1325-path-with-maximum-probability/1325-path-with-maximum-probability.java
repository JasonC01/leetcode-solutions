class Solution {
    public class Point {
        List<double[]> adjList = new ArrayList<>();
        int val;

        public Point(int val) {
            this.val = val;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            points.add(new Point(i));
        }
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            double prob = succProb[i];
            points.get(from).adjList.add(new double[]{to, prob});
            points.get(to).adjList.add(new double[]{from, prob});
        }
        double[] prob = new double[n];
        prob[start] = 1;
        while (true) {
            boolean changed = false;
            for (Point point : points) {
                if (prob[point.val] != 0) {
                    for (double[] adj : point.adjList) {
                        if (prob[(int) adj[0]] < prob[point.val] * adj[1]) {
                            prob[(int) adj[0]] = prob[point.val] * adj[1];
                            changed = true;
                        }
                    }
                }
            }
            if (!changed) {
                break;
            }
        }
        return prob[end];
    }
}