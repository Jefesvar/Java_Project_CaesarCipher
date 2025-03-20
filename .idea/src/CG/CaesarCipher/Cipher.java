package CG.CaesarCipher;

public class Cipher {

    private char[] alphabet;
    private char[] newAlphabet;

    public Cipher(char[] alphabet){
        this.alphabet = alphabet;
    }

    public String encrypt(String text, int shift){

        creaNewAlphabet(shift);

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

    public String dencrypt(String encryptedText, int shift){

        creaNewAlphabet(shift);

        char[] oldChars = encryptedText.toCharArray();
        char[] newChars = new char[encryptedText.length()];
        for(int i=0 ; i <= oldChars.length-1; i++){
            for(int j=0; j <= newAlphabet.length-1 ; j++){
                if(oldChars[i] == newAlphabet[j]){
                    newChars[i]=alphabet[j];
                    break;
                }
            }
        }
        return String.valueOf(newChars);
    }

    private void creaNewAlphabet(int shift){
        newAlphabet = new char[alphabet.length];
        for (int i = 0 ; i <= alphabet.length-1 ; i++){
            if(i+shift >= alphabet.length){
                newAlphabet[i]=alphabet[i+shift-alphabet.length];
            }
            else{
                newAlphabet[i]=alphabet[i+shift];
            }
        }
    }

}
