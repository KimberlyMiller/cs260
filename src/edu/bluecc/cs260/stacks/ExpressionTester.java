package edu.bluecc.cs260.stacks;

import java.util.Scanner;

public class ExpressionTester {

    public static void main(String[] args) {

        ArrayStack arrayStackExpression = new ArrayStack();

        Scanner scanner = new Scanner(System.in);
        String string = new String("");
        String[] lines = new String[100000];
        int i = 0;
        while (!string.equalsIgnoreCase("cancel")) {
            System.out.println("Type an expression to validate and end with 'cancel");
            string = scanner.nextLine();
            if (!string.equalsIgnoreCase("cancel"))
                lines[i++] = string;
        }
        scanner.close();

        expressionTest(arrayStackExpression, lines);
    }

    public static void expressionTest(ArrayStack<String> stack, String[] lines) {
        //     String s = "([Hello])"; // valid expression
//         String s = "(10)"; // valid expression
//         String s = "([Hello])"; // valid expression
//         String s = "{([42])([27])[]}"; // valid expression
//         String s = "[[[{{{((()))}}}]]]"; // valid expression

//        String s = ")"; // invalid expression
//         String s = "[()]]"; // invalid expression
//         String s = "{17(23)"; // invalid expression
//    String s = "((([[[]]]))))"; // invalid expression

        String temp = "";
        String s = "";
        int stackWasUsed = 0;
        int notMatched = 0;
        for (int j = 0; j < lines.length; j++) {
            s = lines[j];
            if (lines[j] != null){
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                temp = Character.toString(c);

                if (temp.equals("[") || temp.equals("(") || temp.equals("{")) {
                    stack.push(temp);
                    stackWasUsed = 1;
                }

                if (!stack.isEmpty()) {
                    String top = stack.peek();
                    if (top.equals("[") && temp.equals("]")) {
                        stack.pop();
                    } else if (top.equals("(") && temp.equals(")")) {
                        stack.pop();
                    } else if (top.equals("{") && temp.equals("}")) {
                        stack.pop();
                    }
                } else if (temp.equals("]") || temp.equals(")") || temp.equals("}")) {
                    notMatched = notMatched + 1;
                }

            }

            if (stack.isEmpty() && stackWasUsed == 1 && notMatched == 0)
                System.out.println(s + " is a vaild expresion");
            else if (!stack.isEmpty() || stackWasUsed == 0 || notMatched > 0)
                System.out.println("ERROR: " + s + " is invalid");
        }
        }
    }
}
