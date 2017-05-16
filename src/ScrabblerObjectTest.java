import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class ScrabblerObjectTest {
    @Test
    public void testStart() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        Scanner input = new Scanner("ball");
        ScrabblerObject test = new ScrabblerObject(input);
        test.start();

        String actual = baos.toString();
        String expected = "Please enter a string of letters, or start your search with \"--prefix\"/\"--suffix\" " +
                "followed by " +
                "letters. \n" +
                "Enter \"Ctrl + c\" or \"/quit\" to exit: alb\nall\nball\nla\nlab\nPlease enter a string of letters, " +
                "or start your search with \"--prefix\"/\"--suffix\" followed by letters. \n" +
                "Enter \"Ctrl + c\" or \"/quit\" to exit: \n" +
                "Quit.\n";
        assertEquals(expected, actual);

    }

    @Test
    public void testStartPrefix() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        Scanner input = new Scanner("--prefix fi");
        ScrabblerObject test = new ScrabblerObject(input);
        test.start();

        String actual = baos.toString();

        // from words.txt
        String fi = "fiance\nfiancee\nfiancees\nfiances\nfiasco\nfiascoes\nfiascos\nfiat\nfiats\nfib" +
                "\nfibbed\nfibber\nfibbers\nfibbing\nfiber\nfiberboard\nfiberglass\nfibers\nfibroid\nfibrous\nfibs" +
                "\nfibula\nfibulae\nfibulas\nfiche\nfiches\nfickle\nfickleness\nfickler\nficklest\nfiction\nfictional" +
                "\nfictionalize\nfictionalized\nfictionalizes\nfictionalizing\nfictions\nfictitious\nfiddle\nfiddled" +
                "\nfiddler\nfiddlers\nfiddles\nfiddlesticks\nfiddling\nfiddly\nfidelity\nfidget\nfidgeted\nfidgeting" +
                "\nfidgets\nfidgety\nfiduciaries\nfiduciary\nfie\nfief\nfiefs\nfield\nfielded\nfielder\nfielders" +
                "\nfielding\nfields\nfieldwork\nfiend\nfiendish\nfiendishly\nfiends\nfierce\nfiercely\nfierceness" +
                "\nfiercer\nfiercest\nfierier\nfieriest\nfieriness\nfiery\nfiesta\nfiestas\nfife\nfifes\nfifteen" +
                "\nfifteens\nfifteenth\nfifteenths\nfifth\nfifths\nfifties\nfiftieth\nfiftieths\nfifty\nfig\nfight" +
                "\nfighter\nfighters\nfighting\nfights\nfigment\nfigments\nfigs\nfigurative\nfiguratively\nfigure" +
                "\nfigured\nfigurehead\nfigureheads\nfigures\nfigurine\nfigurines\nfiguring\nfilament\nfilamentous" +
                "\nfilaments\nfilbert\nfilberts\nfilch\nfilched\nfilches\nfilching\nfile\nfiled\nfiles\nfilet\nfilets" +
                "\nfilial\nfilibuster\nfilibustered\nfilibustering\nfilibusters\nfiligree\nfiligreed\nfiligreeing" +
                "\nfiligrees\nfiling\nfilings\nfill\nfilled\nfiller\nfillers\nfillet\nfilleted\nfilleting\nfillets" +
                "\nfillies\nfilling\nfillings\nfillip\nfilliped\nfilliping\nfillips\nfills\nfilly\nfilm\nfilmed" +
                "\nfilmier\nfilmiest\nfilming\nfilmmaker\nfilmmakers\nfilms\nfilmstrip\nfilmstrips\nfilmy\nfilter" +
                "\nfilterable\nfiltered\nfiltering\nfilters\nfilth\nfilthier\nfilthiest\nfilthiness\nfilthy" +
                "\nfiltrable\nfiltrate\nfiltrated\nfiltrates\nfiltrating\nfiltration\nfin\nfinagle\nfinagled" +
                "\nfinagler\nfinaglers\nfinagles\nfinagling\nfinal\nfinale\nfinales\nfinalist\nfinalists\nfinality" +
                "\nfinalize\nfinalized\nfinalizes\nfinalizing\nfinally\nfinals\nfinance\nfinanced\nfinances" +
                "\nfinancial\nfinancially\nfinancier\nfinanciers\nfinancing\nfinch\nfinches\nfind\nfinder\nfinders" +
                "\nfinding\nfindings\nfinds\nfine\nfined\nfinely\nfineness\nfiner\nfinery\nfines\nfinesse\nfinessed" +
                "\nfinesses\nfinessing\nfinest\nfinger\nfingerboard\nfingerboards\nfingered\nfingering\nfingerings" +
                "\nfingernail\nfingernails\nfingerprint\nfingerprinted\nfingerprinting\nfingerprints\nfingers" +
                "\nfingertip\nfingertips\nfinickier\nfinickiest\nfinicky\nfining\nfinis\nfinises\nfinish\nfinished" +
                "\nfinisher\nfinishers\nfinishes\nfinishing\nfinite\nfinitely\nfink\nfinked\nfinking\nfinks\nfinnier" +
                "\nfinniest\nfinny\nfins\nfiord\nfiords\nfir\nfire\nfirearm\nfirearms\nfireball\nfireballs\nfirebomb" +
                "\nfirebombed\nfirebombing\nfirebombs\nfirebrand\nfirebrands\nfirebreak\nfirebreaks\nfirebug" +
                "\nfirebugs\nfirecracker\nfirecrackers\nfired\nfirefight\nfirefighter\nfirefighters\nfirefighting" +
                "\nfirefights\nfireflies\nfirefly\nfirehouse\nfirehouses\nfireman\nfiremen\nfireplace\nfireplaces" +
                "\nfireplug\nfireplugs\nfirepower\nfireproof\nfireproofed\nfireproofing\nfireproofs\nfires\nfireside" +
                "\nfiresides\nfirestorm\nfirestorms\nfiretrap\nfiretraps\nfirewall\nfirewalls\nfirewater\nfirewood" +
                "\nfirework\nfireworks\nfiring\nfirm\nfirmament\nfirmaments\nfirmed\nfirmer\nfirmest\nfirming\nfirmly" +
                "\nfirmness\nfirms\nfirmware\nfirs\nfirst\nfirstborn\nfirstborns\nfirsthand\nfirstly\nfirsts\nfirth" +
                "\nfirths\nfiscal\nfiscally\nfiscals\nfish\nfishbowl\nfishbowls\nfished\nfisher\nfisheries\nfisherman" +
                "\nfishermen\nfishers\nfishery\nfishes\nfishhook\nfishhooks\nfishier\nfishiest\nfishing\nfishnet" +
                "\nfishnets\nfishtail\nfishtailed\nfishtailing\nfishtails\nfishwife\nfishwives\nfishy\nfission" +
                "\nfissure\nfissures\nfist\nfistful\nfistfuls\nfisticuffs\nfists\nfit\nfitful\nfitfully\nfitly" +
                "\nfitness\nfits\nfitted\nfitter\nfitters\nfittest\nfitting\nfittingly\nfittings\nfive\nfiver\nfives" +
                "\nfix\nfixable\nfixate\nfixated\nfixates\nfixating\nfixation\nfixations\nfixative\nfixatives\nfixed" +
                "\nfixedly\nfixer\nfixers\nfixes\nfixing\nfixings\nfixity\nfixture\nfixtures\nfizz\nfizzed\nfizzes" +
                "\nfizzier\nfizziest\nfizzing\nfizzle\nfizzled\nfizzles\nfizzling\nfizzy\n";

        String expected = "Please enter a string of letters, or start your search with \"--prefix\"/\"--suffix\" " +
                "followed by " +
                "letters. \n" +
                "Enter \"Ctrl + c\" or \"/quit\" to exit: " + fi + "Please enter a string of letters, " +
                "or start your search with \"--prefix\"/\"--suffix\" followed by letters. \n" +
                "Enter \"Ctrl + c\" or \"/quit\" to exit: \n" +
                "Quit.\n";
