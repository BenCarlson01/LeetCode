public class MostCommonWord {

    /** First solution, I think it is good enough, not a great problem imo */
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> banned_set = new HashSet<>();
        for (String ban : banned) {
            banned_set.add(ban);
        }
        HashMap<String, Integer> map = new HashMap<>();
        String[] words = paragraph.split("[^a-zA-Z]*\\s");
        words[words.length - 1] = words[words.length - 1].split("[^a-zA-Z]*$")[0];
        int max = 0;
        String word = "";
        for (String w : words) {
            String lower = w.toLowerCase();
            if (map.keySet().contains(lower)) {
                int get = map.get(lower) + 1;
                map.put(lower, get);
                if (max < get) {
                    word = lower;
                    max = get;
                }
            } else if (!banned_set.contains(lower)){
                map.put(lower, 1);
                if (max < 1) {
                    word = lower;
                    max = 1;
                }
            }
        }
        return word;
    }
}
