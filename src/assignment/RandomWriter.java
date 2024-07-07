package assignment;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
//import java.util.*;

/*
 * CS 314H Assignment 2 - Random Writing
 *
 * Your task is to implement this RandomWriter class
 */
public class RandomWriter implements TextProcessor {

    private int k;
    private int fileLength;
    private String original = "";
    private static String source;
    public boolean test = false;

    /**
     * Main class takes in args parameters, sets instance variables, and checks for errors.
     * 
     * @param args  Includes source text, result file, level, and length of output.
     */
    public static void main(String[] args) {
      source = args[0];
      String result = args[1];
      int k = Integer.parseInt(args[2]);
      int fileLength = Integer.parseInt(args[3]);

      
      //testing for errors
      if (k < 0) {
        System.err.println("The level of analysis does not exist.");
        //System.exit(0);
        return;
      }
      if (fileLength < 0) {
        System.err.println("Length cannot be negative.");
        //System.exit(0);
        return;
      }
      if (source.length() <= k) {
        System.err.println("There are fewer than k characters in the source.");
        //System.exit(0);
        return;
      }
      
      RandomWriter write = new RandomWriter(k);

      try {
        write.readText(source);
        write.writeText(result, fileLength);
      }
      catch (IOException e) {
        System.err.println("There is an error in the program. " + e);
        //System.exit(1);
        return;
      }
    }

    // Unless you need extra logic here, you might not have to touch this method
    public static TextProcessor createProcessor(int level) {
      return new RandomWriter(level);
    }

    /**
     * Constructor for RandomWriter method.
     * 
     * @param level
     */
    private RandomWriter (int level) {
    //private RandomWriter(int level) {
      // Do whatever you want here
      //set the level here
      k = level;
    }


    /**
     * Reads original text from input filename and puts it in a String variable to access later using scanner.
     */
    public void readText(String inputFilename) throws IOException {
      
      if (k < 0) {
        System.err.println("The level of analysis does not exist.");
        return;
        //System.exit(0);
      }

      File f = new File(inputFilename);
      Scanner scanner = new Scanner(f);
      while (scanner.hasNext())
        original += scanner.nextLine() + "\n";
      //System.out.println(scanner.nextLine());
      System.out.println("original source text: " + original); //for testing
      scanner.close();

    }

    /**
     * Writes text to output variable and prints it out.
     */
    public void writeText(String outputFilename, int length) throws IOException {

      /*
      if (source.length() <= k) {
        System.err.println("There are fewer than k characters in the source.");
        //System.exit(0);
        return;
      }*/

      if (length < 0) {
        System.err.println("The length cannot be negative.");
        //System.exit(0);
        return;
      }

      //creating filewriter object
      FileWriter writer = new FileWriter(outputFilename);
      FileWriter writeTest = new FileWriter("test_books/testResults.txt"); // for testing
      

      int index = (int) (Math.random()*(original.length()-k));
      //for testing
      if (test) {
        writeTest.write("WHITE BOX TESTING" + "\n" + "\n");
        writeTest.write("random starting index: " + index + "\n");
        writeTest.write("level: " + k + "\n");
        writeTest.write("length of output: " + length + "\n");
      }

      //creating output string that contains output
      String output = "";

      //creating seed
      String seed = original.substring(index, index+k);
      if (test) {
        writeTest.write("original text: " + original + "\n");
        writeTest.write("original seed: " + seed + "\n");
      }
      
      for (int j = 0; j < length; j++) {
        //creating char list
        ArrayList<String> chars = new ArrayList<>();
        for (int i = 0; i < original.length()-k-1; i++)
        {
          if (original.substring(i, i+k).equals(seed)) {
            chars.add(original.substring(i+k, i+k+1));
          }
        }
        
        //picking next char based on probability
        int jindex = (int) (Math.random()*(chars.size()));
        
        //printing random char

        seed += chars.get(jindex);
        seed = seed.substring(1);
        if (test) {
          writeTest.write("chars: " + chars + "\n");
          writeTest.write("random selection from chars arraylist: " + chars.get(jindex) + "\n");
          writeTest.write("new seed: " + seed + "\n" + "\n");
        }

        output += chars.get(jindex);
      }
      //printing output
      System.out.println("output: " + "\n" + output); 
      
      if (test)
        writeTest.write("output: " + output);
      writeTest.close();

      writer.write(output);
      writer.close();
    }

    public void runTest() {
      test = true;
    }
}
