class MinStack {
        List<Integer> stack = new ArrayList<>();
        List<Integer> mins = new ArrayList<>();
        public MinStack() {

        }

        public void push(int val) {
            stack.add(val);
            if (stack.size() == 1) {
                mins.add(val);
            } else {
                mins.add(Math.min(mins.get(mins.size() - 1), val));
            }
        }

        public void pop() {
            stack.remove(stack.size() - 1);
            mins.remove(mins.size() - 1);
        }

        public int top() {
            return stack.get(stack.size() - 1);
        }

        public int getMin() {
            return mins.get(mins.size() - 1);
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */