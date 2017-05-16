import java.util.Scanner;

/**
 * Scrabbler
 *
 * @author Pratik Patel
 * @version 1
 */
public class Scrabbler {

    /**
     * Main method
     *
     * @param args String array
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ScrabblerObject test = new ScrabblerObject(input);
        test.start();
    }
}
