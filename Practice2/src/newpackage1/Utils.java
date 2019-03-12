/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage1;

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

/**
 *
 * @author User
 */
public class Utils {

    public static void writeToFile(String fileName, List<Student> students) {
        File file = new File(fileName + ".txt");

        try {
            if (file.exists() == false) {
                System.out.println("New File Created");
                file.createNewFile();
            }
            PrintWriter writer = new PrintWriter(new FileWriter(file, true));
            for (Student s : students) {
                writer.append(s.getId() + " " + s.getName() + " " + s.getEmail() + " " + s.getAge() + " "
                        + s.getGender() + " " + s.getCourses() + " " + s.getRound() + " " + s.getMsg() + " " + "\n");
                writer.close();
            }
        } catch (IOException ex) {
            System.out.println("Could not log");
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
            System.out.println("Buffered reader issue");
        }
    }
}
