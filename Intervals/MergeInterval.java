public class MergeInterval {

    /** My first solution. I think it works pretty well. Need to practice making Test Cases. */
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        List<Interval> ans = new ArrayList<>();
        int i;
        for (i = 0; i < intervals.size() - 1; i += 1) {
            if (overlapping(intervals.get(i), intervals.get(i + 1))) {
                Interval combined = combine(intervals.get(i), intervals.get(i + 1));
                i += 2;
                while (i < intervals.size() && overlapping(combined, intervals.get(i))) {
                    combined = combine(combined, intervals.get(i));
                    i += 1;
                }
                ans.add(combined);
                i -= 1;
            } else {
                ans.add(intervals.get(i));
            }
        }
        if (i == intervals.size() - 1) {
            ans.add(intervals.get(i));
        }
        return ans;
    }
    
    private boolean overlapping(Interval a, Interval b) {
        return a.start <= b.end && b.start <= a.end;
    }
    
    private Interval combine(Interval a, Interval b) {
        return new Interval(Math.min(a.start, b.start), Math.max(a.end, b.end));
    }
}
