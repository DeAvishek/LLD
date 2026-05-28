import java.util.Stack;
class EditorHistory{
    private static EditorHistory instance;
    private Stack<Memento>history = new Stack<>();
    private EditorHistory(){
        System.out.println("Creating EditorHistory");
    }
    public static EditorHistory getInstance(){
        if(instance == null){
            instance = new EditorHistory();
        }
        return instance;
    }
    public void saveHistory(Memento memento){
        history.push(memento);
    }
    public Memento Undo(){
        if(!history.isEmpty())return history.pop();
        return null;
    }
    public Memento getHistory(){
        if(!history.isEmpty())return history.peek();
         return null;
    }
}
class Memento{
    private String text;
    public Memento(String text){
        this.text = text;
    }
    public String getText(){
        return text;
    }
}
class Originator{
    private String text;
    public void SetText(String text,EditorHistory history){
        this.text = text;
        //when some text is written i want to save the memento
        history.saveHistory(new Memento(text));
    }
    public String getText(EditorHistory history){
        Memento m =  history.getHistory();
        return m.getText();
    }
}
public class MomentoDesign {
    public static void main(String[] args){
        EditorHistory editorHistory = EditorHistory.getInstance();
        Originator TextEditor = new Originator();
        TextEditor.SetText("Hello World",editorHistory);
        System.out.println("Originator Text"+TextEditor.getText(editorHistory));
        TextEditor.SetText("hello world 2",editorHistory);
        System.out.println("Originator Text"+TextEditor.getText(editorHistory));
        TextEditor.SetText("hello world 3",editorHistory);
        System.out.println("Originator Text"+TextEditor.getText(editorHistory));
        editorHistory.Undo();
        System.out.println("Originator Text"+TextEditor.getText(editorHistory));

    }
}
