class DLNodes {
        int val;
        int key;
        DLNodes prev = null;
        DLNodes next = null;
        public DLNodes(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }
class LRUCache {

        DLNodes head = null;
        DLNodes tail = null;
        int currentCapacity = 0;
        int maxCapacity;
        HashMap<Integer, DLNodes> nodeMap = new HashMap<>();

        public LRUCache(int capacity) {
            maxCapacity = capacity;
        }

        public int get(int key) {
            if (nodeMap.containsKey(key)) {
                remove(nodeMap.get(key));
                insertFront(nodeMap.get(key));
                return nodeMap.get(key).val;
            }
            return -1;
        }

        public void insertFront(DLNodes node) {
            if (head == null && tail == null) {
                head = node;
                tail = node;
            } else {
                node.prev = head;
                head.next = node;
                head = node;
            }
        }
        
        public void remove(DLNodes node) {
            if (node.key == head.key && node.key == tail.key) {
                head = null;
                tail = null;
            } else if (node.key == head.key) {
                head = head.prev;
                head.next = null;
            } else if (tail.key == node.key) {
                tail = tail.next;
                tail.prev = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            node.prev = null;
            node.next = null;
        }

        public void put(int key, int value) {
            if (nodeMap.containsKey(key)) {
                nodeMap.get(key).val = value;
                remove(nodeMap.get(key));
                insertFront(nodeMap.get(key));
            } else {
                if (currentCapacity == maxCapacity) {
                    DLNodes toBeRemoved = tail;
                    remove(toBeRemoved);
                    nodeMap.remove(toBeRemoved.key);
                } else {
                    currentCapacity++;
                }
                DLNodes newNode = new DLNodes(key, value);
                nodeMap.put(key, newNode);
                insertFront(newNode);
            }
        }
    }