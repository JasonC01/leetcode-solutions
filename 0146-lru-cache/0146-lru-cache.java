class DLNode {
        int key;
        int val;
        DLNode next = null;
        DLNode prev = null;

        public DLNode(int key, int val) {
            this.key = key;
            this.val = val;
        }

        
    }

    class LRUCache {

        int maximumCapacity;
        int currentCapacity = 0;

        HashMap<Integer, DLNode> nodesMap = new HashMap<>();
        DLNode head = null;
        DLNode tail = null;

        public LRUCache(int capacity) {
            this.maximumCapacity = capacity;
        }

        public int get(int key) {
             if (!nodesMap.containsKey(key)) {
                 return -1;
             } else {
                 DLNode currentNode = nodesMap.get(key);
                 deleteNode(currentNode);
                 insertFront(currentNode);
                 return currentNode.val;
             }
        }

        public void put(int key, int value) {
            if (nodesMap.containsKey(key)) {
                DLNode currentNode = nodesMap.get(key);
                currentNode.val = value;
                deleteNode(currentNode);
                insertFront(currentNode);
            } else {
                if (currentCapacity == maximumCapacity) {
                    int tailKey = tail.key;
                    deleteNode(tail);
                    nodesMap.remove(tailKey);
                } else {
                    currentCapacity++;
                }
                DLNode newNode = new DLNode(key, value);
                nodesMap.put(key, newNode);
                insertFront(newNode);
            }
        }

        public void insertFront(DLNode node) {
            if (head == null) {
                head = node;
                tail = node;
            } else {
                head.next = node;
                node.prev = head;
                head = node;
            }
        }

        public void deleteNode(DLNode node) {
            
            if (node.prev != null && node.next != null) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            } else if (node.prev != null) {
                node.prev.next = null;
            } else if (node.next != null) {
                node.next.prev = null;
            }
            if (node == head && node == tail) {
                head = null;
                tail = null;

            } else if (node == tail) {
                tail = tail.next;
            } else if (node == head) {
                head = head.prev;
            }
            node.next = null;
            node.prev = null;
        }
    }