package CG.CaesarCipher;
import java.io.*;

public class FileManager {

    BufferedReader bufferedReader;
    BufferedWriter bufferedWriter;

    public FileManager(String filePath){
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String readLineFile() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void prepareBufferWriter(String filePath) {
        try {
            bufferedWriter =
                    new BufferedWriter(new FileWriter(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public  void  writeFile(String content)  {
        try {
            bufferedWriter.write(content+"\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {
        try {
            bufferedReader.close();
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
