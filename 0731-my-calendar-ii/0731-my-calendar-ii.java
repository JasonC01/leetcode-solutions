class MyCalendarTwo {
        List<int[]> noClash = new ArrayList<>();
        List<int[]> doubleBookings = new ArrayList<>();
        public MyCalendarTwo() {
        }

        public boolean book(int start, int end) {
            for (int[] booking : doubleBookings) {
                int bStart = booking[0];
                int bEnd = booking[1];
                if ((start <= bStart && end > bStart) ||
                        (start >= bStart && end <= bEnd) ||
                        (start < bEnd && end > bEnd) ||
                        (start <= bStart && end > bEnd)) {
                    return false;
                }
            }
            for (int[] clash : noClash) {
                int bStart = clash[0];
                int bEnd = clash[1];
                if ((start <= bStart && end > bStart) ||
                        (start >= bStart && end <= bEnd) ||
                        (start < bEnd && end > bEnd) ||
                        (start <= bStart && end > bEnd)) {
                    doubleBookings.add(new int[]{Math.max(bStart, start), Math.min(bEnd, end)});
                }
            }
            noClash.add(new int[]{start, end});
            // for (int[] i : noClash) {
            //     System.out.println(Arrays.toString(i));
            // }
            // System.out.println("//");
            // for (int[] i : doubleBookings) {
            //     System.out.println(Arrays.toString(i));
            // }
            // System.out.println("----");
            return true;
        }
    }

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */