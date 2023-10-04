class MyHashMap {

        int[] values = new int[(int) 1e6 + 1];
        HashSet<Integer> keys = new HashSet<>();

        public MyHashMap() {
        }

        public void put(int key, int value) {
            keys.add(key);
            values[key] = value;
        }

        public int get(int key) {
            return keys.contains(key) ? values[key] : -1;
        }

        public void remove(int key) {
            keys.remove(key);
        }
    }

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */