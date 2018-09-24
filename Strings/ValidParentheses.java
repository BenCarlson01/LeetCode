public class ValidParentheses {

    /** First solution; really slow */
    public boolean isValid1(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<String> q = new Stack<>();
        while (s.length() >= 1) {
            String a = s.substring(0,1);
            try {
                if (a.equals(")")) {
                    String b = q.pop();
                    if (!b.equals("(")){
                        return false;
                    }
                } else if (a.equals("}")) {
                    String b = q.pop();
                    if (!b.equals("{")){
                        return false;
                    }
                } else if (a.equals("]")) {
                    String b = q.pop();
                    if (!b.equals("[")){
                        return false;
                    }
                } else {
                    q.push(a);
                }
            } catch (java.util.EmptyStackException e) {
                return false;
            }
            s = s.substring(1);
        }
        return q.empty();
    }

    /** Much better when using chars */
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> q = new Stack<>();
        for (int i = 0; i < s.length(); i += 1) {
            char c = s.charAt(i);
            switch (c) {
                case ')': {
                    if (q.empty()) {
                        return false;
                    }
                    char a = q.pop();
                    if (a != '(') {
                        return false;
                    }
                    break;
                } case ']': {
                    if (q.empty()) {
                        return false;
                    }
                    char a = q.pop();
                    if (a != '[') {
                        return false;
                    }
                    break;
                } case '}': {
                    if (q.empty()) {
                        return false;
                    }
                    char a = q.pop();
                    if (a != '{') {
                        return false;
                    }
                    break;
                } default:
                    q.push(c);
            }
        }
        return q.empty();
    }
}
