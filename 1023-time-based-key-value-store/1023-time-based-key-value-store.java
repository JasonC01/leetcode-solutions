class TimeMap {

        HashMap<String, List<Integer>> map = new HashMap<>();
        HashMap<String, HashMap<Integer, String>> actualMap = new HashMap<>();
        public TimeMap() {

        }

        public void set(String key, String value, int timestamp) {
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(timestamp);
            if (!actualMap.containsKey(key)) {
                actualMap.put(key, new HashMap<>());
            }
            actualMap.get(key).put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            if (!map.containsKey(key)) {
                return "";
            }
            int latest = binarySearch(map.get(key), timestamp);
            return latest == -1 ? "" : actualMap.get(key).get(map.get(key).get(latest));
        }
        
        public int binarySearch(List<Integer> arr, int target) {
            int low = 0;
            int high = arr.size() - 1;
            
            while (low < high) {
                int mid = (int) Math.ceil((low + high) / 2.0);
                if (arr.get(mid) <= target) {
                    low = mid;
                } else {
                    high = mid - 1;
                }
            }
            return arr.get(low) <= target ? low : -1;
        }
    }
    

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */