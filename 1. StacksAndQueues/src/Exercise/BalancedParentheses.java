package Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        ArrayDeque<Character> brackets = new ArrayDeque<>();

        boolean isBalanced = true;
        for (int i = 0; i < input.length(); i++) {
            char bracket = input.charAt(i);

            if (bracket == '(' || bracket == '{' || bracket == '[') {
                brackets.push(bracket);
            } else if (!brackets.isEmpty()) {
                char prevBracket = brackets.pop();
                if (!((prevBracket == '(' && bracket == ')')
                        || prevBracket == '{' && bracket == '}'
                        || prevBracket == '[' && bracket == ']')) {
                    isBalanced = false;
                    break;
                }
            } else {
                isBalanced = false;
                break;
            }
        }
        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
