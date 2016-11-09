public class Finder {
    public static void main (String[] args) {
        Finder finder = new Finder();
        finder.testSimpleGene();
    }

    public String findSimpleGene (String dna) {
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1) {
            return "";
        }
        int currIndex = dna.indexOf("TAA", startIndex + 3);
        if (currIndex == -1) {
            return "";
        }
        while (currIndex != -1) {
            if ((currIndex - startIndex) % 3 ==0) {
                return dna.substring(startIndex,currIndex);
            }
            else {
                currIndex = dna.indexOf("TAA", currIndex + 1);
            }
        }

        return "";
    }
    public String findGene(String dna) {
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1) {
            return "";
        }
        int taaIndex = fingStopCodon(dna,startIndex,"TAA");
        int tagIndex = fingStopCodon(dna,startIndex,"TAG");
        int tgaIndex = fingStopCodon(dna,startIndex,"TGA");
        int temp = Math.min(taaIndex,tagIndex);
        int minIndex = Math.min(temp,tgaIndex);
        if (minIndex == dna.length()){
            return "";
        }
        return dna.substring(startIndex,minIndex + 3);
    }

    public int fingStopCodon(String dnaStr, int startIndex, String stopCodon){
        int currIndex = dnaStr.indexOf(stopCodon, startIndex +3);
        while (currIndex != -1) {
            int diff = currIndex - startIndex;
            if (diff %3 ==0){
                return currIndex;
            }
            else{
                currIndex = dnaStr.indexOf(stopCodon, currIndex + 1);
            }
        }
        return dnaStr.length();
    }

    public void testSimpleGene() {
        String dna = "AATTCGTAATATGGT";
        System.out.println("DNA strand is " + dna);
        String gene = findSimpleGene(dna);
        if (dna.length() == 0) {
            System.out.println("No gene found.");
        }
        else System.out.println("Gene in " + gene);

        dna = "AATGCTAGGGTATTATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene in " + gene);

        dna = "ATCCTATCCTTGGCTGCTCTACTATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene in " + gene);

        dna = "TTGAATGTATTGATAA";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene in " + gene);

        dna = "AAATGCCCTAACTAGATTAAGAAACC";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene in " + gene);

        String dnaStr = "xxxyyyzzzTAAxxxyyyzzzTAAxx";
        int dex = fingStopCodon(dnaStr,0,"TAA");
        if (dex != 9) System.out.println("error on 9");
        dex = fingStopCodon(dnaStr,9,"TAA");
        if (dex != 21) System.out.println("error on 21");
        dex = fingStopCodon(dnaStr,1,"TAA");
        if (dex != 26) System.out.println("error on 26");
        dex = fingStopCodon(dnaStr,0,"TAG");
        if (dex != 26) System.out.println("error on 26 TAG");
        System.out.println("Tests finished.");
    }
}