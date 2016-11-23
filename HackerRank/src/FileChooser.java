import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

public class FileChooser {
    public static void main (String[] args) throws IOException {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
        "JPG & GIF Images", "jpg", "gif");
        chooser.setFileFilter(filter);

        int returnVal = chooser.showOpenDialog(chooser);

        try (BufferedReader br = new BufferedReader(new FileReader(chooser.getSelectedFile().getAbsolutePath()));
             BufferedWriter bw = new BufferedWriter(new FileWriter(chooser.getCurrentDirectory() + "\\myfile.txt"))
        ) {

            String sCurrentString;

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());

                while ((sCurrentString = br.readLine()) != null) {
                    //Do something
                }
            }
        }
    }
}