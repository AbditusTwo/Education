public class Part3 {
    public static void main (String[] args) {
        Part3 occurrence = new Part3();
        occurrence.testing();
        Part3 last = new Part3();
        last.lastPart("","");
    }

    public String twoOccurrences (String stringa, String stringb) {
        String result = "true";
        int startIndex = stringb.indexOf(stringa);
        if (startIndex == -1) {
            return "false";
        }
        int stopIndex = stringb.indexOf(stringa, startIndex + stringa.length());
        if (stopIndex == -1) {
            return "false";
        }
        return result;
    }

    public String lastPart (String stringa ,String stringb) {
        String result = "";
        int startIndex = stringb.indexOf(stringa);
        if (startIndex == -1) {
            return stringb;
        }
        result = stringb.substring(startIndex + stringa.length());
        return result;
    }

    public void testing() {
        String myString = "A story by Abby Long";
        String giveMeString = twoOccurrences("by",myString);
        System.out.println("Given string is " + myString);
        System.out.println("Two times occurrence: " + giveMeString);

        myString = "banana";
        giveMeString = twoOccurrences("a",myString);
        System.out.println("Given string is " + myString);
        System.out.println("Two times occurrence: " + giveMeString);

        myString = "ctgtatgta";
        giveMeString = twoOccurrences("atg",myString);
        System.out.println("Given string is " + myString);
        System.out.println("Two times occurrence: " + giveMeString);

        String lastString = "banana";
        String giveMeLastString = lastPart("an",lastString);
        System.out.println("Given string is " + lastString);
        System.out.println("Last words: " + giveMeLastString);

        lastString = "forest";
        giveMeLastString = lastPart("zoo",lastString);
        System.out.println("Given string is " + lastString);
        System.out.println("Last words: " + giveMeLastString);
    }
}