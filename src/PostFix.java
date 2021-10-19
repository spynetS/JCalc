import java.util.Stack;

public class PostFix {

    String calculatePiece(float term1,float tem2,char operator)
    {
        if(operator=='*')
        {
            return String.valueOf(term1*tem2);
        }
        else if(operator=='+') {
            return String.valueOf(term1 + tem2);
        }
        else if(operator=='-')
        {
            return String.valueOf(term1-tem2);
        }
        else if(operator=='/')
        {
            return String.valueOf(term1/tem2);
        }
        else if(operator=='^')
        {
            return String.valueOf(Math.pow(term1,tem2));
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
           // System.out.println(c);
            if(Maths.isLetterOrNumber(c))
            {
                operands.push(c);
            }
            if(!operands.isEmpty()&&Maths.isOperator(c))
            {

                float term2 = 0;
                float term1 = 0;
                try {
                    term2 = Float.parseFloat(operands.pop());
                }catch (Exception e){}
                try {
                    term1 = Float.parseFloat(operands.pop());
                }catch (Exception e){}
                operands.push(calculatePiece(term1,term2,c.toCharArray()[0]));
            }

        }
        if(operands.size()<2)
            return ""+operands;
        else
            return "ERROR";
    }

}
