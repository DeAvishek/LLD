abstract class Approver{
    protected Approver nextApprover;
    public void setNextApprover(Approver nextApprover){
        this.nextApprover = nextApprover;
    }
    public abstract void process(int days);
}
class Supervisor extends Approver{
    @Override
    public void process(int days) {
        if(days<=5) System.out.println("Supervisor has approved");
        else {
            if(nextApprover!=null) {
                System.out.println("Your Request has been forwarded to next approver");
                nextApprover.process(days);

            }
        }
    }
}
class Manager extends Approver{
    @Override
    public void process(int days) {
        if(days<=10) System.out.println("Manager has approved");
        else{
            if(nextApprover!=null) {
                System.out.println("Your Request has been forwarded to next approver");
                nextApprover.process(days);

            }
        }
    }
}
class Director extends Approver{
    @Override
    public void process(int days) {
        if(days<=15) System.out.println("Director has approved");
        else{
            if(nextApprover!=null) {
                System.out.println("Your Request has been forwarded to next approver");
                nextApprover.process(days);

            }
            else System.out.println("Your Request has benn declined");
        }
    }
}
public class ChainOfResponsibility {
    public static void main(String[] args) {
        Approver supervisor = new Supervisor();
        Approver manager = new Manager();
        Approver director = new Director();
        supervisor.setNextApprover(manager);
        manager.setNextApprover(director);
        director.setNextApprover(null);
        supervisor.process(17);
    }
}
