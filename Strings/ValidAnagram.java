public class ValidAnagram {

    /** First solution; a bit slow */
    public boolean isAnagram1(String s, String t) {
        if (s == null) {
            return s == t;
        }
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> seen = new HashMap<>();
        for (int i = 0; i < s.length(); i += 1) {
            char c = s.charAt(i);
            if (seen.keySet().contains(c)) {
                seen.put(c, seen.get(c) + 1);
            } else {
                seen.put(c, 1);
            }
        }
        for (int i = 0; i < t.length(); i += 1) {
            char c = t.charAt(i);
            if (seen.keySet().contains(c)) {
                if (seen.get(c) == 1) {
                    seen.remove(c);
                } else {
                    seen.put(c, seen.get(c) - 1);
                }
            } else {
                return false;
            }
        }
        return seen.size() == 0;
    }

    /** Faster because we know there are only 26 characters */
    public boolean isAnagram2(String s, String t) {
        if (s == null) {
            return s == t;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int[] seen = new int[26];
        for (int i = 0; i < s.length(); i += 1) {
            int c = s.charAt(i) - 97;
            seen[c] += 1;
        }
        for (int i = 0; i < t.length(); i += 1) {
            int c = t.charAt(i) - 97;
            seen[c] -= 1;
            if (seen[c] < 0) {
                return false;
            }
        }
        return true;
    }
}
