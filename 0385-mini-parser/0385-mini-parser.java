class Solution {
    public NestedInteger deserialize(String s) {
        if (s.charAt(0) != '[')
            return new NestedInteger(Integer.parseInt(s));

        NestedInteger[] stack = new NestedInteger[s.length()];
        int top = -1, num = 0, sign = 1;
        boolean hasNum = false;

        for (int i = 0, n = s.length(); i < n; i++) {
            char c = s.charAt(i);

            if (c == '[') {
                NestedInteger cur = new NestedInteger();

                if (top >= 0)
                    stack[top].add(cur);

                stack[++top] = cur;

            } else if (c == '-') {
                sign = -1;

            } else if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
                hasNum = true;

            } else {
                if (hasNum) {
                    stack[top].add(new NestedInteger(num * sign));
                    num = 0;
                    sign = 1;
                    hasNum = false;
                }

                if (c == ']')
                    top--;
            }
        }

        return stack[0];
    }
}