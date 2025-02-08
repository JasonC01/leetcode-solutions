class NumberContainers {

        HashMap<Integer, Integer> indexMap = new HashMap<>();
        HashMap<Integer, PriorityQueue<Integer>> minIndex = new HashMap<>();
        public NumberContainers() {

        }

        public void change(int index, int number) {
            indexMap.put(index, number);
            if (!minIndex.containsKey(number)) {
                minIndex.put(number, new PriorityQueue<>(Comparator.comparing(x -> x)));
            }
            minIndex.get(number).add(index);
        }

        public int find(int number) {
            if (minIndex.containsKey(number)) {
                PriorityQueue<Integer> pq = minIndex.get(number);
                while (!pq.isEmpty() && indexMap.get(pq.peek()) != number) {
                    pq.poll();
                }
                return pq.isEmpty() ? -1 : pq.peek();
            }
            return -1;
        }
    }
    

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */