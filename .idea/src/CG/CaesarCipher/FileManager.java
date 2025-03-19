package CG.CaesarCipher;
import java.io.*;

public class FileManager {

    BufferedReader bufferedReader;
    BufferedWriter bufferedWriter;

    public boolean activo = false;

    public FileManager(String filePath) throws FileNotFoundException {
        bufferedReader = new BufferedReader(new FileReader(filePath));
    }

    public String readFile() throws IOException {
        return bufferedReader.readLine();
    }

    public void saveFile(String filePath) throws IOException {
        bufferedWriter =
                new BufferedWriter(new FileWriter(filePath));
    }

    public  void  writeFile(String content) throws IOException {
        bufferedWriter.write(content+"\n");
    }

    public void close() throws IOException {
        bufferedReader.close();
        bufferedWriter.close();
    }

}