//        if ((expected.equals(actual))) {
//            assertTrue(true);
//        } else {
//            fail("");
//        }

        assertEquals(expected, actual);
    }

    @Test
    public void testStartSuffix() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        Scanner input = new Scanner("--suffix edge");
        ScrabblerObject test = new ScrabblerObject(input);
        test.start();

        String actual = baos.toString();

        // found in words.txt using notepad++ find function
        String edge = "acknowledge\ndredge\nedge\nforeknowledge\nhedge\nknowledge\nledge\npledge\nsedge\nselvedge" +
                "\nsledge\nstraightedge\nwedge\n";
        String expected = "Please enter a string of letters, or start your search with \"--prefix\"/\"--suffix\" " +
                "followed by " +
                "letters. \n" +
                "Enter \"Ctrl + c\" or \"/quit\" to exit: " + edge + "Please enter a string of letters, " +
                "or start your search with \"--prefix\"/\"--suffix\" followed by letters. \n" +
                "Enter \"Ctrl + c\" or \"/quit\" to exit: \n" +
                "Quit.\n";
        assertEquals(expected, actual);
    }

    @Test
    public void testQuit() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        Scanner input = new Scanner("/quit");
        ScrabblerObject test = new ScrabblerObject(input);
        test.start();

        String actual = baos.toString();

        String expected = "Please enter a string of letters, or start your search with \"--prefix\"/\"--suffix\" " +
                "followed by letters. \n" +
                "Enter \"Ctrl + c\" or \"/quit\" to exit: Quit.\n";

        String expectedWrong = "Please enter a string of letters, or start your search with \"--prefix\"/\"--suffix\"" +
                " " +
                "followed by " +
                "letters. \n" +
                "Enter \"Ctrl + c\" or \"/quit\" to exit: " + "it\nquit\nti\n" + "Please enter a string of letters, " +
                "or start your search with \"--prefix\"/\"--suffix\" followed by letters. \n" +
                "Enter \"Ctrl + c\" or \"/quit\" to exit: \n" +
                "Quit.\n";

        assertEquals(expected, actual);
        if (expectedWrong.equals(actual)) {
            fail("unexpected /quit message");
        }
    }
}