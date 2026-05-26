//we have different types of patient 1.child 2.adult 3.senior
//we have different types of visitors 1.diagnosis 2.billing
//every patient excepts different visitors
//every visitors visit to patient as per requirements
interface Patient{
    public void Accept(Visitors visitor);
}
interface Visitors{
    public void VisitToChild(Patient patient);
    public void VisitToAdult(Patient patient);
    public void VisitToSenior(Patient patient);
}
class Child implements Patient{
    private Visitors visitor;
    @Override
    public void Accept(Visitors visitor) {
        this.visitor = visitor;
    }
}
class Adult implements Patient{
    private Visitors visitor;
    @Override
    public void Accept(Visitors visitor) {
        this.visitor = visitor;
    }

}
class Senior implements Patient{
    private Visitors visitor;
    @Override
    public void Accept(Visitors visitor) {
        this.visitor = visitor;
    }

}
class DiagnosisVisitor implements Visitors{
    @Override
    public void VisitToChild(Patient patient) {
        patient.Accept(this);
        System.out.println("Diagnosis has been accepted for -- child patient");
    }
    @Override
    public void VisitToAdult(Patient patient) {
        patient.Accept(this);
        System.out.println("Diagnosis has been accepted for -- child Adult patient");
    }
    @Override
    public void VisitToSenior(Patient patient) {
        patient.Accept(this);
        System.out.println("Diagnosis has been accepted for -- child Senior patient");
    }
}
class BillingVisitor implements Visitors{
    @Override
    public void VisitToChild(Patient patient) {
        patient.Accept(this);
        System.out.println("Billing has been accepted for -- child patient");
    }
    @Override
    public void VisitToAdult(Patient patient) {
        patient.Accept(this);
        System.out.println("Billing has been accepted for -- Adult patient");
    }
    @Override
    public void VisitToSenior(Patient patient) {
        patient.Accept(this);
        System.out.println("Billing has been accepted for -- Senior patient");
    }
}


public class VisitorsDesign {
    public static void main(String[] args) {
        Patient []patients = {new Child(),new Adult(),new Senior()};
        DiagnosisVisitor diagnosisVisitor = new DiagnosisVisitor();
        BillingVisitor billingVisitor = new BillingVisitor();
        diagnosisVisitor.VisitToChild(patients[0]);
        billingVisitor.VisitToChild(patients[0]);
        diagnosisVisitor.VisitToAdult(patients[1]);
        billingVisitor.VisitToChild(patients[1]);
        diagnosisVisitor.VisitToSenior(patients[2]);


        billingVisitor.VisitToChild(patients[2]);
    }
}
