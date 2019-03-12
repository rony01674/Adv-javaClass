package practice2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Utils {

    public static void writeToFile(String fileName, List<Student> students) {
        File destFile = new File(fileName + ".txt");

        try {
            if (destFile.exists() == false) {
                System.out.println("New File Created");
                destFile.createNewFile();
            }
            PrintWriter writer = new PrintWriter(new FileWriter(destFile, true));
            for (Student s : students) {
                writer.append(s.getId() + " " + s.getName() + " " + s.getEmail() + " " + s.getAge() + " "
                        + s.getGender() + " " + s.getCourses() + " " + s.getRound() + " " + s.getMsg() + " ");
                writer.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void readDataFromFile(String fileName, DefaultTableModel model) {
        String line;
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(fileName + ".txt"));
            while ((line = reader.readLine()) != null) {
                model.addRow(line.split(" "));
            }
        } catch (IOException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
