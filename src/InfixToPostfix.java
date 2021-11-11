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

    //Adds spaces to the expression '5+5' => '5 + 5'
    public static String addSpaces(String eq)
    {
        Debug.error("Before spaces "+ eq);
        String eqWithSpaces = "";
        for(int i = 0;i<eq.length();i++)
        {
            char c = eq.charAt(i);
            if (i<=0&&Maths.isOperator(c))
            {
                eqWithSpaces+= c+" ";
            }
            else if(Maths.isOperator(c)&&!Maths.isOperator(eq.charAt(i+1)))
            {
                eqWithSpaces+= " "+c+" ";
            }
            else if(Maths.isOperator(c))
            {
                eqWithSpaces+= " "+c;
            }
            else
                eqWithSpaces += c;
        }
        Debug.error("After spaces "+ eqWithSpaces);
        return eqWithSpaces;
    }

    //Changes the expression so we can use negative numbers in the main method
    // '-5*-5' => '(0-5)*(0-5)'
    private static String negativeNumbers(String eq)
    {
        eq = addSpaces(eq); //add spaces so we can iterate throught the expression and use string instead of chars
        Debug.error("Before negative numbers controlling "+eq);

        String newEq = "";
        String[] strings = eq.split(" ");

        for(int i = 0;i<strings.length;i++)
        {
            String c = strings[i];
            if(c.equals("-"))
            {
                try { //if index is
                    if(!Maths.hasOperator(strings[i+1]))//if the thing after the minus sign is a number
                    {
                        try {
                            //if there is a operator on the left of the minus then know
                            //it is a negative number and we continue
                            if (Maths.hasOperator(strings[i-1])) {
                                newEq += "(0-"+strings[i+1]+")";
                                i++;
                            }
                            else
                                newEq += c;
                        }
                        //if there is no string on the left of the minus
                        // we now it is a negative number and we continue
                        catch (Exception e)
                        {
                            newEq += "(0-" + strings[i + 1] + ")";
                            i++;
                        }
                    }

                }
                catch (Exception e1){Debug.error("Error "+e1.toString());}
            }
            else
            {
                newEq += c;
            }
        }
        Debug.error("After negative numbers controlling "+newEq);
        return newEq;
    }

    // The main method that converts
    // given infix expression
    // to postfix expression.
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

    // Debug method
    public static void main(String[] args)
    {
        String exp = "-50*-50";
        PostFix pp = new PostFix();
        System.out.println(exp);
        System.out.println(infixToPostfix(exp));
        System.out.println(pp.getAnswer(infixToPostfix(exp)));
    }
}