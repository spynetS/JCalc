
public class Maths {

    public static char[] operators = {'+','-','/','*','^','!',};

    public static boolean isLetterOrNumber(String number)
    {
        char[] chars = number.toCharArray();
        for(char ch:chars)
        {
            for(char c:operators)
            {
                try
                {   //just to se if we can convert the number into a float
                    //if we cant we know it is not a number
                    float tester = Float.parseFloat(String.valueOf(ch));
                    System.out.println("float");
                    return true;
                }
                catch (Exception e){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isOperator(String number)
    {
        char[] chars = number.toCharArray();
        char g;
        for(char ch:chars)
        {
            for(char c:operators)
            {
                if(ch==c)
                    return true;
            }
        }
        return false;
    }
}
