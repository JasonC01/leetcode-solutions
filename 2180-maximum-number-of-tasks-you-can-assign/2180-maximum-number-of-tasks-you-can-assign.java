class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int low = 0;
        int high = Math.min(tasks.length, workers.length);
        while (low < high) {
            int mid = (int) Math.ceil((low + high) / 2.0);
            if (isPossible(tasks, workers, mid, pills, strength)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean isPossible(int[] tasks, int[] workers, int k, int pills, int strength) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int remainingPills = pills;
        for (int i = workers.length - k; i < workers.length; i++) {
            map.merge(workers[i], 1, (a, b) -> a + 1);
        }
        for (int i = k - 1; i >= 0; i--) {
            int currentTask = tasks[i];
            int currentWorker = map.lastKey();
            if (currentWorker >= currentTask) {
                map.merge(currentWorker, 0, (a, b) -> a - 1);
                if (map.get(currentWorker) == 0) map.remove(currentWorker);
            } else if (remainingPills > 0) {
                Integer key = map.ceilingKey(currentTask - strength);
                if (key == null) {
                    return false;
                }
                map.merge(key, 0, (a, b) -> a - 1);
                if (map.get(key) == 0) map.remove(key);
                remainingPills--;
            } else {
                return false;
            }
        }
        return true;
    }
}
