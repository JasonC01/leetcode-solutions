class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] isPrerequisite = new boolean[numCourses][numCourses];
        for (int[] prerequisite : prerequisites) {
            isPrerequisite[prerequisite[0]][prerequisite[1]] = true;
        }
        for (int i = 0; i < numCourses; i++) {
            for (int j = 0; j < numCourses; j++) {
                for (int k = 0; k < numCourses; k++) {
                    isPrerequisite[j][k] |= isPrerequisite[j][i] && isPrerequisite[i][k];
                }
            }
        }
        // System.out.println(Arrays.deepToString(isPrerequisite));
        List<Boolean> ans = new ArrayList<>();
        for (int[] query : queries) {
            ans.add(isPrerequisite[query[0]][query[1]]);
        }
        return ans;
    }
}