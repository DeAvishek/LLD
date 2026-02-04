import java.util.*;

import javax.smartcardio.Card;

import java.io.*;
interface Veichel {
   void start();
   void stop();
}
class car implements Veichel{
    private String Engine;
    car(String Engine){
        this.Engine = Engine;
    }
    @Override
    public void start(){
        System.out.println("car started with engine.."+Engine);
    }
    @Override
    public void stop(){
        System.out.println("car stopped");
    }
}
class Bike implements Veichel{
    @Override
    public void start(){
        System.out.println("bike started");
    }
    @Override
    public void stop(){
        System.out.println("bike stopped");
    }
}
class Factory{
    public static Veichel produVeichel(String type,String Engine){
        if(type.equals("car")){
            return new car(Engine);
        }
        return new Bike();
    }
}
public class Factorydesign {
    public static void main(String[] args){
        Veichel car =  Factory.produVeichel("car","turbo");
        car.start();
        car.stop();
        // Veichel bike =  Factory.produVeichel("bike");
        // bike.start();
        // bike.stop();
    }
}
