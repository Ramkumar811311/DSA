class MyCalendar {
    TreeSet<int[]> set;

    public MyCalendar() {
        set = new TreeSet<>((a, b) -> Integer.compare(a[0], b[0]));
    }

    public boolean book(int startTime, int endTime) {
        int[] next = set.ceiling(new int[] { startTime, endTime });
        int[] prev = set.lower(new int[] { startTime, endTime });

        if (next != null && endTime > next[0]) {
            return false;
        }
        if (prev != null && prev[1] > startTime) {
            return false;
        }
        set.add(new int[] { startTime, endTime });
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */