package CG.CaesarCipher;
import java.io.*;

public class FileManager {

    BufferedReader bufferedReader;

    public boolean activo = false;

    public FileManager(String filePath) throws FileNotFoundException {
        bufferedReader = new BufferedReader(new FileReader(filePath));
    }

    public String readFile() throws IOException {
        return bufferedReader.readLine();
    }

    public  void  writeFile(String content, String filePath){

    }

}
