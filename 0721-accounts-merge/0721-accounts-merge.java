class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, String> nameMap = new HashMap<>();
        int index = 0;
        for (List<String> acc : accounts) {
            String name = acc.get(0);
            List<Integer> values = new ArrayList<>();
            for (int i = 1; i < acc.size(); i++) {
                if (map.containsKey(acc.get(i))) {
                    values.add(map.get(acc.get(i)));
                }
            }
            if (values.size() < 2) {
                int val = values.isEmpty() ? -1 : values.get(0);
                for (int i = 1; i < acc.size(); i++) {
                    nameMap.put(acc.get(i), name);
                    map.put(acc.get(i), val == -1 ? index : val);
                }
                if (val == -1) index++;
            } else {
                for (int i : values) {
                    for (String s : map.keySet()) {
                        if (map.get(s) == i) {
                            map.put(s, index);
                        }
                    }
                }
                for (int i = 1; i < acc.size(); i++) {
                    nameMap.put(acc.get(i), name);
                    map.put(acc.get(i), index);
                }
                index++;
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (int i : new HashSet<>(map.values())) {
            List<String> res = new ArrayList<>();
            for (String key : map.keySet()) {
                if (map.get(key) == i) {
                    res.add(key);
                }
            }
            res.sort(Comparator.comparing(x -> x));
            res.add(0, nameMap.get(res.get(0)));
            ans.add(res);
        }
        return ans;
    }

}