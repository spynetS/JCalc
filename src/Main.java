import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    //Main will take care of in and output
    String lastAnswer;
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
            System.out.println(pp.getAnswer(InfixToPostfix.infixToPostfix(exp)));
        }
    }
}
