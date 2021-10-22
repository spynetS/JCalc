import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    //Main will take care of in and output
    String lastAnswer;
    static HashMap<String,Float> vars = new HashMap<String, Float>();

    private static void AddConstatns()
    {
        vars.put("pi",3.141592653589793238f);
        vars.put("e",2.7182818284590452353f);
    }

    public static void main(String[] args)
    {
        Debug.log("Type help for help");
        AddConstatns();
        while(true){
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));

            String exp = "";

            try {
                exp = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            PostFix pp = new PostFix();
            if(exp.contains("=")&&!exp.split("=")[0].equals("e")&&!exp.split("=")[0].equals("pi"))
            {
               String var = exp.split("=")[0];
               Debug.error(exp.split("=")[1]);
               vars.put(var,Float.parseFloat(pp.getAnswer(InfixToPostfix.infixToPostfix((exp.split("=")[1])))));

            }
            else if (exp.contains("debug"))
            {
               switch (exp.split(" ")[1])
               {
                   case "True":
                   case "true":
                       Debug.logging = true;
                       break;
                   case "False":
                   case "false":
                       Debug.logging = false;
                       break;
               }
               Debug.log("Debug mode set to "+exp.split(" ")[1]);
            }
            else if(exp.equals("clear"))
            {
               //Clear console

            }
            else if(exp.equals("help"))
            {
               Debug.log("If you want to set variables write 'x=5*5' with anny letter ");
               Debug.log("To turn on debug mode write 'debug true'. To turn of debug mode write 'debug false' ");
               Debug.log("Addition is with +");
               Debug.log("Subtraction is with -");
               Debug.log("Multiplication is with *");
               Debug.log("Power of is with ^");
               Debug.log("Scare root is with !");

            }
            else
            {
               try{
                    Map<String,Float> m = vars;
                   Debug.log(pp.getAnswer(InfixToPostfix.infixToPostfix(Maths.switchVariable(exp,m))));
                }
               catch(Exception e)
               {
                   Debug.log("Syntax error");
                   Debug.error(e.toString());
               }
            }
        }
    }
}
