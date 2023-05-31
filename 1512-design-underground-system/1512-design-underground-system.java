class UndergroundSystem {
        HashMap<String, HashMap<String, int[]>> map = new HashMap<>();
        HashMap<Integer, Customer> customers = new HashMap<>();
        public UndergroundSystem() {

        }

        public void checkIn(int id, String stationName, int t) {
            customers.put(id, new Customer(stationName, t));
        }

        public void checkOut(int id, String stationName, int t) {
            customers.get(id).getDown(stationName, t, map);
            customers.remove(id);
        }

        public double getAverageTime(String startStation, String endStation) {
            int[] ans = map.get(startStation).get(endStation);
            return (double) ans[0] / ans[1];
        }
    }

    class Customer {
        String startStation;
        int boardingTime;

        public Customer(String startStation, int boardingTime) {
            this.startStation = startStation;
            this.boardingTime = boardingTime;
        }

        public void getDown(String endStation, int getDowntime, HashMap<String, HashMap<String, int[]>> map) {
            int timeTaken = getDowntime - this.boardingTime;
            if (!map.containsKey(startStation)) {
                map.put(startStation, new HashMap<>());
                map.get(startStation).put(endStation, new int[]{timeTaken, 1});
            } else {
                map.get(startStation).merge(endStation, new int[]{timeTaken, 1}, (a, b) -> new int[]{a[0] + timeTaken, a[1] + 1});
            }
        }
    }


/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */