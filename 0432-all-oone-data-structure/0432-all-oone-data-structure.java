class LinkedNode {
        String val;
        int count;
        LinkedNode prev;
        LinkedNode next;

        public LinkedNode(String val) {
            this.val = val;
            count = 0;
            prev = null;
            next = null;
        }

        public void moveNext() {
            if (next != null) {
                LinkedNode tempNext = next.next;
                next.next = this;
                next.prev = prev;
                if (prev != null) {
                    prev.next = next;
                }
                prev = next;
                next = tempNext;
                if (tempNext != null) {
                    tempNext.prev = this;
                }
            }
        }

        public void movePrev() {
            if (prev != null) {
                // System.out.println(prev.val);
                LinkedNode tempPrev = prev.prev;
                prev.prev = this;
                prev.next = next;
                if (next != null) {
                    next.prev = prev;
                }
                next = prev;
                prev = tempPrev;
                if (tempPrev != null) {
                    tempPrev.next = this;
                }
            }
        }
    }

    class AllOne {
        HashMap<String, LinkedNode> map = new HashMap<>();
        LinkedNode first = null;
        LinkedNode last = null;
        public AllOne() {

        }

        public void inc(String key) {
            if (!map.containsKey(key)) {
                map.put(key, new LinkedNode(key));
            }
            LinkedNode curr = map.get(key);
            curr.count++;
            if (first == null && last == null) {
                first = curr;
                last = curr;
            } else {
                if (curr.next == null && curr.prev == null && curr.count == 1) {
                    curr.prev = first;
                    first.next = curr;
                    while (curr.prev != null && curr.count < curr.prev.count) {
                        curr.movePrev();
                    }
                } else {
                    while (curr.next != null && curr.count > curr.next.count) {
                        curr.moveNext();
                    }
                }
                first = curr.next == null ? curr : first;
                last = last.prev == null ? last : last.prev;
            }
        }

        public void dec(String key) {
            LinkedNode curr = map.get(key);
            curr.count--;
            while (curr.prev != null && curr.count < curr.prev.count) {
                curr.movePrev();
                first = first.next == null ? first : first.next;
            }
            if (curr.count == 0) {
                if (curr.next == null) {
                    first = null;
                    last = null;
                } else {
                    last = curr.next;
                    last.prev = null;
                }
            }
            // first = first.next == null ? first : first.next;
            // last = last.prev == null ? last : last.prev;
        }

        public String getMaxKey() {
            return first == null ? "" : first.val;
        }

        public String getMinKey() {
            LinkedNode curr = first;
            while (curr != null) {
                System.out.println(curr.val);
                curr = curr.next;
            }
            return last == null ? "" : last.val;
        }
    }