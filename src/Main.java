public class Main {

    //Main will take care of in and output
    String lastAnswer;

    public static void main(String[] args)
    {
       PostFix pp = new PostFix();
       System.out.println(pp.getAnswer("5.5 5 + 10.5 4 * -"));
    }
}
