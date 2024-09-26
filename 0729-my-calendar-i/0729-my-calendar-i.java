class MyCalendar {
        
        List<int[]> bookings;
        public MyCalendar() {
            bookings = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            int[] currentBooking = new int[]{start, end};
            if (bookings.isEmpty()) {
                bookings.add(currentBooking);
            } else {
                if (end <= bookings.get(0)[0]) {
                    bookings.add(0, currentBooking);
                } else if (start >= bookings.get(bookings.size() - 1)[1]) {
                    bookings.add(currentBooking);
                } else {
                    boolean added = false;
                    for (int i = 1; i < bookings.size(); i++) {
                        if (bookings.get(i - 1)[1] <= start && bookings.get(i)[0] >= end) {
                            bookings.add(i, currentBooking);
                            added = true;
                            break;
                        }
                    }
                    return added;
                }
            }
            return true;
        }
    }

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */