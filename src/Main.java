import java.util.*;
public class Main {

    public static void main(String[] args) {
        StudentService service = new StudentService();

        try {
            service.addStudent(new StudentModel(1, "tsion", "CS", 3.5));
            service.addStudent(new StudentModel(2, "Saron", "IT", 3.1));
            service.addStudent(new StudentModel(3, "hilina", "SE", 3.0));

            service.displayAll();
            System.out.println(service.searchStudent(2));
            service.deleteStudent(1);

            FileHandler.saveText(service.getAllStudents());
            FileHandler.saveBinary(service.getAllStudents());
            FileHandler.saveObject(service.getAllStudents());
            FileHandler.backup();
            FileHandler.fileInfo("data/students.txt");
            ReportService.generate(service.getAllStudents());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}