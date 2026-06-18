import java.util.*;

public class ReportService {
    public static void generate(List<StudentModel> students) {
        System.out.println("\n--- REPORT ---");
        System.out.println("Total Students: " + students.size());

        double max = students.stream()
                .mapToDouble(StudentModel::getGpa)
                .max().orElse(0);
        double min = students.stream()
                .mapToDouble(StudentModel::getGpa)
                .min().orElse(0);
        double avg = students.stream()
                .mapToDouble(StudentModel::getGpa)
                .average().orElse(0);

        System.out.println("Highest GPA: " + max);
        System.out.println("Lowest GPA: " + min);
        System.out.println("Average GPA: " + avg);
    }
}