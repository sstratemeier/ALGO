package Stack;

import java.util.StringTokenizer;

public class DijkstraCalculator {
    public static double eval(String expression) {
        StringTokenizer tokenizer = new StringTokenizer(expression);
        GenericStack<Double> numberStack = new GenericStack<>();
        GenericStack<Operator> operatorStack = new GenericStack<>();
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            // https://stackoverflow.com/a/15801999
            if(token.matches("-?\\d+")) {
                numberStack.push(Double.parseDouble(token));
            }
            if(token.equals("+")) {
                operatorStack.push(Operator.PLUS);
            }
            if(token.equals("-")) {
                operatorStack.push(Operator.MINUS);
            }
            if(token.equals("/")) {
                operatorStack.push(Operator.DIVIDE);
            }
            if(token.equals("*")) {
                operatorStack.push(Operator.MULTIPLY);
            }
            if(token.equals(")")) {
                Double operand1 = numberStack.pop();
                Double operand2 = numberStack.pop();
                Operator operator = operatorStack.pop();
                numberStack.push(operator.calculate(operand2, operand1));
            }
        }
        return numberStack.pop();
    }
}

enum Operator {
    PLUS, MINUS, MULTIPLY, DIVIDE;

    public Double calculate(Double int1, Double int2) {
        Double result = 0d;
        switch (this) {
            case PLUS:
                result = int1 + int2;
                break;
            case MINUS:
                result = int1 - int2;
                break;
            case MULTIPLY:
                result = int1 * int2;
                break;
            case DIVIDE:
                result = int1 / int2;
            break;
        }
        return result;
    }
}
