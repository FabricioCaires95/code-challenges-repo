package stackProblems;

import java.util.List;
import java.util.Stack;

public class ValidParenthesis {

    public static void main(String[] args) {

        String s = "(()";
        System.out.println(isValid(s));

    }

    // (){}
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        List<Character> brackets = List.of('(', '[', '{');

        for (char c : s.toCharArray()) {
            if (brackets.contains(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.peek();
                if ((c == ')' && top == '(') || (c == ']' && top == '[') || (c == '}' && top == '{')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

}
