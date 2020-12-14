public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> deque = new ArrayDeque<>();
        int i = 0;
        int j = word.length();
        while (i < j) {
            deque.addLast(word.charAt(i));
            i++;
        }
        return deque;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> deque = wordToDeque(word);
        return isPalindromeHelper(deque);
    }

    //use recursion to find Palindrome
    private boolean isPalindromeHelper(Deque<Character> deque) {
        if (deque.size() == 0 || deque.size() == 1) {
            return true;
        } else if (deque.removeFirst() == deque.removeLast()) {
            return isPalindromeHelper(deque);
        }
        return false;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> deque = wordToDeque(word);
        return isPalindromeHelper(deque, cc);
    }

    private boolean isPalindromeHelper(Deque<Character> deque, CharacterComparator cc) {
        if (deque.size() == 0 || deque.size() == 1) {
            return true;
        } else if (cc.equalChars(deque.removeFirst(), deque.removeLast())) {
            return isPalindromeHelper(deque, cc);
        }
        return false;
    }

}
