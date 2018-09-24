public class InsertInterval {

    /** My first solution. Took a long time to make ): */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || intervals.size() == 0) {
            intervals = new ArrayList<>();
            intervals.add(newInterval);
            return intervals;
        }
        int i;
        boolean inserted = false;
        for (i = 0; i < intervals.size(); i += 1) {
            Interval c = combine(intervals.get(i), newInterval);
            if (c != null) {
                intervals.remove(i);
                intervals.add(i, c);
                inserted = true;
                break;
            }
        }
        for (i = i == 0 ? i = 1 : i; i < intervals.size(); i += 1) {
            Interval c = combine(intervals.get(i - 1), intervals.get(i));
            if (c != null) {
                intervals.remove(i);
                intervals.remove(i - 1);
                intervals.add(i - 1, c);
                i -= 1;
            }
        }
        if (!inserted) {
            for (i = 0; i < intervals.size(); i += 1) {
                if (newInterval.start < intervals.get(i).start) {
                    break;
                }
            }
            intervals.add(i, newInterval);
        }
        return intervals;
    }
    
    private Interval combine(Interval a, Interval b) {
        if (a.end >= b.start && a.start <= b.start 
                || b.end >= a.start && b.start <= a.start) {
            return new Interval(Math.min(a.start, b.start), Math.max(a.end, b.end));
        }
        return null;
    }

    /** More logical */
    public List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
        LinkedList<Interval> ans = new LinkedList<>();
        int i;
        boolean inserted = false;
        for (i = 0; i < intervals.size(); i += 1 ) {
            if (isOverlap(intervals.get(i), newInterval)) {
                ans.add(combine2(intervals.get(i), newInterval));
                inserted = true;
                break;
            } else if (newInterval.end < intervals.get(i).start) {
                break;
            } else {
                ans.add(intervals.get(i));
            }
        }
        if (!inserted) {
            ans.add(i, newInterval);
            i -= 1;
        }
        i += 1;
        for (; i < intervals.size(); i += 1) {
            if (isOverlap(ans.getLast(), intervals.get(i))) {
                ans.addLast(combine2(ans.removeLast(), intervals.get(i)));
            } else {
                break;
            }
        }
        for (; i < intervals.size(); i += 1) {
            ans.add(intervals.get(i));
        }
        return ans;
    }
    
    private boolean isOverlap(Interval a, Interval b) {
        return a.start <= b.end && b.start <= a.end;
    }
    
    private Interval combine2(Interval a, Interval b) {
        return new Interval(Math.min(a.start, b.start), Math.max(a.end, b.end));
    }
}
