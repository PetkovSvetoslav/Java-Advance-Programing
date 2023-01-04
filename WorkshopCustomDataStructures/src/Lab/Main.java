package Lab;

public class Main {
    public static void main(String[] args) {

        SmartStack stack = new SmartStack();
        stack.push(13);
        stack.push(14);
        stack.push(10);

        SmartStack secondStack = new SmartStack();
        stack.push(11);
        secondStack.push(123);
    }
}
