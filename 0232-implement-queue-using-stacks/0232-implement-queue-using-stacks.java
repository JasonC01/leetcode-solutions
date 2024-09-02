class MyQueue {
        Stack<Integer> first = new Stack<>();
        Stack<Integer> second = new Stack<>();
        public MyQueue() {

        }

        public void push(int x) {
            if (first.isEmpty()) {
                while (!second.isEmpty()) {
                    first.add(second.pop());
                }
            }
            first.push(x);
        }

        public int pop() {
            if (second.isEmpty()) {
                while (!first.isEmpty()) {
                    second.add(first.pop());
                }
            }
            return second.pop();
        }

        public int peek() {
            if (second.isEmpty()) {
                while (!first.isEmpty()) {
                    second.add(first.pop());
                }
            }
            return second.peek();
        }

        public boolean empty() {
            return first.isEmpty() && second.isEmpty();
        }
    }