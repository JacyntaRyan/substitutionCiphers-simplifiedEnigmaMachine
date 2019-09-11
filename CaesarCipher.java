
/**
 * Class that encodes and decodes individual characters using the "Caesar
 * cipher".
 *Jacynta Ryan
 */
public class CaesarCipher implements Cipher {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final String SHIFTED = "defghijklmnopqrstuvwxyzabc";

    /**
     * Constructs a Cipher object.
     */
    public CaesarCipher() {
    }

    /**
     * Encodes a single character.
     *
     * @param ch the character to be encoded
     * @return the character three later in the alphabet, with wrap-around
     */
    public char encode(char ch) {
//checks if character is a letter if it is checks if its upper or lower case 
// if its not a letter it is returned without encryption
        if (Character.isLetter(ch)) {
            //if char is uppercase it changes it to lower case finds its new char and returns in uppercase
            if (Character.isUpperCase(ch)) {
                
                ch = Character.toLowerCase(ch);
                int index = ALPHABET.indexOf(ch);
                ch = SHIFTED.charAt(index);
                return Character.toUpperCase(ch);

            }
            //if char is not upper case, finds its new char and returns it
            int index = ALPHABET.indexOf(ch);
            return ch = SHIFTED.charAt(index);

        }
        return ch;
    }

    /**
     * Decodes a single character.
     *
     * @param ch the character to be decoded
     * @return the character three earlier in the alphabet, with wrap-around
     */
    public char decode(char ch) {
        if (Character.isLetter(ch)) {

            if (Character.isUpperCase(ch)) {
                ch = Character.toLowerCase(ch);
                int index = SHIFTED.indexOf(ch);
                ch = ALPHABET.charAt(index);
                return Character.toUpperCase(ch);

            }

            int index = SHIFTED.indexOf(ch);
            return ch = ALPHABET.charAt(index);

        }
        return ch;
    }
}
