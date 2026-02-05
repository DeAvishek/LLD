import java.io.*;
interface PaymentStrategy {
    void processPayment();    
}
class Creditcard implements PaymentStrategy{
    @Override
    public void processPayment(){
        System.out.println("Payment is being initated by Creditcard");
    }
}
class GooglePay implements PaymentStrategy{
    @Override
    public void processPayment(){
        System.out.println("Payment is being initated by Google Pay");
    }
}
class NetBanking implements PaymentStrategy{
    @Override
    public void processPayment(){
        System.out.println("Payment is being initated by NetBanking");
    }
}
class PayemntProcessor{
    private PaymentStrategy ps;
    public PayemntProcessor(PaymentStrategy p){
        this.ps = p;
    }
    public void processPayment(){
        ps.processPayment();;
    }
    public void ChangeStrategy(PaymentStrategy p){
        this.ps = p;
    }
}
public class StrategyPattern {
    public static void main(String []args){
       PaymentStrategy Creditcard = new Creditcard();
       PaymentStrategy GooglePay = new GooglePay();
       PaymentStrategy NetBanking = new NetBanking();
       PayemntProcessor p =new PayemntProcessor(Creditcard);
       p.ChangeStrategy(GooglePay);
       p.ChangeStrategy(NetBanking);
       p.processPayment();
    }
}

//# for more details do a visit at the link - https://codewitharyan.com/tech-blogs/strategy-design-pattern