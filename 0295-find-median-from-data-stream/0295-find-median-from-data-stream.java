class MedianFinder {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparing(x -> x));
        public MedianFinder() {

        }

        public void addNum(int num) {
            if (maxHeap.isEmpty() || minHeap.isEmpty()) {
                maxHeap.add(num);
            } else {
                if (maxHeap.peek() >= num) {
                    maxHeap.add(num);
                } else {
                    minHeap.add(num);
                }
            }
        }

        public double findMedian() {
            int totalSize = maxHeap.size() + minHeap.size();
            while (maxHeap.size() > Math.ceil(totalSize / 2.0)) {
                minHeap.add(maxHeap.poll());
            }
            while (minHeap.size() > Math.floorDiv(totalSize, 2)) {
                maxHeap.add(minHeap.poll());
            }
            // System.out.println(minHeap);
            // System.out.println(maxHeap);
            return totalSize % 2 == 1 ? maxHeap.peek() : (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */