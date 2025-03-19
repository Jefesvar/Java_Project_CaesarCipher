package CG.CaesarCipher;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Validator {
    public  boolean key(int key, char[] alphabet){
        boolean validKey = 1 <= key && key <= 31;
        return validKey;
    }

    public boolean file(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        boolean fileExist = file.canRead() && file.canWrite();
        return fileExist;
    }
}
