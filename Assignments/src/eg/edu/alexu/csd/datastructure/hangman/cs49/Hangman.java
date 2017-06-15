package eg.edu.alexu.csd.datastructure.hangman.cs49;

import java.util.Random;

import eg.edu.alexu.csd.datastructure.hangman.IHangman;
/** * class. */
public class Hangman implements IHangman {

    /** * c. */
    int n;
    /** * dictionary. */
    String[] dictionary;
    /** * index. */
    int indexOfWord;
    /** * maxWrongGuess. */
    int maxOfWrong = 0;
    /** * secretWord. */
    String secretWord;
    /** * answer. */
    char[] answer;

    /**
     * @param words String
     */
    public final void setDictionary(final String[] words) {
        dictionary = new String[words.length];
        System.arraycopy(words, 0, dictionary, 0, words.length);
    }

    /**
     * @return "String"
     */
    public final String selectRandomSecretWord() {

        Random secret;
        secret = new Random();

        // important ==> to avoid NullPointerExpection to avoid access null
        // address or memory
        if (dictionary == null) {
            secretWord = null;
            return null;
        }

        if (dictionary.length == 0) {
            secretWord = null;
            return null;
        }

        indexOfWord = secret.nextInt(dictionary.length);
        secretWord = dictionary[indexOfWord];
        answer = new char[secretWord.length()];

        for (int i = 0; i < secretWord.length(); i++) {
            answer[i] = '-';
        }

        return secretWord;
    }

    /**
     * @param c char
     * @return "String"
     */
    public final String guess(final Character c) {

        boolean correct = false;
        Character b = c;
        if (secretWord == null) {
            return null;
        }

        if (c != null) {

            if ((secretWord.toCharArray()[0] <= 'z')
                    && (secretWord.toCharArray()[0] >= 'a')) {
                b = b.toLowerCase(b);
            } else if ((secretWord.toCharArray()[0] <= 'Z')
                    && (secretWord.toCharArray()[0] >= 'A')) {
                b = b.toUpperCase(b);
            }

        }

        for (int i = 0; (b != null) && (i < secretWord.length())
                && (maxOfWrong > 0); i++) {
            if (b == secretWord.toCharArray()[i]) {
                if (answer[i] == '-') {
                    answer[i] = b;
                } else {
                    return String.valueOf(answer);
                }

                correct = true;
            }
        }

        if (!correct) {
            maxOfWrong--;
        }

        if (maxOfWrong > 0) {
            return String.valueOf(answer);
        } else {
            return null;
        }

    }

    /**
     * @param max max wrong guesses
     */
    public final void setMaxWrongGuesses(final Integer max) {

        if (max == null) {
            maxOfWrong = 0;
        } else {
            maxOfWrong = max;
        }

    }

}
