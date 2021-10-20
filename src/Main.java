import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    //Main will take care of in and output
    String lastAnswer;
    static HashMap<String,Float> vars = new HashMap<String, Float>();
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
           if(exp.contains("="))
           {
               String var = exp.split("=")[0];
               if(!vars.containsKey(var))
                    vars.put(var,Float.parseFloat(pp.getAnswer(InfixToPostfix.infixToPostfix((exp.split("=")[1])))));
           }
           else
           {
               Map<String,Float> m = vars;
               System.out.println(pp.getAnswer(InfixToPostfix.infixToPostfix(Maths.switchVariable(exp,m))));
           }
                //System.out.println((Maths.switchVariable(exp,"x",x)));
        }
    }
}
