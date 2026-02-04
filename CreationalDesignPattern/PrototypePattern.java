class Character{
    public String name;
    public String HairColor;
    public int gunPower;
    public String Gender;
    public int Level;
    public Character(String name,String HairColor,int gunPower,String Gender,int Level){
        this.name = name;
        this.HairColor = HairColor;
        this.gunPower = gunPower;
        this.Gender = Gender;
        this.Level = Level;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setGender(String gender){
        this.Gender = gender;
    }
    public Character clone(Character other){
        //if i want to create a deep copy
        return other;
    }
    public void CharcterInfo(){
        System.out.println("Name-"+" "+name+","+" "+"HairColor-"+" "+HairColor+","+" "+"Gunpower-"+" "+gunPower+","+" "+"Gender-"+" "+Gender+","
            +" "+"Level-"+" "+Level+"."
        );
    }
    
}
class CharacterFactory{
    private Character first;
    public CharacterFactory(){
        first =  new Character("Victor","black",80,"Male",0);
    }
    public Character characterWithNameAndGender(String name,String Gender){
        Character  clonedCharacter =  first.clone(first);
        clonedCharacter = new Character(name, clonedCharacter.HairColor,clonedCharacter.gunPower, Gender, clonedCharacter.Level);
        return clonedCharacter;
    }
     public Character characterWithName(String name){
        Character  clonedCharacter =  first.clone(first);
        clonedCharacter = new Character(name, clonedCharacter.HairColor,clonedCharacter.gunPower, clonedCharacter.Gender, clonedCharacter.Level);
        return clonedCharacter;
    }


}
public class PrototypePattern {
    public static void main(String []abd){
        CharacterFactory prototype = new CharacterFactory();
        Character kyle = prototype.characterWithNameAndGender("kyle","Female");
        kyle.CharcterInfo();
        Character Ramos = prototype.characterWithName("Ramos");
        Ramos.CharcterInfo();
        
    }
}

//for more details visit  https://codewitharyan.com/tech-blogs/prototype-design-pattern
//we can also use the cloneble interface and @override the clone mathod to clone an existing object
