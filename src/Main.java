import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    //Main will take care of in and output
    String lastAnswer;
    static float x = 0;
    public static void main(String[] args)
    {
        while(true){
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));

            // Reading data using readLine
            String exp = null;
            try {
                exp = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            PostFix pp = new PostFix();
            if(exp.equals("SET X"))
            {
                reader = new BufferedReader(
                        new InputStreamReader(System.in));

                // Reading data using readLine
                String exp2 = null;
                try {
                    exp2 = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                x = Float.parseFloat(exp2);
                System.out.println("x is set to "+x);
            }
            else
                //System.out.println(pp.getAnswer(InfixToPostfix.infixToPostfix(Maths.switchVariable(exp,"x",x))));
                System.out.println((Maths.switchVariable(exp,"x",x)));
        }
    }
}
