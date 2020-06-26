package pr1;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tester {
    private static ArrayKeeper arrayKeeper = new ArrayKeeper();
    private static ArraySorter arraySorter = new ArraySorter();
    private static List<ArrayList<String>> testString = new ArrayList<>();

    @Test
    public void testReadFile(){
        File fileToReadCorrect = new File("C:/Users/gukan/IdeaProjects/Pr2/src/input.txt");
        Boolean correctFile=arrayKeeper.readFile(fileToReadCorrect);
        File fileToReadIncorrect = new File("C:/Users/gukan/IdeaProjects/Pr2/src/input12.txt");
        Boolean incorrectFile=arrayKeeper.readFile(fileToReadIncorrect);
        Assert.assertEquals(true, correctFile);
        Assert.assertEquals(false, incorrectFile);
    }

    @Test
    public void testArrayHandler()
    {
        List<String> testArrayString = new ArrayList<>();
        testArrayString.clear();
        testArrayString.add("NNNnnnnN");
        testArrayString.add("44g4NN43g4w");
        testArrayString.add("array should be created");
        testArrayString.add("test NNNnnnnN");
        testArrayString.add("tttt");
        testArrayString.add("dsnKNNnNNNN");
        List<ArrayList<String>> testStringResult = new ArrayList<>();
        testStringResult = arrayKeeper.arrayHandler(testArrayString, "N");
        testArrayString.remove(2);
        testArrayString.remove(3);
        for (int i=0; i<testStringResult.size(); i++){
        Assert.assertEquals(testArrayString.get(i), testStringResult.get(i).get(0));}
    }


    @Test
    public  void testArraySorter(){
        testString.clear();
        testString.add(new ArrayList(Arrays.asList("NNNnnnnN", "3")));
        testString.add(new ArrayList(Arrays.asList("nNNNNNNNsdf", "7")));
        testString.add(new ArrayList(Arrays.asList("44g4NN43g4w", "2")));
        testString.add(new ArrayList(Arrays.asList("dsnKNNnNNNN", "4")));
        List<ArrayList<String>> testStringResult = new ArrayList<>();
        testStringResult = arraySorter.getArraySorted(testString);
        testString.clear();
        testString.add(new ArrayList(Arrays.asList("44g4NN43g4w", "2")));
        testString.add(new ArrayList(Arrays.asList("NNNnnnnN", "3")));
        testString.add(new ArrayList(Arrays.asList("dsnKNNnNNNN", "4")));
        testString.add(new ArrayList(Arrays.asList("nNNNNNNNsdf", "7")));
        Assert.assertEquals(testString,testStringResult);
    }

}
