import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.Stack;

/**
* Select the first tag and continue searching for close tag
* If ne open tag detected, than count it as the next closure tag
* String mystring = "the quick brown fox";
* String arr[] = mystring.sp
* String firstWord = arr[0];   //the
* String theRest = arr[1];     //quick brown fox
*/

public class FileChooser {
public static void main(String[] args) throws IOException {
    JFileChooser chooser = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "TXT files", "txt");
    chooser.setFileFilter(filter);

    int returnValue = chooser.showOpenDialog(chooser);

    try (BufferedReader br = new BufferedReader(new FileReader(chooser.getSelectedFile().getAbsolutePath()));
         BufferedWriter bw = new BufferedWriter(new FileWriter(chooser.getCurrentDirectory() + "\\myfile.txt"))
    ) {

        String sCurrentString;
        Stack <String> firstWordsStack = new Stack<>();
        String closeTag = " /";
        String closeTagTrim = closeTag.trim();

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());

            while ((sCurrentString = br.readLine()) != null) {
                String arr[] = sCurrentString.split(" ", 2);
                String firstWord = arr[0];
                //firstWordsStack.push(firstWord.substring(1));
                firstWordsStack.push(firstWord.trim().substring(1));

                //Debug:
                System.out.println(firstWordsStack);
                //System.out.println(sCurrentString);

                String firstWordPeek = firstWordsStack.peek();

                    if ((firstWordPeek.length() > 0) && (!sCurrentString.contains(closeTagTrim))) {
                        bw.write(sCurrentString + "\n");
                    }

                    if ((firstWordPeek.length() > 0) && (sCurrentString.contains(closeTagTrim)) && (!firstWordPeek.contains(closeTagTrim))){
                        String sConverted = sCurrentString.replace(closeTag, closeTagTrim + firstWordsStack.pop());
                        bw.write(sConverted + "\n");
                    }

                    if ((firstWordPeek.length() > 0) && (firstWordPeek.contains(closeTagTrim))) {
                        firstWordsStack.pop();
                        bw.write(sCurrentString + "\n");
                        firstWordsStack.pop();
                    }

                    if (firstWordPeek.length() <= 0) {
                        firstWordsStack.pop();
                        String sConverted = sCurrentString.replace(closeTag, closeTagTrim + firstWordsStack.pop());
                        bw.write(sConverted + "\n");
                    }
                }
            }
        }
    }
}