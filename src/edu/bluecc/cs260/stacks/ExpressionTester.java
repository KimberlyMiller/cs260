package edu.bluecc.cs260.stacks;


public class ExpressionTester {

    public static void main(String[] args) {

      //  while (! "Cancel".equalsIgnoreCase(input)) {
            LinkedStack linkedStackExpression = new LinkedStack();
            expressionTest(linkedStackExpression);
     //   }
        System.out.println("temp s" + " is a vaild expresion");
        System.out.println("ERROR: " + "temp s" + " is invalid");
    }

    public static void expressionTest(Stack<String> stack) {
        String s = "(10)";
        String temp = "";
        for (int i = 0; i < 4; i++) {
            char c = s.charAt(i);
            temp = Character.toString(c);
            if (temp.equals("[") || temp.equals("(") || temp.equals("{")  ) {
                stack.push(temp);
                System.out.println(temp + "<-- temp");
                if (temp.equals("]") || temp.equals(")") || temp.equals(")")  )

            }
        }

        stack.push("B");
        System.out.println(stack.pop());  // D
        System.out.println(stack.peek());  // B
        System.out.println(stack.isEmpty());  // false
    }

}
