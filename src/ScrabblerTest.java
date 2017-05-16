import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class ScrabblerTest {
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        final Scanner input = new Scanner(System.in);
        try {
            final Scanner fileInput = new Scanner(new FileReader("words.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

//        System.setIn("abcdefg");
        Scrabbler.main(args);
//        System.setIn(original);
    }

}