package CG.CaesarCipher;

public class Cipher {

    private final char[] alphabet;
    private char[] newAlphabet;


    public Cipher(char[] alphabet, int shift) {
        this.alphabet = alphabet;
        creaNewAlphabet(shift);
    }

    public String[] arrayEncrypt(String[] arrayText){
        String[] arrayTextEncrypted = new String[arrayText.length];
        for(int i=0 ; i<arrayText.length ; i++) {
            arrayTextEncrypted[i] = encrypt(arrayText[i].toLowerCase());
        }
        return arrayTextEncrypted;
    }

    public String encrypt(String text) {


        char[] oldChars = text.toCharArray();
        char[] newChars = new char[text.length()];
        for (int i = 0; i <= oldChars.length - 1; i++) {
            for (int j = 0; j <= alphabet.length - 1; j++) {
                if (oldChars[i] == alphabet[j]) {
                    newChars[i] = newAlphabet[j];
                    break;
                }
            }
        }
        return String.valueOf(newChars);
    }


    public String[] arrayDecrypt(String[] arrayText){
        String[] arrayTextDecrypted = new String[arrayText.length];
        for(int i=0 ; i<arrayText.length ; i++) {
            arrayTextDecrypted[i] = decrypt(arrayText[i].toLowerCase());
        }
        return arrayTextDecrypted;
    }

    public String decrypt(String encryptedText) {


        char[] oldChars = encryptedText.toCharArray();
        char[] newChars = new char[encryptedText.length()];
        for (int i = 0; i <= oldChars.length - 1; i++) {
            for (int j = 0; j <= newAlphabet.length - 1; j++) {
                if (oldChars[i] == newAlphabet[j]) {
                    newChars[i] = alphabet[j];
                    break;
                }
            }
        }
        return String.valueOf(newChars);
    }

    private void creaNewAlphabet(int shift) {
        newAlphabet = new char[alphabet.length];
        for (int i = 0; i <= alphabet.length - 1; i++) {
            if (i + shift >= alphabet.length) {
                newAlphabet[i] = alphabet[i + shift - alphabet.length];
            } else {
                newAlphabet[i] = alphabet[i + shift];
            }
        }
    }

}
