package CG.CaesarCipher;

public class Cipher {

    private char[] alphabet;

    public Cipher(char[] alphabet){
        this.alphabet = alphabet;
    }

    public String encrypt(String text, int shift){
        char[] newAlphabet = new char[alphabet.length];
        for (int i = 0 ; i <= alphabet.length-1 ; i++){
            if(i+shift >= alphabet.length){
                newAlphabet[i]=alphabet[i+shift-alphabet.length];
            }
            else{
                newAlphabet[i]=alphabet[i+shift];
            }
        }

        char[] oldChars = text.toCharArray();
        char[] newChars = new char[text.length()];
        for(int i=0 ; i <= oldChars.length-1; i++){
            for(int j=0; j <= alphabet.length-1 ; j++){
                if(oldChars[i] == alphabet[j]){
                    newChars[i]=newAlphabet[j];
                    break;
                }
            }
        }
        return String.valueOf(newChars);
    }

    public String descrypt(String encryptedText, int shift){
        String decryptedText = "";
        return decryptedText;
    }


}
