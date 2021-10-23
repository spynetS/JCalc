import java.util.Stack;

public class PostFix {

    String calculatePiece(double term1,double term2,char operator)
    {
        Debug.error("calculation "+term1+" "+operator+" "+term2);
        if(operator=='*')
        {
            return String.valueOf(term1*term2);
        }
        else if(operator=='+') {
            return String.valueOf(term1 + term2);
        }
        else if(operator=='-')
        {
            return String.valueOf(term1-term2);
        }
        else if(operator=='/')
        {
            return String.valueOf(term1/term2);
        }
        else if(operator=='^')
        {
            return String.valueOf(Math.pow(term1,term2));
        }
        else if(operator=='!')
        {
            return String.valueOf(Math.sqrt(term2));
        }
        return "";
    }

    String getAnswer(String eq)
    {
        String result = "";

        Stack<String> operands = new Stack<>();

        String[] chars = eq.split(" ");

        for(String c : chars)
        {
            if(Maths.isLetterOrNumber(c))
            {
                operands.push(c);
            }
            if(!operands.isEmpty()&&c.length()<=1&&Maths.isOperator(c))
            {
                double term2 = 0;
                double term1 = 0;

                try
                {
                    term2 = Double.parseDouble(operands.pop());
                }
                catch (Exception ignored){}

                try
                {
                    term1 = Double.parseDouble(operands.pop());
                }
                catch (Exception ignored){}

                operands.push(calculatePiece(term1,term2,c.toCharArray()[0]));
            }

        }
        Debug.error("postfix result "+ operands.peek());
        if(operands.size()<=1)
            return operands.peek();
        else
            return "ERROR";
    }

}
