class Solution {
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Map<String,Integer> map = new HashMap<>();
        map.put("+",1);
        map.put("-",2);
        map.put("*",3);
        map.put("/",4);

        for (int i=0 ; i<tokens.length; i++) {
            String s = tokens[i];
            
            if (map.get(s) != null) {
                int op = map.get(s);
                int op2 = stack.pollLast();
                int op1 = stack.pollLast();
                int val;
                if (op == 1) val = (op1 + op2);
                else if (op == 2) val = (op1 - op2);
                else if (op == 3) val = (op1 * op2);
                else val = (op1 / op2);

                stack.add(val);
            } else {
                stack.add(Integer.parseInt(s));
            }

        }

        return stack.pollLast();
    }
}
