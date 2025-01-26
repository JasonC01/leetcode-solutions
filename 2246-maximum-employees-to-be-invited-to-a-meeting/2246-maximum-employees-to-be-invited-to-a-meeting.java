class Solution {
    int cycleMax = 0;
    int[] resList;
    public int maximumInvitations(int[] favorite) {
        int[] inDegree = new int[favorite.length];
        boolean[] terminalNodes = new boolean[favorite.length];
        boolean[] cycle = new boolean[favorite.length];
        resList = new int[favorite.length];
        for (int i = 0 ; i < favorite.length; i++) {
            inDegree[favorite[i]]++;
            terminalNodes[i] = i == favorite[favorite[i]];
        }
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) generateResList(favorite, i, terminalNodes, 0, new boolean[favorite.length]);
        }
        boolean[] visited = new boolean[favorite.length];
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] > 0) getCycleMax(favorite, i, i, 0, visited, cycle);
        }
        int res = 0;
        for (int i = 0; i < resList.length; i++) {
            if (terminalNodes[i] && resList[i] > 0 && resList[favorite[i]] > 0) {
                resList[favorite[i]] -= 2;
            } else if (terminalNodes[i] && resList[i] == 0 && resList[favorite[i]] == 0) {
                res += 1;
            }
            res += resList[i];
        }
        return Math.max(cycleMax, res);
    }

    public int[] getCycleMax(int[] adjList, int curr, int startNode, int res, boolean[] visited, boolean[] cycle) {
        if (visited[curr]) {
            if (startNode == curr) {
                cycleMax = Math.max(cycleMax, res);
            }
            return new int[]{curr, res};
        }
        visited[curr] = true;
        int[] endNode = getCycleMax(adjList, adjList[curr], startNode, res + 1, visited, cycle);
        if (curr == endNode[0]) {
            cycleMax = Math.max(cycleMax, endNode[1] - res);
        }
//        visited[curr] = false;
//        cycle[curr] = true;
        return endNode;
    }

    public void generateResList(int[] adjList, int curr, boolean[] terminalNodes, int res, boolean[] visited) {
        if (visited[curr]) {
            if (terminalNodes[curr]) {
                resList[curr] = Math.max(resList[curr], res);
            }
            return;
        }
        visited[curr] = true;
        generateResList(adjList, adjList[curr], terminalNodes, res + 1, visited);
        visited[curr] = false;
    }
}

// case 1. complete cycle - update cyclesmax. need to mark current node as cycle so that it is not traversed the next time
// case 2. ends with a terminal node - add to result