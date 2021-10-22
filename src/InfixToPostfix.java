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


    public static String negativeNumbers(String eq)
    {
        String newEq = "";
        for(int i = 0;i<eq.length();i++)
        {
            char c = eq.charAt(i);

            if(c=='-')
            {
                try {
                    if(!Maths.isOperator(eq.charAt(i+1))) {
                        try {
                            if (Maths.isOperator(eq.charAt(i - 1))) {
                                newEq += "(0-"+eq.charAt(i+1)+")";
                                i++;
                            }
                            else
                                newEq += c;
                        } catch (Exception e) {
                            newEq += "(0-"+eq.charAt(i+1)+")";
                            i++;
                        }
                    }
                }catch (Exception e1){}
            }
            else
            {
                newEq += c;
            }
        }
        Debug.error(newEq);
        return newEq;
    }


    public static String infixToPostfix(String exp)
    {
        // initializing empty String for result
        String result = new String("");

        exp = negativeNumbers(exp);

        // initializing empty stack
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i<exp.length(); ++i)
        {
            char c = exp.charAt(i);

            if(c == '!')
                result += " 0";
            // If the scanned character is an
            // operand, add it to output.
            if (Character.isLetterOrDigit(c)||c=='.'){

                //If its a number we don't add a space
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
        Debug.error("result "+result.substring(1));
        return result.substring(1);
    }

    // Driver method
    public static void main(String[] args)
    {
        String exp = "-3*-4";
        PostFix pp = new PostFix();
        System.out.println(exp);
        System.out.println(infixToPostfix(exp));
        System.out.println(pp.getAnswer(infixToPostfix(exp)));
    }
}