public class Constructors {
    public static void main(String args[]){
        Student s1 = new Student();
        s1.name = "Eshita";
        s1.rollno=36;
        s1.password="abcd";
        s1.marks[0]=80;
        s1.marks[1]=100;
        s1.marks[2]=90;
        Student s2 = new Student("Eshita");
        Student s3= new Student(36);

        Student s4 = new Student(s1);
        s4.password="xyz";  //we updated the password
        s1.marks[2]= 100;
        for(int i = 0; i<3; i++){ //printing marks'value in shallow copy constructor
            System.out.println(s4.marks[i]);
        }
        
        
    }
    //write static in front of the class Student to indicate that it is a static nested class, 
    //which means it does not require an instance of the outer class to be instantiated. 
    //This allows Student to be instantiated independently, without needing an instance of the enclosing class Constructors.
    static class Student{
        String name;
        int rollno;
        String password;
        int marks[];
        Student(){
            System.out.println("Non parametrized Constructor called.");
            marks = new int[3];
        }
        Student(String name){
            this.name = name;
            System.out.println("Name= "+name);
        }
        Student(int rollno){
            this.rollno=rollno;
            System.out.println("Roll number= "+rollno);
        }
        //Shallow copy constructor
        Student(Student s1){
            marks= new int[3]; // allows to store array because if not there it gives error "Cannot store to int array because "s1.marks" is null"
            this.name = s1.name;
            this.rollno=s1.rollno;
            this.marks= s1.marks;
    }
    //deep copy contructor
    // Student(Student s1){
    //     marks = new int[3];
    //     this.name = s1.name;
    //     this.rollno = s1.rollno;
    //     for(int i = 0; i<marks.length; i++){
    //         this.marks[i]= s1.marks[i];
    //         System.out.println("Marks= "+marks[i]);
    //     }
    // }
}
}