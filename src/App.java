import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        System.out.println("Press 1 to add student");
        System.out.println("Press 2 to view all students");
        int choice=sc.nextInt();
        StudentManager sm =new StudentManager();

        switch (choice) {
            case 1:
                System.out.println("enter name of student");
                String name=sc.next();
                System.out.println("enter id of student");
                int id=sc.nextInt();
                System.out.println("enter age of student");
                int age=sc.nextInt();
                Student student=new Student(id,name,age);
               
                sm.saveStudent(student);
                break;
            case 2:
                sm.view_student();
            default:
                break;
        }
        
        
       
        
       
    }
}
class Student{
    private int id;
    private String name;
    private int age;

    public Student(int id,String name,int age){
        this.id=id;
        this.name=name;
        this.age=age;
    }

    public int get_id(){
        return this.id;
    }
    public String get_name(){
        return this.name;
    }
    public int get_age(){
        return this.age;
    }
}
class StudentManager{
   
    public static String File_name="student.txt";

    public void saveStudent(Student student){
        try( BufferedWriter writer=new BufferedWriter(new FileWriter(File_name,true))){
           writer.write(student.get_name()+"\n"+student.get_id()+"\n"+student.get_age()+"\n");
           
            System.out.println("Saved successfully");
        }
        catch(IOException e){
            System.out.println("Save failed");
        }

    

    }
    public void view_student(){
        try(BufferedReader reader=new BufferedReader(new FileReader(File_name))){
            String line;
            while((line=reader.readLine())!=null){
                System.out.println(line);
                
            }
            System.out.println("file ended");
            
        }
        catch(IOException e){
            System.out.println("problem reading");
        }
    }
    
}




