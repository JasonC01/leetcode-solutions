class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        List<int[]> horizontal = new ArrayList<>();
        List<int[]> vertical = new ArrayList<>();
        for (int[] coord : rectangles) {
            int[] hor = new int[]{coord[0], coord[2]};
            int[] vert = new int[]{coord[1], coord[3]};
            horizontal.add(hor);
            vertical.add(vert);
        }
        horizontal.sort(Comparator.comparing(x -> x[0]));
        vertical.sort(Comparator.comparing(x -> x[0]));
        List<int[]> horAns = new ArrayList<>();
        List<int[]> vertAns = new ArrayList<>();
        int prevStart = -1;
        int prevEnd = -1;
        for (int[] i : horizontal) {
            if (prevStart == -1 && prevEnd == -1) {
                prevStart = i[0];
                prevEnd = i[1];
                continue;
            }
            int currStart = i[0];
            int currEnd = i[1];
            if (currStart >= prevEnd) {
                horAns.add(new int[]{prevStart, prevEnd});
                prevStart = currStart;
                prevEnd = currEnd;
            } else {
                prevEnd = Math.max(prevEnd, currEnd);
            }
        }
        horAns.add(new int[]{prevStart, prevEnd});
        prevStart = -1;
        prevEnd = -1;
        for (int[] i : vertical) {
            if (prevStart == -1 && prevEnd == -1) {
                prevStart = i[0];
                prevEnd = i[1];
                continue;
            }
            int currStart = i[0];
            int currEnd = i[1];
            if (currStart >= prevEnd) {
                vertAns.add(new int[]{prevStart, prevEnd});
                prevStart = currStart;
                prevEnd = currEnd;
            } else {
                prevEnd = Math.max(prevEnd, currEnd);
            }
        }
        vertAns.add(new int[]{prevStart, prevEnd});
        return vertAns.size() >= 3 || horAns.size() >= 3;
    }
}