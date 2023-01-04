package Exercise;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //collect the whole expression as Postfix notation
        ArrayDeque<String> outputQueue = new ArrayDeque<>();
        //keeps the operators
        ArrayDeque<String> operatorsStack = new ArrayDeque<>();

        //Order by precedence of operations
        Map<String, Integer> priorities = new HashMap<>();
        priorities.put("*", 2);
        priorities.put("/", 2);
        priorities.put("+", 1);
        priorities.put("-", 1);
        priorities.put("(", -1);

        String[] tokens = scanner.nextLine().split("\\s+");
        for (String token : tokens) {
            switch (token) {
                case "+":
                case "-":
                case "*":
                case "/":
                    //checks whether the current operator has an precedence over the previous one
                    while (!operatorsStack.isEmpty() && priorities.get(operatorsStack.peek()) >= priorities.get(token)) {
                        outputQueue.offer(operatorsStack.pop());
                    }
                    operatorsStack.push(token);
                    break;
                case "(":
                    //opens an expression
                    operatorsStack.push("(");
                    break;
                case ")":
                    //puts all bracket operators in the queue
                    while (!operatorsStack.isEmpty() && !operatorsStack.peek().equals("(")) {
                        outputQueue.offer(operatorsStack.pop() + "");
                    }
                    //remove "(" from the stack
                    operatorsStack.pop();
                    break;
                default:
                    //variables and numbers
                    outputQueue.offer(token);
            }
        }
        //puts the rest operators in the queue
        while (!operatorsStack.isEmpty()) {
            outputQueue.offer(operatorsStack.pop());
        }
        for (String s : outputQueue) {
            System.out.print(s + " ");
        }
    }
}
