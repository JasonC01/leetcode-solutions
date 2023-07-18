class Node {
        Node prev = null;
        Node next = null;
        int val;

      public Node(int val) {
          this.val = val;
      }

      public Node(Node prev, Node next, int val) {
          this.prev = prev;
          this.next = next;
          this.val = val;
      }
  }

  class dlNodes {
        Node first = null;
        Node last = null;

        public Node removeFirst() {
            Node f = first;
            if (first.prev == null) {
                first = null;
                last = null;
            } else {
                first = first.prev;
                first.next = null;
            }
            return f;
        }

        public void add(Node n) {
            if (first == null && last == null) {
                first = n;
            } else {
                last.prev = n;
                n.next = last;
            }
            last = n;
        }

        public void deleteAndAddLast(Node n) {
            if (n.next != null && n.prev != null) {
                n.prev.next = n.next;
                n.next.prev = n.prev;
                n.next = last;
                last.prev = n;
                last = n;
                last.prev = null;
            } else {
                if (n.prev != null) {
                    first = n.prev;
                    first.next = null;
                    n.next = last;
                    last.prev = n;
                    last = n;
                    last.prev = null;
                }
            }
        }
        
        @Override
      public String toString() {
            StringBuilder sb = new StringBuilder();
            Node curr = first;
            while (curr != null) {
                sb.append(curr.val);
                curr = curr.prev;
            }
            return sb.toString();
        }
  }




    class LRUCache {

        int capacity;
        int storeSize = 0;
        dlNodes store;
        HashMap<Integer, Integer> cache;
        HashMap<Integer, Node> map;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            storeSize = 0;
            store = new dlNodes();
            cache = new HashMap<>();
            map = new HashMap<>();
        }

        public int get(int key) {
            System.out.println("get");
            // System.out.println(store);
            int val = cache.getOrDefault(key, -1);
            if (val != -1) {
                store.deleteAndAddLast(map.get(key));
            }
            return val;
        }

        public void put(int key, int value) {
            System.out.println("put");
            // System.out.println(store);
            if (cache.containsKey(key)) {
                cache.put(key, value);
                store.deleteAndAddLast(map.get(key));
            } else {
                if (storeSize == capacity) {
                    Node n = store.removeFirst();
                    cache.remove(n.val);
                    map.remove(n.val);
                    storeSize--;
                }
                Node newNode = new Node(key);
                map.put(key, newNode);
                store.add(newNode);
                cache.put(key, value);
                storeSize++;
            }
        }
    }