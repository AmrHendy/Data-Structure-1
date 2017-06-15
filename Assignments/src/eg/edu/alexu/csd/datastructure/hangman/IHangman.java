package eg.edu.alexu.csd.datastructure.hangman;
/**
 *
 * @author amrmh_000
 *
 */
public interface IHangman {

    /**
     * @param words String
     */
    void setDictionary(String[] words);

    /**
     * @return "String"
     */
    String selectRandomSecretWord();

    /**
     * @param c char
     * @return "String"
     */
    String guess(Character c);

    /**
     * @param max max wrong guesses
     */
    void setMaxWrongGuesses(Integer max);

}
