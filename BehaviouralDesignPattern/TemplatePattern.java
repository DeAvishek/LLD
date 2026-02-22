abstract class bevarage{
    public final void prepare(){
        boilWater();
        brew();
        addExGridients();
        prepareCup();
    }
    abstract void brew();
    abstract void addExGridients();
    private void boilWater(){
        System.out.println("Boil water...");
    }
    private void prepareCup(){
        System.out.println("Fill the cup...");
    }
}
class MakeTea extends bevarage{
    @Override
    public void brew(){
        System.out.println("Brew Tea...");
    }
    @Override
    public void addExGridients(){
        System.out.println("Add lemon and som tea...");
    }
}
class MakeCoffee extends bevarage{
    @Override
    public void brew(){
        System.out.println("Brew some coffee...");
    }

    @Override
    public void addExGridients(){
        System.out.println("Add some milk and sugar...");
    }
}
public class TemplatePattern {
    public static void main(String args[]){
        MakeTea tea = new MakeTea();
        tea.prepare();
        MakeCoffee coffee = new MakeCoffee();
        coffee.prepare();

    }
}
