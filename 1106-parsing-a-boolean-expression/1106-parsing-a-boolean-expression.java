class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char c : expression.toCharArray()) {
            if (c == ')') {
                int t = 0, f = 0;

                while (stack.peek() != '(') {
                    char ch = stack.pop();
                    if (ch == 't') t++;
                    if (ch == 'f') f++;
                }

                stack.pop(); // Remove '('
                char op = stack.pop(); // Remove operator

                boolean result;
                if (op == '!') {
                    result = (t + f == 1 && t == 0);
                } else if (op == '&') {
                    result = (f == 0);
                } else {
                    result = (t > 0);
                }

                stack.push(result ? 't' : 'f');
            } else if (c != ',') {
                stack.push(c);
            }
        }

        return stack.peek() == 't';
    }
}