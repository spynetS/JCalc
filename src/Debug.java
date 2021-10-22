public class Debug {

    public static boolean logging= false;

    public static void log(String log)
    {
        if(logging)
        {
            System.out.println(log);
        }
    }
    public static void log(String[] logs,String between)
    {
        if(logging)
        {
            for(String log :logs)
                System.out.print(log+between);
        }
    }
    public static void log(String[] logs)
    {
        if(logging)
        {
            for(String log :logs)
                System.out.print(log+" ");
        }
    }
    public static void error(String log)
    {
        if(logging)
        {
            System.out.println(log);
        }
    }
    public static void error(String[] logs,String between)
    {
        if(logging)
        {
            for(String log :logs)
                System.out.print(log+between);
        }
    }
    public static void error(String[] logs)
    {
        if(logging)
        {
            for(String log :logs)
                System.out.print(log+" ");
        }
    }
}
