
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringReader;

public class Encrypter {

    Cipher cipher = null;

    public Encrypter(Cipher cipher) {
        this.cipher = cipher;
    }

    public void encrypt(String input) {
        encrypt(input, null);
    }

    public void encrypt(String input, String outFile) {
        File file = new File(input);
        BufferedReader br = null;
        boolean printToFile = false;

        PrintStream out = System.out;
        PrintStream fout = null;

        try {
            if (file.exists() && !file.isDirectory()) {
                br = new BufferedReader(new FileReader(file));
            } else {
                br = new BufferedReader(new StringReader(input));
            }

            if (outFile != null) {
                printToFile = true;
                fout = new PrintStream(outFile);
            }

            char ch;
            int c;
            // Read each char until EOL or EOF
            while ((c = br.read()) != -1) {
                // Encrypt it and print out
                ch = (char) c;
                ch = cipher.encode(ch);
                out.print(ch);
                if (printToFile) {
                    fout.print(ch);
                }
            }
            if (br != null) {
                br.close();
            }
            if (printToFile) {
                fout.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String path = "C:\\Users\\Jacynta\\Documents\\Data structures and algorithms\\Assignment 2 Starter Code\\";
       // Encrypter enc = new Encrypter(new Enigma("#GNUAHOVBIPWCJQXDKRYELSZFMT", "#EJOTYCHMRWAFKPUZDINSXBGLQV"));
        //Encrypter enc = new Encrypter(new RotatingCipher("qwertyuiopasdfghjklzxcvbnm"));
        Encrypter enc = new Encrypter(new CaesarCipher());
        //Encrypter enc = new Encrypter(new SubstitutionCipher("qwertyuiopasdfghjklzxcvbnm"));
        //enc.encrypt(path + "inTest.txt", path + "inTest.txt.enc");
        enc.encrypt("CONGRATULATIONS YOU GOT IT");
        /*enc.encrypt("The provided CaesarCipher class contains a partial implementation of the Caesar cipher."
         + " The encode and decode methods can be used to encode and decode lower-case letters by shifting"
         + " them three positions in the alphabet. Modify these methods so that they");
         */

    }
}
