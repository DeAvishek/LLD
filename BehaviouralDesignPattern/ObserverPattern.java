import java.io.*;
import java.util.*;
interface SubsCriber {
    public void update(String Video);
}
class YoutubeSubscriber implements SubsCriber{
    String identity;
    public YoutubeSubscriber(String identity){
        this.identity=identity;
    }

    @Override
    public void update(String video){
        System.out.println("Notify the user on Youtube with username "+identity+" "+"video---"+video);
    }
}
class EmailSubscriber implements SubsCriber{
    String identity;
    public EmailSubscriber(String identity){
        this.identity=identity;
    }

    @Override
    public void update(String video){
        System.out.println("Notify the user email "+identity+" "+"video---"+video);
    }
}
interface Channel {
    void Addsubscriber(SubsCriber s);
    void Removesubcriber(SubsCriber s);
    void notifySubscriber(); 
}
class YoutubeChannel implements Channel{
    ArrayList<SubsCriber> listSubs = new ArrayList<>();
    private String video;
    @Override
    public void Addsubscriber(SubsCriber s){
        listSubs.add(s);
    }
    @Override
    public void Removesubcriber(SubsCriber s){
        listSubs.remove(s);
    }

    @Override
    public void notifySubscriber(){
        for(SubsCriber s:listSubs){
            s.update(video);
        }
    }
    public void AddNewVideo(String video){
        this.video = video;
        notifySubscriber();
    }

}
public class ObserverPattern {
    public static void main(String []abs){
        //first build a Youtube channel
        YoutubeChannel yt = new YoutubeChannel();
        YoutubeSubscriber sb1 = new YoutubeSubscriber("Mohan");
        EmailSubscriber sb2 = new EmailSubscriber("hhrh@gmail.com");

        //now add the subscriber to youtbue channels
        yt.Addsubscriber(sb1);
        yt.Addsubscriber(sb2);
    
        //lets upload a video on channel yt
        yt.AddNewVideo("https://falguni.34e451.youtube.com");

    }
}

//both channel and subscriber use interfaces which make this system loosly coupled when a new option is added just need 
// to impliments subcriber interface so Open closed principle is maintain

//for more datils do a visit to the link https://codewitharyan.com/tech-blogs/observer-design-pattern