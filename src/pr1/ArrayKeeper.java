package pr1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PrimitiveIterator;

public class ArrayKeeper {

    private static List<ArrayList<String>> linesAndNumberOfRepeats = new ArrayList<>();
    private static List<String> allLines = new ArrayList<String >();

    public static List<String> getAllLines() {
        return allLines;
    }

    public static void setArray(List<ArrayList<String>> linesAndNumberOfRepeats) {
        ArrayKeeper.linesAndNumberOfRepeats = linesAndNumberOfRepeats;
    }

    public static boolean readFile (File fileToRead){

        try {
            FileReader fr = new FileReader(fileToRead);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while(line!=null){
                allLines.add(line);
                line=reader.readLine();
            }return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<ArrayList<String>> arrayHandler(List<String> allLines, String toFind){
        int numberOfRepeats=0;

        for(String line : allLines) {

            int i=0;
            numberOfRepeats=0;
            int temp=0;

            while(i<line.length()-1){

                if( (line.substring(i,i+1).equals(toFind)) && (line.substring(i+1,i+2).equals(toFind)) )
                {
                    i++;numberOfRepeats++;
                    temp=numberOfRepeats;
                }
                else{ i++;  numberOfRepeats=0; }
                if (temp>=numberOfRepeats){numberOfRepeats=temp;}
            }
            if(numberOfRepeats>0){
                linesAndNumberOfRepeats.add(new ArrayList(Arrays.asList(line, String.valueOf(numberOfRepeats+1))));}
        }
        return linesAndNumberOfRepeats;
    }

    public static List<ArrayList<String>> getArray(){
        return linesAndNumberOfRepeats;
    }

    public static void writeArrayToFile(File fileToWrite, List<ArrayList<String>> linesAndNumberOfRepeats){
        try {
            FileWriter myWriter = new FileWriter(fileToWrite);
            for (int i=0; i<linesAndNumberOfRepeats.size();i++){
                myWriter.write(linesAndNumberOfRepeats.get(i).get(0)+"\n");}
            myWriter.close();
            System.out.println("Successfully wrote to the file: "+fileToWrite);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
