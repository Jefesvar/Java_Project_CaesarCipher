package CG.CaesarCipher;
import java.io.File;

public class Validator {
    public  boolean key(int key){
        return 1 <= key && key <= 30;
    }

    public boolean file(String filePath) {
        File file = new File(filePath);
        return file.canRead() && file.canWrite();
    }
}
