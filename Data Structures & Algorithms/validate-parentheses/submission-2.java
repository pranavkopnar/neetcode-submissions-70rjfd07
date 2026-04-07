class Solution {
    public boolean isValid(String s) {
        
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.add(c);
            } else {
                if (stack.isEmpty()) return false;
                char curr = stack.pollLast();
                if (curr != '{' && c == '}') return false;
                else if (curr != '(' && c == ')') return false;
                else if (curr != '[' && c == ']') return false;
            }
        }

        return stack.isEmpty();
    }    
}
