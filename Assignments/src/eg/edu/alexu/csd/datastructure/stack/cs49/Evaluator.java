package eg.edu.alexu.csd.datastructure.stack.cs49;

import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;
/**
 * Evaluator.
 * created on April 20, 2016
 * @author Amr Hedny
 *
 */

public class Evaluator implements IExpressionEvaluator {
    /** * Stack for conver. */
    MyStack conevertor = new MyStack();
    /** * Stack for evaluate value of expression. */
    MyStack evaluator = new MyStack();

    @Override
    public final String infixToPostfix(final String express) {
        String expression = express;
        if (expression == null) {
            throw new RuntimeException("empty");
        }
        expression = expression.replace(" ", "");
        if (expression == "") {
            throw new RuntimeException("empty");
        }
        int openBraces = 0;
        int closeBraces = 0;
        for (int j = 0; j < expression.length(); j++) {
            if (expression.charAt(j) == '(') {
                openBraces++;
            } else if (expression.charAt(j) == ')') {
                closeBraces++;
            }
        }
        if (openBraces != closeBraces) {
            throw new RuntimeException("Missing braces");
        }
        String postfix = "";
        String expressionWithSpaces = "";
        for (int i = 0; i < expression.length(); i++) {
            char operand2 = expression.toCharArray()[i];
            if ((operand2 == '+') || (operand2 == '-')
         || (operand2 == '*') || (operand2 == '/') || (operand2 == '(')

                    || (operand2 == ')')) {

                expressionWithSpaces += operand2 + " ";

            } else {

                expressionWithSpaces += operand2;

            }

            if (i + 1 < expression.length()) {

                char operand = expression.toCharArray()[i + 1];

                if ((operand == '+') || (operand == '-') || (operand == '*')
                        || (operand == '/') || (operand == '(')

                        || (operand == ')')) {

                    expressionWithSpaces += " ";

                }

            }

        }

        expressionWithSpaces = expressionWithSpaces.replace("  ", " ");

        String[] allOperands = expressionWithSpaces.split(" ");

        if (!checkValidExpression(allOperands)) {

            throw new RuntimeException("Invlaid Expression"
                    + " to be converted to postfix");

        }

        for (int i = 0; i < allOperands.length; i++) {

            char symbol = allOperands[i].toCharArray()[0];

            if (symbol == '+' || symbol == '-' || symbol == '*'
                    || symbol == '/' || symbol == '(') {

                if (conevertor.size() != 0) {

                    char prevSymbol = (Character) conevertor.peek();

                    if (checkPrecedence(symbol, prevSymbol)) {

                        postfix += " " + prevSymbol;

                        conevertor.pop();

                        while (conevertor.size() != 0) {

                            prevSymbol = (Character) conevertor.peek();

                            if (checkPrecedence(symbol, prevSymbol)) {

                                postfix += " " + prevSymbol;

                                conevertor.pop();

                            } else {

                                break;

                            }

                        }

                        conevertor.push(symbol);

                    } else {

                        conevertor.push(symbol);

                    }

                } else {

                    conevertor.push(symbol);

                }

            } else if (symbol == ')') {

                while ((Character) conevertor.peek() != '(') {

                    postfix += " " + (Character) conevertor.pop();

                }

                // remove '('

                conevertor.pop();

            } else if (Character.isJavaIdentifierPart(symbol)) {

                postfix += " " + allOperands[i];

            }

        }

        int fixedSize = conevertor.size();

        for (int i = 0; i < fixedSize; i++) {

            postfix += " " + (Character) conevertor.pop();

        }

        postfix = postfix.replaceFirst(" ", "");

        return postfix;

     }

