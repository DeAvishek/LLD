import java.util.*;
class Light{
    public void on(){
        System.out.println("Turn on Light");
    }
    public void off(){
        System.out.println("Turn off Light");
    }
}
class AirCooler{
    private int CurrentTemp = 10;
    public void ChangeTemp(int temp){
        this.CurrentTemp = temp;
        System.out.println("Changes the temparature to "+temp);
    }
    public int CurrentTemparature(){
        return CurrentTemp;
    }
}
interface Command{
    void execute();
}

class TrunOnCommand implements Command{
    private Light l1;
    public TrunOnCommand(Light l1){
        this.l1 = l1;
    }
    @Override
    public void execute(){
        l1.on();
    }
}
class TurnOffCommand implements Command{
    // private AirCooler Ac;
    private Light l2;
    public TurnOffCommand(Light l2){
        this.l2 = l2;
    }
    @Override
    public void execute(){
        l2.off();
    }
}
class AirCoolerChangeTemp implements Command{
    private AirCooler ac;
    private int temp;
    public AirCoolerChangeTemp(AirCooler ac,int temp){
        this.ac = ac;
        this.temp = temp;
    }

    @Override
    public void execute(){
        ac.ChangeTemp(temp);
    }
}
class AirCoolerGetCurrentTemp implements Command{
    private AirCooler ac;
    public AirCoolerGetCurrentTemp(AirCooler ac){
        this.ac = ac;
    }
    @Override
    public void execute(){
        System.out.println("Current temp of Air cooler "+ac.CurrentTemparature());
    }
}
public class CommandPattern {
    public static void main(String args[]){
        Light light = new Light();
        AirCooler ac = new AirCooler();

        Command on = new TrunOnCommand(light);
        Command off = new TurnOffCommand(light);
        on.execute();
        off.execute();

        Command Chtemp = new AirCoolerChangeTemp(ac, 17);
        Command getTemp = new AirCoolerGetCurrentTemp(ac);
        Chtemp.execute();
        getTemp.execute();

        Chtemp = new AirCoolerChangeTemp(ac, 45);
        Chtemp.execute();
        getTemp = new AirCoolerGetCurrentTemp(ac);
        getTemp.execute();

    }
}

//for more details do a visit to the link https://algomaster.io/learn/lld/command