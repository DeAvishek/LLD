import java.util.*;
class Logger{
    private static Logger Instance = null;
    private Logger(){
        System.out.println("Intance created");
    }

    public static Logger GetInstance(){
        if(Instance == null){
             Instance = new Logger();
             return Instance;
        }
        return Instance;
    }
    public void LogMeaage(String str){ 
        System.out.println(str);
    }
}
public class SingleTonPattern {
    public static void main(String []ans){
        Logger log = Logger.GetInstance();
        log.LogMeaage("hii");
        log.LogMeaage("hello");
    }
}

//for more deatils visit the link https://codewitharyan.com/tech-blogs/singleton-design-pattern
