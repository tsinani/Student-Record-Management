import java.util.*;

public class StudentService {
    private List<StudentModel> students = new ArrayList<>();
    public void addStudent(StudentModel s) {
        students.add(s);
    }
    public StudentModel searchStudent(int id) {
        for (StudentModel s : students) {
            if (s.getStudentId() == id) return s;
        }
        return null;
    }
    public boolean deleteStudent(int id) {
        return students.removeIf(s -> s.getStudentId() == id);
    }
    public List<StudentModel> getAllStudents() {
        return students;
    }
    public void displayAll() {
        for (StudentModel s : students) {
            System.out.println(s);
        }
    }
}