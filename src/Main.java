import jdk.nashorn.internal.runtime.ECMAException;

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
        System.out.println("Type help for help");

        while(true){
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));
            // Reading data using re
            // adLine
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
           else if(exp.equals("help"))
           {
               System.out.println("If you want to set variables write 'x=5*5' with anny letter (not words) ");
               System.out.println("Addition is with +");
               System.out.println("Subtraction is with -");
               System.out.println("Multiplication is with *");
               System.out.println("Power of is with ^");
               System.out.println("Scare root is with !");

           }
           else
           {
               try{
                    Map<String,Float> m = vars;
                    System.out.println(pp.getAnswer(InfixToPostfix.infixToPostfix(Maths.switchVariable(exp,m))));
                }
               catch(Exception e)
               {
                   System.out.println("Syntax error");
               }
           }
                //System.out.println((Maths.switchVariable(exp,"x",x)));
        }
    }
}
