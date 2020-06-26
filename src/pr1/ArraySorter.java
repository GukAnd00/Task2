package pr1;

import java.util.ArrayList;
import java.util.List;

public class ArraySorter {

    public static List <ArrayList<String>> getArraySorted(List <ArrayList<String>> linesAndNumberOfRepeats) {

        boolean isSorted = false;

        while(!isSorted) {

            isSorted = true;

            for(int i=0;i<linesAndNumberOfRepeats.size()-1;i++) {
                if(Integer.parseInt(linesAndNumberOfRepeats.get(i).get(1)) < Integer.parseInt(linesAndNumberOfRepeats.get(i+1).get(1)) ){
                    isSorted = false;
                    String bufLine="",bufNum="";

                    bufLine=linesAndNumberOfRepeats.get(i).get(0);
                    bufNum=linesAndNumberOfRepeats.get(i).get(1);

                    linesAndNumberOfRepeats.get(i).set(0, linesAndNumberOfRepeats.get(i+1).get(0));
                    linesAndNumberOfRepeats.get(i).set(1, linesAndNumberOfRepeats.get(i+1).get(1));

                    linesAndNumberOfRepeats.get(i+1).set(0, bufLine);
                    linesAndNumberOfRepeats.get(i+1).set(1, bufNum);

                }

            }

        }
        return linesAndNumberOfRepeats;
    }

}
