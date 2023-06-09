class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> Integer.compare(a[1], b[1]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        int currDay = 0;
        for (int[] course : courses) {
            if (currDay + course[0] <= course[1]) {
                currDay = currDay + course[0];
                pq.add(course);
            } else {
                if (pq.size() > 0 && pq.peek()[0] >= course[0]) {
                    currDay -= pq.poll()[0];
                    currDay += course[0];
                    pq.add(course);
                }
            }
        }
        return pq.size();
    }
}