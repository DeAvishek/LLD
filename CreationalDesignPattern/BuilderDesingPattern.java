import java.util.*;
class Engineer{
    private String name;
    private int Age;
    private String company;
    private boolean ExpertInDsa;
    private boolean ExpertInSystemDesign;

    //constructor is private for only Engineer builder can initiate objects
    private Engineer(EngineerBuilder eng){
        this.name = eng.name;
        this.Age = eng.age;
        this.company = eng.company;
        this.ExpertInDsa = eng.ExpertInDsa;
        this.ExpertInSystemDesign = eng.ExpertInSystemDesign;
    }
    //getter
    public void display(){
        System.out.println(name);
        System.out.println(Age);
        System.out.println(company);
        System.out.println(ExpertInDsa);
        System.out.println(ExpertInSystemDesign);

    }

    //nested Engineer builder for encapsulation and 
    static class EngineerBuilder{
        private String name;
        private int age;
        //default values
        private String company = "xyz";
        private boolean ExpertInDsa = true;
        private boolean ExpertInSystemDesign = true; 

        //build the engineers feature in builder class
        public EngineerBuilder setName(String Name){
            this.name = Name;
            return this;
        }
        public EngineerBuilder setAge(int Age){
            this.age = Age;
            return this;
        }
        public EngineerBuilder setCompany(String Comapny){
            this.company = Comapny;
            return this;
        }
        public EngineerBuilder SetIsExpertInDsa(boolean value){
            this.ExpertInDsa = value;
            return this;
        }
        public EngineerBuilder SetIsExpertInSystemDesign(boolean val){
            this.ExpertInSystemDesign = val;
            return this;
        }
        public Engineer build(){
            return new Engineer(this); //return a new engineer created using this builder
        }
    }
}
public class BuilderDesingPattern {
    public static void main(String args[]){
        Engineer.EngineerBuilder builder = new Engineer.EngineerBuilder();
        Engineer eng1 = builder.setName("Avishek").setAge(22).setCompany("Google").SetIsExpertInSystemDesign(false).build();
        eng1.display();
    }
    
}

// for more deatils visist this link https://codewitharyan.com/tech-blogs/builder-design-pattern
