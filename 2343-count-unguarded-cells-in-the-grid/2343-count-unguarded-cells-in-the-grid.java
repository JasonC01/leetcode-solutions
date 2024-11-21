class Solution {
     public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        HashMap<Integer, List<int[]>> rows = new HashMap<>();
        HashMap<Integer, List<int[]>> cols = new HashMap<>();
        for (int[] guard : guards) {
            if (!rows.containsKey(guard[0])) {
                rows.put(guard[0], new ArrayList<>());
            }
            rows.get(guard[0]).add(new int[]{guard[1], 1});
            if (!cols.containsKey(guard[1])) {
                cols.put(guard[1], new ArrayList<>());
            }
            cols.get(guard[1]).add(new int[]{guard[0], 1});
        }
        for (int[] wall : walls) {
            if (!rows.containsKey(wall[0])) {
                rows.put(wall[0], new ArrayList<>());
            }
            rows.get(wall[0]).add(new int[]{wall[1], -1});
            if (!cols.containsKey(wall[1])) {
                cols.put(wall[1], new ArrayList<>());
            }
            cols.get(wall[1]).add(new int[]{wall[0], -1});
        }
        for (List<int[]> vals : rows.values()) {
            vals.sort(Comparator.comparing(x -> x[0]));
        }
        for (List<int[]> vals : cols.values()) {
            vals.sort(Comparator.comparing(x -> x[0]));
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int rIdx = bSearch(rows.getOrDefault(i, new ArrayList<>()), j);
                int cIdx = bSearch(cols.getOrDefault(j, new ArrayList<>()), i);
                Integer r = null;
                Integer c = null;
                if (rows.get(i) != null) {
                    r = rows.get(i).get(rIdx)[0];
                }
                if (cols.get(j) != null) {
                    c = cols.get(j).get(cIdx)[0];
                }
                if ((r != null && j == r) || (c != null && c == i)) {
                    continue;
                }
                boolean blocked = true;
                if (r != null) {
                    if (r > j) {
                        if (rIdx > 0) {
                            blocked = (rows.get(i).get(rIdx)[1] == -1 && rows.get(i).get(rIdx - 1)[1] == -1);
                        } else {
                            blocked = rows.get(i).get(rIdx)[1] == -1;
                        }
                    } else {
                        blocked = rows.get(i).get(rIdx)[1] == -1;
                    }
                }
                if (c != null) {
                    if (c > i) {
                        if (cIdx > 0) {
                            blocked &= (cols.get(j).get(cIdx)[1] == -1 && cols.get(j).get(cIdx - 1)[1] == -1);
                        } else {
                            blocked &= cols.get(j).get(cIdx)[1] == -1;
                        }
                    } else {
                        blocked &= cols.get(j).get(cIdx)[1] == -1;
                    }
                }
                // if (!blocked) {
                //     System.out.println(r);
                //     System.out.println(c);
                // }
                // if (blocked) System.out.println(Arrays.toString(new int[]{i, j}));
                if (blocked) ans++;
            }
        }
        return ans;
    }

    public int bSearch(List<int[]> arr, int target) {
        int low = 0;
        int high = arr.size() - 1;
        while (low < high) {
            int mid = Math.floorDiv(low + high, 2);
            if (arr.get(mid)[0] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}