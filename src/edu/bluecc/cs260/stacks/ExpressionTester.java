package edu.bluecc.cs260.stacks;


public class ExpressionTester {

    public static void main(String[] args) {

        ArrayStack arrayStackExpression = new ArrayStack();
        expressionTest(arrayStackExpression);

//        LinkedStack linkedStackExpression = new LinkedStack();
//        expressionTest(linkedStackExpression);

    }

    public static void expressionTest(ArrayStack<String> stack) {
        //String s = "([Hello])";
       // String s =  "(10)";
       //  String s = "{([42])([27])[]}";
       // String s = "[[[{{{((()))}}}]]]";
        // String s = ")";
        String s = "[()]]";

            // trace: System.out.println(stack.isEmpty());
            String temp = "";
        int isAdded = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            temp = Character.toString(c);


            if (temp.equals("[") || temp.equals("(") || temp.equals("{")) {
                stack.push(temp);
                System.out.println(stack.peek());
                isAdded = isAdded + 1;
            }

            if (!stack.isEmpty()) {
                String top = stack.peek();
                // trace:  System.out.println(top); System.out.println("Top: " + top); System.out.println("Temp: " + temp);
                if (top.equals("[") && temp.equals("]")) {
                    stack.pop();
                    // trace:
                    System.out.println("[...........");
                } else if (top.equals("(") && temp.equals(")")) {
                    stack.pop();
                    // trace:
                    System.out.println("(...........");
                } else if (top.equals("{") && temp.equals("}")) {
                    stack.pop();
                    // trace:
                    System.out.println("{...........");
                } else if (temp.equals("]") || temp.equals(")") || temp.equals("}"))
                    System.out.println("Inside test " + temp);

            }

            System.out.println("Temp: " + temp);
        }

        System.out.println(stack.isEmpty());
        if (stack.isEmpty() && isAdded != 0) {
            System.out.println("temp s" + " is a vaild expresion");
        }
        else if (!stack.isEmpty() || isAdded == 0)
            System.out.println("ERROR: " + "temp s" + " is invalid");
    }
}
