public class Palindrome {
    /**
     * Function: wordToDeque
     * @param word
     * @return A deque composed of one word given where the characters appear in
     * the same order.
     */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> dequeOfChar = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); ++i){
            dequeOfChar.addLast(word.charAt(i));
        }
        return dequeOfChar;
    }

    /**
     * Function: isPalindrome
     * @param word
     * @return "True" for a given word that is palindrome (a word that is the same whether
     * it is read forward or backward), "False" otherwise.
     */
    public boolean isPalindrome(String word) {
        String wordLowerCase = word.toLowerCase();
        Deque<Character> charOfWords= new LinkedListDeque<Character>();
        charOfWords = wordToDeque(wordLowerCase);
        for (int i = 0; i < charOfWords.size()/2; ++i) {
            if (charOfWords.get(i) != charOfWords.get(charOfWords.size() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
    // NOTE: the implementation above is rather slow for long word, a more efficient way is needed!
    // The 'get' method in the loop is O(N), thus, the total algorithm is O(N^2) which is not acceptable!


    public boolean isPalindrome(String word, CharacterComparator cc) {
        String wordOfLowCase = word.toLowerCase();
        for (int i = 0; i < wordOfLowCase.length() / 2; ++i) {
            if (wordOfLowCase.charAt(i) != wordOfLowCase.charAt(word.length() - 1 - i) && !cc.equalChars(wordOfLowCase.charAt(i), wordOfLowCase.charAt(word.length() - i - 1))) {
                return false;
            }
        }
        return true;
    }
}
