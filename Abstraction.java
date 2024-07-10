public class Abstraction {
    public static void main(String args[]){
        Horse h = new Horse(); //the way we made object of horse, we cannot make object of animal
        h.walk();
        Chicken c = new Chicken();
        c.walk();
        //print brown because before calling contructor of
        //child class, the contructor of superclass is called first
        System.out.println(h.color);
    }
}
abstract class Animal{
    String color;
    void eat(){
        System.out.println("Animal eats");
    }
    abstract void walk(); //just gave an idea of a walk function with no implementation
    //Making a contructor
    Animal(){
        color = "brown"; // an animal is given brown as default color
    }
}
class Horse extends Animal{
    void walk(){
        System.out.println("Walks on 4 legs");
    }
    void changeColor(){
        color = "White";
    }
}
class Chicken extends Animal{
    void walk(){
        System.out.println("Walks on 2 legs");
    }
}