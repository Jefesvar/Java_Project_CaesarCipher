package CG.CaesarCipher;
import java.io.File;

public class Validator {
    public  boolean key(int key, char[] alphabet){
        boolean validKey = 1 <= key && key <= 31;
        return validKey;
    }

    public boolean file(String filePath){
        File file = new File(filePath);
        System.out.println(filePath);
        boolean fileExist = file.canRead() && file.canWrite();
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        return fileExist;
    }
}
