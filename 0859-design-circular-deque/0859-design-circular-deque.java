class MyCircularDeque {
        Stack<Integer> stack = new Stack<>();
        List<Integer> queue = new ArrayList<>();
        int maxSize;
        public MyCircularDeque(int k) {
            maxSize = k;
        }

        public boolean insertFront(int value) {
            if (queue.size() + stack.size() < maxSize) {
                stack.add(value);
                return true;
            }
            return false;
        }

        public boolean insertLast(int value) {
            if (queue.size() + stack.size() < maxSize) {
                queue.add(value);
                return true;
            }
            return false;
        }

        public boolean deleteLast() {
            if (!queue.isEmpty()) {
                queue.remove(queue.size() - 1);
            } else if (!stack.isEmpty()) {
                stack.remove(0);
            } else {
                return false;
            }
            return true;
        }

        public boolean deleteFront() {
            if (!stack.isEmpty()) {
                stack.pop();
            } else if (!queue.isEmpty()) {
                queue.remove(0);
            } else {
                return false;
            }
            return true;
        }

        public int getRear() {
            if (!queue.isEmpty()) {
                return queue.get(queue.size() - 1);
            } else if (!stack.isEmpty()) {
                return stack.get(0);
            } else {
                return -1;
            }
        }

        public int getFront() {
            if (!stack.isEmpty()) {
                return stack.peek();
            } else if (!queue.isEmpty()) {
                return queue.get(0);
            } else {
                return -1;
            }
        }

        public boolean isEmpty() {
            return stack.isEmpty() && queue.isEmpty();
        }

        public boolean isFull() {
            return (stack.size() + queue.size()) == maxSize;
        }
    }