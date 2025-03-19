package CG.CaesarCipher;


import java.io.FileNotFoundException;
import java.io.IOException;

public class MainApp {


    public static final char[] ALPHABET = "abcdefghijklmnopqrstvwxyz .,:?!".toCharArray();
    public static final String RUTA = "C:\\Users\\jefes\\IdeaProjects\\Java_Project_Cyber_Caesar\\.idea\\src\\CG\\CaesarCipher\\";

    public static void main(String[] args) throws IOException {

        // inicializar objetos

        Menu menu = new Menu();
        Cipher cipher = new Cipher(ALPHABET);


        // programa

        while (menu.activo){
            menu.menuPrincipal();

            switch (menu.numSelector()){
                case 1:
                    System.out.println("- CIFRAR -");

                    Validator validator = new Validator();
                    if(!validator.file(RUTA + menu.pathFile())){   menu.pathFileInvalido();continue;  }
                    if(!validator.key(menu.key(),ALPHABET)){    menu.keyInvalido();continue;   }

                    FileManager fileManager = new FileManager(RUTA + menu.pathFile);
                    String line;
                    menu.saveFile();
                    fileManager.saveFile(RUTA + menu.saveFile + ".txt");
                    while ((line = fileManager.readFile()) != null){
                        line = cipher.encrypt(line, menu.key);
                        fileManager.writeFile(line);
                    }
                    fileManager.close();
                    continue;

                case 2:
                    menu.close();
                    continue;
                case 3:
                    menu.close();
                    continue;
                default:
                    menu.noValido();
                    continue;
            }

        }

    }






}
