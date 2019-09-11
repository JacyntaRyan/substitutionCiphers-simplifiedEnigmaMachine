//Jacynta Ryan
import java.util.LinkedList;

public class Enigma implements Cipher{
        private static final String OUTERRING = "#BDFHJLNPRTVXZACEGIKMOQSUWY";
        private LinkedList<Character> outerRing = new LinkedList();
        private LinkedList<Character> middleRing = new LinkedList();
        private LinkedList<Character> innerRing = new LinkedList();
        char innerRingStartChar;
        private boolean innerRingTurned = false;
        
    public Enigma(String key1, String key2){
        for (char ch : OUTERRING.toCharArray()) {
            outerRing.add(ch);
        }
        for (char ch : key1.toCharArray()) {
            innerRing.add(ch);
        }
        for (char ch : key2.toCharArray()) {
            middleRing.add(ch);
        }
        innerRingStartChar = innerRing.getLast();
    }

    @Override
    public char encode(char ch){  
        int index =0 ;
          //checks if character is a letter if it is checks if its upper or lower case 
// if its not a letter it is returned without encryption
        if (Character.isLetter(ch)) {
            //get index of char on inner ring
            for (int i = 0; i < innerRing.size(); i++) {
                    char cipher = innerRing.get(i);
                       
                    if (cipher == ch) {
                        index = i;
                    }
                }
            //use the index to get the letter at that position on the outer ring
            char outerChar = outerRing.get(index);
            
            //search the middle ring for the char that was just got on the outer ring save that index
            for (int i = 0; i < middleRing.size(); i++) { 
                char middleChar = middleRing.get(i);
                    if (middleChar == outerChar) {
                        index = i;
                    }
                }
            //the char at the index got from the middle ring is the new character 
            ch = outerRing.get(index);
            //call both rotate methods 
            innerRotate();
            middleRotate();
            return ch;
        }
        //if the char was not a letter rotate anyway and return the non letter
        innerRotate();
        middleRotate();
        return ch;
    }

    @Override
    public char decode(char ch){          
          int index =0 ;
          //checks if character is a letter if it is checks if its upper or lower case 
// if its not a letter it is returned without encryption
        if (Character.isLetter(ch)) {
           
            for (int i = 0; i < outerRing.size(); i++) {
                    char cipher = outerRing.get(i);
                       
                    if (cipher == ch) {
                        index = i;
                        break;
                    }
                }
            char middleChar = middleRing.get(index);
            
            for (int i = 0; i < outerRing.size(); i++) { 
                char outerChar = outerRing.get(i);
                    if (middleChar == outerChar) {
                        index = i;
                    }
                }
            ch = innerRing.get(index);
            innerRotate();
            middleRotate();
            return ch ;
        }
        innerRotate();
        middleRotate();
        return ch ;
    }
    
    private void innerRotate() {
        //save char at the last position of the linked list
        char start = innerRing.getLast();
        //remove last char
        innerRing.remove(innerRing.size()-1);
        //add that last char that was saved in variable start to the start of the linked list
        innerRing.addFirst(start);
    }
    
     private void middleRotate() {
         //i saved the first char in the list at the start of the program, 
         //if that char returns to the first position it has completed 1 full rotation
         //this mean the middle ring must rotate 1.
         //because middleRotate is called every time and the first char i saved
         //is at pos 0 initially i have a boolean set to false 
         // i set a boolean to true the first time this is called so the
         //middle ring doesnt rotate at the start of the program
        if(innerRing.get(0)==innerRingStartChar && innerRingTurned){ 
            char start = middleRing.getLast();
            int i = 0;
            middleRing.remove(middleRing.size()-1);
            //int size = middleRing.size() - 1;
            middleRing.addFirst(start);
        }
        innerRingTurned = true;
    }
}
