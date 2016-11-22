import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

public class FileChooser {
    public static void main (String[] args) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
        "JPG & GIF Images", "jpg", "gif");
        chooser.setFileFilter(filter);

        int returnVal = chooser.showOpenDialog(chooser);

        try {

            String sCurrentString;

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());

                br = new BufferedReader(new FileReader(chooser.getSelectedFile().getAbsolutePath()));

                bw = new BufferedWriter(new FileWriter(chooser.getCurrentDirectory() + "myfile.txt"));

                while ((sCurrentString = br.readLine()) != null) {
                    //Do something
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
                if (bw != null) bw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}