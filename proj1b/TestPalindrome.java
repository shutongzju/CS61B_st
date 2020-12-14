import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator cc = new OffByOne();

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
    public void testisPalindrome() {
        String a1 = "";
        String a2 = "T";
        String a3 = "public";
        String a4 = "Aa";
        String a5 = "AAa";
        String a6 = "testbytest";
        String a7 = "chaosoahc";

        String a8 = "acb";
        String a9 = "accb";

        assertTrue(palindrome.isPalindrome(a1));
        assertTrue(palindrome.isPalindrome(a2));
        assertFalse(palindrome.isPalindrome(a3));
        assertFalse(palindrome.isPalindrome(a4));
        assertFalse(palindrome.isPalindrome(a5));
        assertFalse(palindrome.isPalindrome(a6));
        assertTrue(palindrome.isPalindrome(a7));

        assertTrue(palindrome.isPalindrome(a1, cc));
        assertTrue(palindrome.isPalindrome(a2, cc));
        assertFalse(palindrome.isPalindrome(a3, cc));
        assertFalse(palindrome.isPalindrome(a4, cc));
        assertFalse(palindrome.isPalindrome(a5, cc));
        assertTrue(palindrome.isPalindrome(a8, cc));
        assertFalse(palindrome.isPalindrome(a9, cc));
    }


}
