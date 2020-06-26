package pr1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static File fileToRead = new File("C:/Users/gukan/IdeaProjects/Pr1/src/input.txt");
    private static File fileToWrite = new File("C:/Users/gukan/IdeaProjects/Pr1/src/output.txt");


    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter symbol, to find lines with repeats: ");
        String toFind =sc.nextLine();

        ArrayKeeper arrayKeeper = new ArrayKeeper();
        ArraySorter arraySorter = new ArraySorter();
        arrayKeeper.readFile(fileToRead);
        arrayKeeper.setArray(arrayKeeper.arrayHandler(arrayKeeper.getAllLines(),toFind));
        ArrayKeeper.setArray(arraySorter.getArraySorted(arrayKeeper.getArray()));

        if(ArrayKeeper.getArray().size()==0){
            System.out.println("No repeats found");
        }
        else {
            System.out.println("Sorted repeats");
            System.out.println(ArrayKeeper.getArray());
            arrayKeeper.writeArrayToFile(fileToWrite, arrayKeeper.getArray());
            }


    }
    }
