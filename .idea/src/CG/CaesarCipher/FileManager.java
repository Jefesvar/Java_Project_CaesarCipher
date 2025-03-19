package CG.CaesarCipher;
import java.io.*;

public class FileManager {

    File file;
    FileReader fileReader;
    BufferedReader bufferedReader;

    public boolean activo = false;

    public FileManager(String filePath) throws FileNotFoundException {
        file = new File(filePath);
        fileReader = new FileReader(file);
        bufferedReader = new BufferedReader(fileReader);
    }

    public String readFile() throws IOException {
        return bufferedReader.readLine();
    }

    public  void  writeFile(String content, String filePath){

    }

}
