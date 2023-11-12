class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        HashMap<Integer, List<Integer>> stationList = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            int[] route = routes[i];
            for (int station : route) {
                if (!stationList.containsKey(station)) {
                    stationList.put(station, new ArrayList<>());
                }
                stationList.get(station).add(i);
            }
        }
        if (!stationList.containsKey(target) || !stationList.containsKey(source)) {
            return -1;
        }
//
//
//        HashMap<Integer, List<Integer>> busList = new HashMap<>();
//        for (int i = 0; i < routes.length; i++) {
//            busList.put(i, new ArrayList<>());
//            for (int station : routes[i]) {
//                busList.get(i).addAll(stationList.get(station));
//            }
//        }
        Queue<Integer> queue = new ArrayDeque<>(stationList.get(target));
        int levelSize = queue.size();
        int level = 1;
        HashSet<Integer> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int currBus = queue.poll();
            if (stationList.get(source).contains(currBus)) {
                return level;
            }
            levelSize--;
            if (!visited.contains(currBus)) {
                visited.add(currBus);
                for (int i : routes[currBus]) {
                    for (int bus : stationList.get(i)) {
                        if (!visited.contains(bus)) {
                            queue.add(bus);
                        }
                    }
                }
            }
            if (levelSize == 0) {
                levelSize = queue.size();
                level++;
            }
        }
        return -1;
    }
}