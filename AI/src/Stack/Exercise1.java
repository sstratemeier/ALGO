package Stack;

import java.io.IOException;

import static Stack.DijkstraCalculator.eval;

public class Exercise1 {
    public static void main(String[] args) throws IOException {
        System.out.println("\nExercise 1.1");
        FixedSizeStack fixedSizeStack = new FixedSizeStack(10);
        fixedSizeStack.push("hello");
        fixedSizeStack.push("world");
        System.out.println(fixedSizeStack.pop());

        System.out.println("\nExercise 1.2");
        VariableSizeStack variableSizeStack = new VariableSizeStack();
        variableSizeStack.push("hello");
        variableSizeStack.push("world");
        System.out.println(variableSizeStack.pop());

        System.out.println("\nExercise 1.3");
        GenericStack<Integer> genericStack = new GenericStack<>();
        genericStack.push(3);
        genericStack.push(7);
        System.out.println(genericStack.pop());

        System.out.println("\nExercise 1.4");
        System.out.println(eval("( 2 + 3 )")); // Expected 5
        System.out.println(eval("( 3 - ( 2 * 3 ) )")); // Expected -3
        System.out.println(eval("( ( 5 * 4 ) - ( 2 * ( 3 / 4 ) ) )")); // Expected 18.5
    }
}
