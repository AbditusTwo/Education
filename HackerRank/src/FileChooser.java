import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooser {
    public static void main (String[] args) {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
        "JPG & GIF Images", "jpg", "gif");
        chooser.setFileFilter(filter);

        int returnVal = chooser.showOpenDialog(chooser);

        if(returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: " +
                chooser.getSelectedFile().getName());
        }


    }
}
