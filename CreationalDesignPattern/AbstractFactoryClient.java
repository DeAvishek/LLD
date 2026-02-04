import java.util.*;
import java.io.*;
interface Car{
    public void assembly();
}
interface carSpecification{
    public void specification();
}
//assemble car and specification for different region
class NotrhamericaCar implements Car{
    @Override
    public void assembly(){
        System.out.println("Assemble seadan car");
    }
}
class NotrhamericaSpecification implements carSpecification{
    @Override
    public void specification(){
        System.out.println("NorthAmerica car specification");
    }
}
class AsianCar implements Car{
    @Override
    public void assembly(){
        System.out.println("Assemnble seaden car");
    }
}
class AsianSpecification implements carSpecification{
    @Override
    public void specification(){
        System.out.println("Asian car specification");
    }
}
interface Carfactory{
    public Car createCar();
    public carSpecification carsp();
}
class Notrhamerica implements Carfactory{
    public Car createCar(){
        return new NotrhamericaCar();
    }
    public carSpecification carsp(){
        return new NotrhamericaSpecification();
    }
}
class Asia implements Carfactory{
    public Car createCar(){
        return new AsianCar();
    }
    public carSpecification carsp(){
        return new AsianSpecification();
    }
}

public class AbstractFactoryClient {
   public static void main(String args []){
    Carfactory noreCarfactory = new Notrhamerica();
    Car sden = noreCarfactory.createCar();
    carSpecification ofseaden = noreCarfactory.carsp();
    sden.assembly();
    ofseaden.specification();
   }
}
