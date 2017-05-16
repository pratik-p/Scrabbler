import java.util.Scanner;

/**
 * Main
 *
 * @author Pratik Patel
 * @version 1
 */
public class Main {

    /**
     * Main method
     *
     * @param args String array
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scrabbler test = new Scrabbler(input);
        test.start();
    }
}
