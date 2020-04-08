import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    static OffByN offBy0 = new OffByN(0);
    static OffByN offBy1 = new OffByN(1);
    static Palindrome palindrome = new Palindrome();

    /** This set of tests test non-off palindrome */
    @Test
    public void testOffBy0() {
        assertTrue(palindrome.isPalindrome("aa", offBy0));
        assertTrue(palindrome.isPalindrome("a", offBy0));
        assertTrue(palindrome.isPalindrome(" ", offBy0));
    }

    /** This set of tests test offBy1 palindrome*/
    @Test
    public void testOffBy1() {
        boolean result = palindrome.isPalindrome("aa", offBy1);
        assertTrue(palindrome.isPalindrome("adcb", offBy1));
        assertTrue(palindrome.isPalindrome("aa", offBy1));
        assertTrue(palindrome.isPalindrome(" ", offBy1));
        assertTrue(palindrome.isPalindrome("flake", offBy1));
    }
}
