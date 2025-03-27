package CG.CaesarCipher;

public class BruteForce {

    public int bruteKey = -1;


    public BruteForce(String[] sampleLines, String[] diccionary,char[] alphabet){
        String[][] stringLinesDecrypted = new String[alphabet.length][];
        stringLinesDecrypted[0] = sampleLines;
        for (int i=1 ; i<alphabet.length ; i++){
            Cipher cipher = new Cipher(alphabet,i);
            stringLinesDecrypted[i] = cipher.arrayDecrypt(sampleLines);
        }

        int maxWordCountKey = -1;
        int maxWordCount = 0;
        for (int i=0 ; i<stringLinesDecrypted.length ; i++){
            int wordCount=0;
            for (String line: stringLinesDecrypted[i]){
                line = line.toLowerCase();
                String[] words = line.split(" ");
                for(String word: words){
                    for (String dictionaryWord: diccionary){
                        if(word.equals(dictionaryWord)){
                            wordCount++;
                        }
                    }

                }
            }
            if(maxWordCount<wordCount){
                maxWordCount=wordCount;
                maxWordCountKey=i;
            }
        }
        if(maxWordCountKey!=-1){
            bruteKey =maxWordCountKey;
        }
    }
}
