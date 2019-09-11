// Jacynta Ryan
//this is pretty much the same as the caesar cipher except
//I read in the string for the Shifted letters
public class SubstitutionCipher implements Cipher{
	
	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
        String SHIFTED = "";
	protected SubstitutionCipher(){
		
	}
	
	public SubstitutionCipher(String key) {
            this.SHIFTED = key;
	}

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
