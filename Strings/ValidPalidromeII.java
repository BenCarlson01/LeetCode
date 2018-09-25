public class ValidPalidromeII {

    /** I did this myself */
    public boolean validPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        int[] delete = new int[3];
        while (start < end) {
            char a = s.charAt(start);
            char b = s.charAt(end);
            
            if (a != b) {
                if (delete[0] == 2) {
                    return false;
                }
                if (delete[0] == 1) {
                    delete[0] = 2;
                    start = delete[1];
                    end = delete[2];
                    end += 1;
                } else {
                    delete[0] = 1;
                    delete[1] = start;
                    delete[2] = end;
                    start -= 1;
                }
            }
            start += 1;
            end -= 1;
        }
        return true;
    }
}
