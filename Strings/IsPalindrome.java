public class IsPalidrome {

    /** I did this myself and it is so fast */
    public boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            char a = s.charAt(start);
            if (!alphaNumeric(a)) {
                start += 1;
                continue;
            }
            char b = s.charAt(end);
            if (!alphaNumeric(b)) {
                end -= 1;
                continue;
            }
            
            if (!(a == b || (65 <= a && a <= 90 && a + 32 == b)
                    || (65 <= b && b <= 90 && b + 32 == a))) {
                return false;
            }
            start += 1;
            end -= 1;
        }
        return true;
    }
    
    private boolean alphaNumeric(char c) {
        return 97 <= c && c <= 122 || 65 <= c && c <= 90 || 48 <= c && c <= 57;
    }
}
