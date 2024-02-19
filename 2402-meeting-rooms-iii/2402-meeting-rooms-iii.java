class Solution {
    public int mostBooked(int n, int[][] meetings) {
        long[] nextAvailableTiming = new long[n];
        int[] count = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparing(x -> nextAvailableTiming[x]));
        for (int i = 0; i < n; i++) {
            pq.add(i);
        }
        Arrays.sort(meetings, Comparator.comparing(x -> x[0]));
        Queue<int[]> q = new ArrayDeque<>(Arrays.asList(meetings));
        while (!q.isEmpty()) {
            int[] currentMeeting = q.poll();
            int start = currentMeeting[0];
            int end = currentMeeting[1];
            int interval = end - start;
            List<Integer> availableRooms = new ArrayList<>();
            int minRoom = Integer.MAX_VALUE;
            while (!pq.isEmpty() && nextAvailableTiming[pq.peek()] <= start) {
                int room = pq.poll();
                availableRooms.add(room);
                minRoom = Math.min(minRoom, room);
            }
            if (availableRooms.isEmpty()) {
                int room = pq.poll();
                availableRooms.add(room);
                minRoom = room;
                while (!pq.isEmpty() && nextAvailableTiming[pq.peek()] == nextAvailableTiming[room]) {
                    int currRoom = pq.poll();
                    availableRooms.add(currRoom);
                    minRoom = Math.min(minRoom, currRoom);
                }
            }

//            int room = pq.poll();
            long nextAvailableTime = nextAvailableTiming[minRoom];

            if (start < nextAvailableTime) {
                nextAvailableTiming[minRoom] += interval;
            } else {
                nextAvailableTiming[minRoom] = end;
            }
            count[minRoom]++;
            pq.addAll(availableRooms);
        }
        System.out.println(Arrays.toString(count));
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] > max) {
                maxIndex = i;
                max = count[i];
            }
        }
        return maxIndex;
    }
}