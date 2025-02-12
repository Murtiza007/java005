import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        while(true){
        System.out.println("Press 1 to add student");
        System.out.println("Press 2 to view all students");
        System.out.println("Press 3 to search students");
        System.out.println("Press 4 to search students");
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
            case 3:
                sm.search_student();
            case 4:
                sm.delete_student();
            default:
                break;
        }
        
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
           writer.write(student.get_name()+","+student.get_id()+","+student.get_age()+"\n");
           
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
                String[] parts=line.split(",");
                System.out.println(parts[0]);
            
            }
            System.out.println("file ended");
            
        }
        catch(IOException e){
            System.out.println("problem reading");
        }
    }
   public void search_student(){
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter id of the student");
    String id=sc.next();

    try(BufferedReader reader=new BufferedReader(new FileReader(File_name))){
        String line;
        while((line=reader.readLine())!=null){
            String[] parts=line.split(",");
            
            if (id.equals(parts[1])){
                System.out.println("student found");
                System.out.println(parts[0]); 
                System.out.println(parts[1]); 
                System.out.println(parts[2]); 
            }
            
        }
        

   }
   catch(IOException e){
    System.out.println("problem reading");
}
    
}
 public void delete_student(){
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter id of the student");
    String id=sc.next();

    try(BufferedReader reader=new BufferedReader(new FileReader(File_name))){
        String line;
        while((line=reader.readLine())!=null){
            String[] parts=line.split(",");
            System.out.println(line);
            if (id.equals(parts[1])){
                
                try( BufferedWriter writer=new BufferedWriter(new FileWriter(File_name,true))){
                    writer.write("",0,0);
                    
                     System.out.println("Saved successfully");
                 }
                 catch(IOException e){
                     System.out.println("Save failed");
                 }
               
            }
            
        }
        

   }
   catch(IOException e){
    System.out.println("problem reading");
}


 }
}



