import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.Stack;

/**
 * Select the first tag and continue searching for close tag
 * If ne open tag detected, than count it as the next closure tag
 * String mystring = "the quick brown fox";
 * String arr[] = mystring.split(" ", 2);
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
            Stack firstWordsStack = new Stack();
            String closeTag = "/";

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

                    String firstWordPeek = firstWordsStack.peek().toString();


                    //If trimmed first word is more than 0 (actually a word) and word or string doesn't contain closeTag
                    if ((firstWordPeek.trim().length() > 0) && (!sCurrentString.contains(closeTag))) {
                        bw.write(sCurrentString + "\n");
                    }

                    if ((firstWordPeek.trim().length() > 0) && (firstWordPeek.trim().contains(closeTag))) {
                        String sConverted = sCurrentString.replace(closeTag, closeTag + firstWordPeek);
                        firstWordsStack.pop();
                        bw.write(sConverted + "\n");
                    }


                    //if (firstWordPeek.contains(closeTag)){
                    //    firstWordsStack.pop();
                   //     bw.write(sCurrentString + "\n");
                   // }



                  //  if ((sCurrentString.contains(closeTag))) {
                  //      if (!sCurrentString.contains(closeTag + firstWordPeek + ">")) {
                  //          String sConverted = sCurrentString.replace(closeTag, closeTag + firstWordPeek);
                  //          firstWordsStack.pop();
                  //          bw.write(sConverted + "\n");
                  //      }

                //    }


                       // if (((sCurrentString.contains(closeTag))) && (!sCurrentString.contains("/"+ firstWordPeek + ">"))){
                       //     String sConverted = sCurrentString.replace(closeTag, "/" + firstWordPeek);
                       //     firstWordsStack.pop();
                       //     bw.write(sConverted + "\n");
                       // }
                    }
                }
            }
        }
    }


// if (sCurrentString.contains("/" + firstWordsStack.peek().toString())) {
//Debug:
//System.out.println(sCurrentString);

//   firstWordsStack.pop();
// } else {
//   if (sCurrentString.contains(firstWordsStack.peek().toString())) {
// String sConverted = sCurrentString.replace(closeTag, "/" + firstWordsStack.pop().toString() + ">");
//  bw.write(sConverted + "\n");
//Debug:
//System.out.println(sConverted);
// }
//}
//Do something