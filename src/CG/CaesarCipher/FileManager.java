package CG.CaesarCipher;
import java.io.*;
import java.util.stream.Stream;

public class FileManager {

    BufferedReader bufferedReader;
    BufferedWriter bufferedWriter;

    public FileManager(String filePath, String proccess){
        try {
            switch (proccess){
                case "read":
                    bufferedReader = new BufferedReader(new FileReader(filePath));
                    break;
                case "write":
                    bufferedWriter = new BufferedWriter(new FileWriter(filePath));

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String[] readFileLines(){
        Stream<String> streamLines = bufferedReader.lines();
        return streamLines.toArray(String[]::new);
    }

    public String readLineFile() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void arrayWriteFile(String[] arrayContent){
        for(String content:arrayContent){
            writeFileLine(content);
            try {
                bufferedWriter.newLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void writeFileLine(String content)  {
        try {
            bufferedWriter.write(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {
        try {
            if (bufferedReader!=null) {
                bufferedReader.close();
            }
            if(bufferedWriter!=null){
                bufferedWriter.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
