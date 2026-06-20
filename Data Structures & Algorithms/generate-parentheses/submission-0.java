class Solution {
    public List<String> generateParenthesis(int n) {
        StringBuilder parenthesis = new StringBuilder();
        List<String> res = new ArrayList<>();
        generateParenthesis(n, 0, parenthesis, res);
        return res;
    }

    public void generateParenthesis(int n, int k, StringBuilder parenthesis, List<String> res) {

        if (n == 0 && k == 0) {
            res.add(parenthesis.toString());
            return;
        }

        if (n > 0) {
            parenthesis.append("(");
            generateParenthesis(n - 1, k + 1, parenthesis, res);
            parenthesis.deleteCharAt(parenthesis.length() - 1);
        } 

        if (k > 0) {
            parenthesis.append(")");
            generateParenthesis(n, k - 1, parenthesis, res);
            parenthesis.deleteCharAt(parenthesis.length() - 1);
        }

    }
}
