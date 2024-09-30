 class CustomStack {

        class StackNode {
            int val;
            public StackNode(int val) {
                this.val = val;
            }
        }

        int maxSize;
        List<Integer> stack = new ArrayList<>();

        public CustomStack(int maxSize) {
            this.maxSize = maxSize;
        }

        public void push(int x) {
            if (stack.size() < maxSize) {
                stack.add(x);
            }
        }

        public int pop() {
            return stack.isEmpty() ? -1 : stack.remove(stack.size() - 1);
        }

        public void increment(int k, int val) {
            for (int i = 0; i < Math.min(k, stack.size()); i++) {
                stack.set(i, stack.get(i) + val);
            }
        }
    }


/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */