package CG.CaesarCipher;
import java.io.File;

public class Validator {
    public  boolean keyValidation(int key){
        return 1 <= key && key <= 30;
    }


    public boolean fileValidation(String filePath) {
        File file = new File(filePath);
        return file.canRead() && file.canWrite();
    }
}
