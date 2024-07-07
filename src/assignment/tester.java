package assignment;
import java.io.*;

public class tester {
    
    public static void main (String[] args) {



        //test basic functionality
        testRead(3, "test_books/CatInTheHat.txt");
        testWrite(3, "test_books/CatInTheHat.txt", "test_books/result.txt", 300);

        //test with my own test.txt
        testWrite(3, "test_books/test.txt", "test_books/result.txt", 300);

        //test with different levels
        testWrite(0, "test_books/CatInTheHat.txt", "test_books/result.txt", 100);
        testWrite(1, "test_books/CatInTheHat.txt", "test_books/result.txt", 100);
        testWrite(2, "test_books/MuchAdo.txt", "test_books/result.txt", 200);
        testWrite(3, "test_books/CatInTheHat.txt", "test_books/result.txt", 100);
        testWrite(4, "test_books/OneFishTwoFish.txt", "test_books/result.txt", 100);
        testWrite(5, "test_books/TheGreatGatsby.txt", "test_books/result.txt", 100);
        testWrite(10, "test_books/CatInTheHat.txt", "test_books/result.txt", 200);

        //test with a negative k value
        testWrite(-3, "test_books/test.txt", "test_books/result.txt", 300);

        //test with a negative length
        testWrite(3, "test_books/test.txt", "test_books/result.txt", -4);

        //test if source length is less than or equal to k (level)
        testWrite(50, "test_books/test.txt", "test_books/result.txt", 100);

    }

    
    public static void testRead (int k, String inputFilename) {
        RandomWriter writer = new RandomWriter(k);
        writer.test = true;
        try {
            writer.readText(inputFilename);
        }
        catch (Exception e) {
            System.err.println("There is an error in the program. " + e);
            System.exit(1);
        }
    }
    
    /*
    public static void testRead (int k, String inputFilename) throws IOException {
        RandomWriter writer = new RandomWriter(k);
        
        writer.readText(inputFilename);

    }
    */

    public static void testWrite (int k, String inputFilename, String outputFilename, int length) {
        RandomWriter writer = new RandomWriter(k);
        writer.test = true;
        try {
            writer.readText(inputFilename);
            writer.writeText(outputFilename, length);
        }
        catch (Exception e) {
            System.err.println("There is an error in the program. " + e);
            System.exit(1);
        }
    }

}
