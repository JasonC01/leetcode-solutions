class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Character> q = new ArrayDeque<>();
        int rCount = 0;
        int dCount = 0;
        int rSkip = 0;
        int dSkip = 0;
        for (char c : senate.toCharArray()) {
            if (c == 'R') {
                if (rSkip > 0) {
                    rSkip--;
                } else {
                    q.add(c);
                    rCount++;
                    dSkip++;
                }
            } else {
                if (dSkip > 0) {
                    dSkip--;
                } else {
                    q.add(c);
                    dCount++;
                    rSkip++;
                }
            }
        }
        while (rCount > 0 && dCount > 0 && !q.isEmpty()) {
            char c = q.poll();
            if (c == 'R') {
                rCount--;
                if (rSkip > 0) {
                    rSkip--;
                } else {
                    q.add(c);
                    rCount++;
                    dSkip++;
                }
            } else {
                dCount--;
                if (dSkip > 0) {
                    dSkip--;
                } else {
                    q.add(c);
                    dCount++;
                    rSkip++;
                }
            }
        }
        return rCount == 0 ? "Dire" : "Radiant";
    }
}