    @Override
    public final int evaluate(final String expression) {

        if (expression == null) {

            throw new RuntimeException("null expression");

        }

        String expressionWithutSpaces = expression.replace(" ", "");

        if (expressionWithutSpaces == "") {

            throw new RuntimeException("empty expression");

        }

        String expressionWithSpaces = "";

        for (int i = 0; i < expression.length(); i++) {

            char operand2 = expression.toCharArray()[i];

            if ((operand2 == '+') || (operand2 == '-') || (operand2 == '*')
                    || (operand2 == '/')) {

                expressionWithSpaces += operand2 + " ";

            } else {

                expressionWithSpaces += operand2;

            }

            if (i + 1 < expression.length()) {

                char operand = expression.toCharArray()[i + 1];

                if ((operand == '+') || (operand == '-') || (operand == '*')
                        || (operand == '/')) {

                    expressionWithSpaces += " ";

                }

            }

        }

        expressionWithSpaces = expressionWithSpaces.replace("  ", " ");

        expressionWithSpaces = expressionWithSpaces.replace("  ", " ");

        String[] allOperands = expressionWithSpaces.split(" ");

        for (int i = 0; i < allOperands.length; i++) {

            char operand2 = allOperands[i].toCharArray()[0];

            if (operand2 != '+' && operand2 != '-' && operand2 != '*'
                    && operand2 != '/') {

                // push the operand

                float operand = Float.parseFloat(allOperands[i]);

                evaluator.push(operand);

            } else {

                // pop first and second operands and get the result and push it

                float secondOperand = (Float) evaluator.pop();

                float firstOperand = (Float) evaluator.pop();

                float sum = 0;

                // sum = firstOperand operation secondOperand

                switch (operand2) {

                case '+':

                    sum = firstOperand + secondOperand;

                    break;

                case '-':

                    sum = firstOperand - secondOperand;

                    break;

                case '*':

                    sum = firstOperand * secondOperand;

                    break;

                case '/':

                    sum = firstOperand / secondOperand;
                    if (secondOperand == 0) {
                        throw new RuntimeException("Divisble by zero");
                    }
                    break;

                default:

                    throw new RuntimeException("Invalid Operation");

                }

                evaluator.push(sum);

            }

        }

        if (evaluator.size() == 1) {
            float finalResult = (Float) evaluator.pop();
            int resultt = (int) finalResult;
            return resultt;
        } else {
            throw new RuntimeException("Error in evaluate");
        }
    }

    /**
     * @param currentOperator next operator
     * @param prevOperator prev operator
     * @return "void"
     */
    private boolean checkPrecedence(
            final char currentOperator, final char prevOperator) {

        // if current operator is more precedence then use this else use prev

        if (currentOperator == '*' || currentOperator == '/') {

            return prevOperator == '*' || prevOperator == '/';
        } else if (currentOperator == '+' || currentOperator == '-') {

            return prevOperator != '(' && prevOperator != ')';

        } else {

            return false;
        }
    }

