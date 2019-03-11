package newpackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sun.awt.resources.awt;

public class Utils {

    public static void writeToFile(String fileName, List<Student> students) {
        File destFile = new File(fileName + ".txt");
        try {
            if (destFile.exists() == false) {
                System.out.println("Create new file");
                destFile.createNewFile();
            }
            PrintWriter writer = new PrintWriter(new FileWriter(destFile, true));
            for (Student s : students) {
                writer.append(s.getId() + " " + s.getName() + " " + s.getEmail() + " "
                        + s.getAge() + " " + s.getGender() + " " + s.getCourses() + " " + s.getRound()
                        + " " + s.getMsg());
            }
        } catch (IOException e) {
            System.out.println("Could not log!");
        }
    }

    public static void displayStudentDataFromFile(String fileName, DefaultTableModel model) {
        String line;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(fileName + ".txt"));
            while ((line = reader.readLine()) != null) {
                model.addRow(line.split(" "));
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Buffered Reader issue.");
        }
    }
}
