import java.io.*;
import java.util.*;

public class FileHandler {
    static {
        new File("data").mkdir();
        new File("backup").mkdir();
    }
    public static void saveText(List<StudentModel> students) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("data/students.txt"))) {
            for (StudentModel s : students) pw.println(s);
        } catch (IOException e) {
            System.out.println("Text error");
        }
    }
    public static void saveBinary(List<StudentModel> students) {
        try (DataOutputStream dos = new DataOutputStream(
                new FileOutputStream("data/students.dat"))) {

            dos.writeInt(students.size());

            for (StudentModel s : students) {
                dos.writeInt(s.getStudentId());
                dos.writeUTF(s.getName());
                dos.writeUTF(s.getDepartment());
                dos.writeDouble(s.getGpa());
            }

        } catch (IOException e) {
            System.out.println("Binary error");
        }
    }
    public static void saveObject(List<StudentModel> students) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("data/students.ser"))) {
            oos.writeObject(students);
        } catch (IOException e) {
            System.out.println("Serialization error");
        }
    }
    public static void backup() {
        try (
                BufferedInputStream bis = new BufferedInputStream(
                        new FileInputStream("data/students.dat"));

                BufferedOutputStream bos = new BufferedOutputStream(
                        new FileOutputStream("backup/backup.dat"))
        ) {
            int data;
            while ((data = bis.read()) != -1) {
                bos.write(data);
            }
        } catch (IOException e) {
            System.out.println("Backup failed");
        }
    }
    public static void fileInfo(String path) {
        File f = new File(path);
        if (f.exists()) {
            System.out.println("Name: " + f.getName());
            System.out.println("Path: " + f.getAbsolutePath());
            System.out.println("Size: " + f.length());
            System.out.println("Last Modified: " + new Date(f.lastModified()));
        }
    }
}