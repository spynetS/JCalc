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
        else if(operator=='!')
        {
            return String.valueOf(term1/tem2);
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
                float term2= Float.parseFloat(operands.pop());
                float term1= Float.parseFloat(operands.pop());
                System.out.println(term1+"-"+term2);
                System.out.println(calculatePiece(term1,term2,c.toCharArray()[0]));
                operands.push(calculatePiece(term1,term2,c.toCharArray()[0]));
            }
            //System.out.println(operands);

        }

        return "result= "+operands;
    }

}
