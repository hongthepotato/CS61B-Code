import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static OffByOne offByOne = new OffByOne();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome(){
        assertTrue(palindrome.isPalindrome("racecar"));
        assertFalse(palindrome.isPalindrome("thisispalindrome"));
        assertTrue(palindrome.isPalindrome("Repaper"));
        assertTrue(palindrome.isPalindrome("Redrumsirismurder"));
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("a"));
    }


    @Test
    public void testOverloadIsPalindrome() {
        boolean result = palindrome.isPalindrome("flake", offByOne);
        assertTrue(palindrome.isPalindrome("flake", offByOne));
        assertTrue(palindrome.isPalindrome("aa", offByOne));
        assertTrue(palindrome.isPalindrome("FlaKE", offByOne));
        assertTrue(palindrome.isPalindrome("%6&", offByOne));
    }

}
//Uncomment this class once you've created your Palindrome class.