import java.util.*;
interface iterator{
    boolean hasNext();
    void next();
}
class SimpleIterator implements iterator{
    private PlayList pList;
    private int idx ;
    public SimpleIterator(PlayList p){
      this.pList = p;
      idx = 0;   
    }
    @Override
    public boolean hasNext(){
        return idx<pList.ListOfSongs.size();
    }

    @Override 
    public void next(){
        System.out.println("song playing "+pList.ListOfSongs.get(idx++));
    }
}
class SuffledIterator implements iterator{
    private PlayList pList;
    private int idx ;
    private ArrayList<String>suffledList;
    public SuffledIterator(PlayList p){
      this.pList = p;
      this.suffledList = new ArrayList<>(pList.ListOfSongs);
      Collections.shuffle(suffledList);
      idx = 0;
    }
    @Override
    public boolean hasNext(){
        return idx<suffledList.size();
    }

    @Override 
    public void next(){
        System.out.println("song playing "+suffledList.get(idx++));
    }
}
class PlayList{
    public ArrayList<String>ListOfSongs;
    public PlayList(){
        ListOfSongs = new ArrayList<>();
    }
    
    public void addSong(String song){
        ListOfSongs.add(song);
    }
}
public class IteratorPattern {
    public static void main(String args[]){
        PlayList p = new PlayList();
        p.addSong("Brokelyn baby");
        p.addSong("Sanam teri kasma");
        p.addSong("Lagan lagi");
        p.addSong("Naina morey");
        p.addSong("Espresso sbarina carpainter");

        //now create an iterator
        SimpleIterator it = new SimpleIterator(p);
        while(it.hasNext()){
            it.next();
        }

        SuffledIterator it2 = new SuffledIterator(p);
        while (it2.hasNext()) {
            it2.next();
        }
    }
}

//quite cool this is and have many real life implimentations like music app , gallery app etc
//for more details do a visit to https://codewitharyan.com/tech-blogs/iterator-design-pattern