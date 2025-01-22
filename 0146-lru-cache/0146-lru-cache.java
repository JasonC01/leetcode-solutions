class DLNode {

        int key;
        int value;
        DLNode prev = null;
        DLNode next = null;

        public DLNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class LRUCache {

        int capacityLimit;
        int currentCapacity;
        HashMap<Integer, DLNode> nodesMap = new HashMap<>();
        DLNode head = null;
        DLNode tail = null;

        // updating cases
        // case 1. tobe updated is head: Do nothing
        // case 2. tobe updated is tail: update tail to next and update head.next to be tobe updated
        // case 3. tobe updated is tail and is equal to head: do nothing
        // 2 operations needed: move to front, delete from list.
        public LRUCache(int capacity) {
            capacityLimit = capacity;
        }

        public int get(int key) {
            if (!nodesMap.containsKey(key)) {
                return -1;
            }
            moveToFront(key);
            return head.value;
        }

        public void put(int key, int value) {
            if (nodesMap.containsKey(key)) {
                nodesMap.get(key).value = value;
                moveToFront(key);
            } else {
                if (capacityLimit == currentCapacity) {
                    nodesMap.remove(tail.key);
                    deleteFromBack();
                } else {
                    currentCapacity++;
                }
                DLNode newNode = new DLNode(key, value);
                if (head == null) {
                    head = newNode;
                    tail = newNode;
                } else {
                    head.next = newNode;
                    newNode.prev = head;
                    head = newNode;
                }
                nodesMap.put(key, newNode);
            }
        }

        public void moveToFront(int key) {
            DLNode curr = nodesMap.get(key);
            if (head.key == key) {
                return;
            }
            if (tail.key == key) {
                deleteFromBack();
            } else {
                DLNode prev = curr.prev;
                DLNode next = curr.next;
                if (prev != null) {
                    prev.next = next;
                }
                if (next != null) {
                    next.prev = prev;
                }
            }
            if (head == null) {
                head = curr;
                tail = curr;
                return;
            }
            head.next = curr;
            curr.prev = head;
            head = curr;
        }

        public void deleteFromBack() {
//            DLNode curr = nodesMap.remove(tail.key);
            if (tail.key == head.key) {
                head = null;
                tail = null;
            } else {
                DLNode next = tail.next;
                next.prev = null;
                tail = next;
            }
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */