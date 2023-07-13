class Solution {
    List<List<Integer>> prereq = new ArrayList<>();
    List<List<Integer>> adjList = new ArrayList<>();
    boolean[] completed;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        completed = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            prereq.add(new ArrayList<>());
            adjList.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[0];
            int to = prerequisite[1];
            prereq.get(to).add(from);
            adjList.get(from).add(to);
        }
        List<Integer> canComplete = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (prereq.get(i).isEmpty()) {
                canComplete.add(i);
            }
        }
        for (int i : canComplete) {
            completeCourse(i);
        }
        boolean ans = true;
        for (boolean b : completed) {
            ans &= b;
        }
        return ans;
    }

    public void completeCourse(int currCourse) {
        if (prereq.get(currCourse).isEmpty()) {
            completed[currCourse] = true;
            for (int adj : adjList.get(currCourse)) {
                prereq.get(adj).remove((Integer) currCourse);
                completeCourse(adj);
            }
        }
    }
}