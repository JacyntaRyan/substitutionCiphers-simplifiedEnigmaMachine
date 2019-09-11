//Jacynta Ryan
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class RotatingCipher extends SubstitutionCipher implements Cipher {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    private LinkedList<Character> cipherKey = new LinkedList();

    public RotatingCipher(String key) {

        for (char ch : key.toCharArray()) {
            cipherKey.add(ch);
        }
    }

    public char encode(char ch) {
        //checks if character is a letter if it is checks if its upper or lower case 
// if its not a letter it is returned without encryption
        if (Character.isLetter(ch)) {
            //if char is uppercase it changes it to lower case finds its new char and returns in uppercase
            if (Character.isUpperCase(ch)) {

                ch = Character.toLowerCase(ch);
                int index = ALPHABET.indexOf(ch);
                ch = cipherKey.get(index);
                ch = Character.toUpperCase(ch);
                rotate();
                return ch;
            }
            //if char is not upper case, finds its new char and returns it
            int index = ALPHABET.indexOf(ch);
            ch = cipherKey.get(index);
            rotate();
            return ch;
        }
        rotate();
        return ch;
    }

    public char decode(char ch) {
        if (Character.isLetter(ch)) {
            int index = 0;
            if (Character.isUpperCase(ch)) {
                ch = Character.toLowerCase(ch);
                for (int i = 0; i < cipherKey.size(); i++) {
                    char cipher = cipherKey.get(i);

                    if (cipher == ch) {
                        index = i;
                    }
                }

                ch = ALPHABET.charAt(index);
                ch = Character.toUpperCase(ch);
                rotate();
                return ch;
            }
            for (int i = 0; i < cipherKey.size(); i++) {
                char cipher = cipherKey.get(i);

                if (cipher == ch) {
                    index = i;
                }
            }

            ch = ALPHABET.charAt(index);

           rotate();
            return ch;
        }
        rotate();
        return ch;
    }

    private void rotate() {
        //i save the char at the first position in the list
        //i then delete it and add it to the end
        //the indexes automatically shift in a linked list(thats why I chose it over an array)
        char start = cipherKey.getFirst();
        int i = 0;
        cipherKey.remove(0);
        //int size = cipherKey.size() - 1;
        cipherKey.addLast(start);
    }

}