    /**
     * @param allOperands expression that we want to check
     * @return "boolean"
     */
    private boolean checkValidExpression(final String[] allOperands) {
        int noOfOperands = 0;
        int noOfOperators = 0;
        for (int i = 0; i < allOperands.length; i++) {

            char currentOperator = allOperands[i].toCharArray()[0];

            if ((i == 0) && !Character.isDigit(currentOperator)
                    && !Character.isLetter(currentOperator)
                    && currentOperator != '(') {

                return false;
            } else if (Character.isDigit(currentOperator)
                    || Character.isLetter(currentOperator)) {
                noOfOperands++;
            }

            if (currentOperator == '+' || currentOperator == '-'
                    || currentOperator == '*' || currentOperator == '/'
                    || currentOperator == '(' || currentOperator == ')') {

                noOfOperators++;
                if (i + 1 != allOperands.length) {
                    char nextOperator = allOperands[i + 1].toCharArray()[0];
                    if (Character.isDigit(nextOperator)
                            || Character.isLetter(nextOperator)) {
                        continue;
                    } else if (currentOperator == '+'
                            || currentOperator == '-' || currentOperator == '*'
                            || currentOperator == '/') {

                        if (nextOperator == '(') {
                            continue;
                        } else {
                            return false;
                        }
                    } else if (currentOperator == ')') {
                        if ((nextOperator == '+' || nextOperator == '-'
                                || nextOperator == '*' || nextOperator == '/'
                                || nextOperator == ')')) {
                            continue;
                        } else {
                            return false;
                        }

                    } else if (currentOperator == '(') {

                        if (nextOperator == '(') {

                            continue;

                        } else {
                            return false;
                        }

                    } else {

                        return false;

                    }

                }

            } else if (Character.isDigit(currentOperator)
                    || Character.isLetter(currentOperator)) {
                noOfOperands++;
                if (i + 1 != allOperands.length) {
                    char nextOperator = allOperands[i + 1].toCharArray()[0];
                    if (nextOperator == '+' || nextOperator == '-'
                            || nextOperator == '*' || nextOperator == '/'
                            || nextOperator == ')') {
                        continue;
                    } else {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }
        char lastOperator =
                allOperands[allOperands.length - 1].toCharArray()[0];
        if (!Character.isDigit(lastOperator)
                && !Character.isLetter(lastOperator) && lastOperator != ')') {
            return false;
        }

        return true;

    }

    // another way
    /*
    StringBuilder resultt = new StringBuilder();
    expression = expression.replace(" ", "");
    if(!Character.isDigit(expression.toCharArray()[0])
    && !Character.isLetter(expression.toCharArray()[0])
    && expression.toCharArray()[0] != '('){
        throw new RuntimeException("start with operator");
    }
    if(!Character.isDigit(expression.toCharArray()[expression.length()-1])
    && !Character.isLetter(expression.toCharArray()[expression.length()-1])
    && expression.toCharArray()[expression.length()-1] != ')'){
        throw new RuntimeException("end with operator");
    }
    for (int i = 0; i < expression.length(); i++) {
        char operand1 = expression.toCharArray()[i];
        char operand2 = ' ';
        if (i + 1 != expression.length()) {
            operand2 = expression.toCharArray()[i + 1];
        }
        if (Character.isDigit(operand1)) {
            resultt.append(operand1);
            if(Character.isLetter(operand2)){
                throw new RuntimeException("two symbolic and numeric");
            }
        }else if(Character.isLetter(operand1)){
            resultt.append(operand1);
            if(Character.isDigit(operand2) || Character.isLetter(operand2)){
                throw new RuntimeException("two symbolic next");
            }
            else if (operand2 == '+' || operand2 == '-' || operand2 == '*'
            ||operand2 == '/' || operand2 == ')'){
                resultt.append(" ");
            }
        }
        else if(operand1 == '+' || operand1 == '-' || operand1 == '*'
        || operand1 == '/' || operand1 == '('){
            if(operand2 == '+' || operand2 == '-' || operand2 == '*'
            || operand2 == '/' || operand2 == ')'){
                throw new RuntimeException("two operators");
            }
            if (conevertor.size() != 0) {

                char prevSymbol = (Character) conevertor.peek();

                if (checkPrecedence(operand1, prevSymbol)) {
                    resultt.append(prevSymbol + " ");
                    conevertor.pop();
                    while (conevertor.size() != 0) {
                        prevSymbol = (Character) conevertor.peek();
                        if (checkPrecedence(operand1, prevSymbol)) {
                            resultt.append(prevSymbol + " ");
                            conevertor.pop();
                        } else {
                            break;
                        }
                    }
                    conevertor.push(operand1);
                } else {
                    conevertor.push(operand1);
                }
            } else {
                conevertor.push(operand1);
            }

        } else if (operand1 == ')') {

            while ((Character) conevertor.peek() != '(') {
                char a = (Character)conevertor.peek();
                resultt.append(a + " ");
            }

            // remove '('
            conevertor.pop();
        }

    }
    return resultt.toString(); */
}
