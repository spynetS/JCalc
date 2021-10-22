/* Java implementation to convert
 infix expression to postfix*/
// Note that here we use Stack class for Stack operations

import java.util.Stack;

class InfixToPostfix
{

    // A utility function to return
    // precedence of a given operator
    // Higher returned value means
    // higher precedence
    static int Prec(char ch)
    {
        switch (ch)
        {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
            case '!':
                return 3;
        }
        return -1;
    }

    // The main method that converts
    // given infix expression
    // to postfix expression.



    public static String infixToPostfix(String exp)
    {
        // initializing empty String for result
        String result = new String("");

        // initializing empty stack
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i<exp.length(); ++i)
        {
            char c = exp.charAt(i);

            if((!Maths.isOperator(String.valueOf(c))&&i>0&&exp.charAt(i-1)=='-'))
            {
                System.out.println("Negative number "+exp.charAt(i));

            }

            if(c == '!')
                result += " 0";
            // If the scanned character is an
            // operand, add it to output.
            if (Character.isLetterOrDigit(c)||c=='.'){

                //If its a number we dont add a space
                if(i>0&&Prec(exp.charAt(i-1))==-1&&exp.charAt(i-1)!='(') {
                    result += c;
                }
                else
                    result += " "+c;

            }

            // If the scanned character is an '(',
            // push it to the stack.
            else if (c == '(')
                stack.push(c);

                //  If the scanned character is an ')',
                // pop and output from the stack
                // until an '(' is encountered.
            else if (c == ')')
            {
                while (!stack.isEmpty() &&
                        stack.peek() != '(')
                {
                        result += " "+stack.pop();
                }

                stack.pop();
            }
            else // an operator is encountered
            {
                while (!stack.isEmpty() && Prec(c)
                        <= Prec(stack.peek())){

                    result +=  " "+stack.pop();
                }
                stack.push(c);
            }

        }

        // pop all the operators from the stack
        while (!stack.isEmpty()){
            if(stack.peek() == '(')
                return "Invalid Expression";
            result += " "+stack.pop();
        }
        //System.out.println(result.substring(1));
        return result.substring(1);
    }

    // Driver method
    public static void main(String[] args)
    {
        String exp = "(0-3)+(0-4)";
        PostFix pp = new PostFix();
        System.out.println(exp);
        System.out.println(infixToPostfix(exp));
        System.out.println(pp.getAnswer(infixToPostfix(exp)));
    }
}