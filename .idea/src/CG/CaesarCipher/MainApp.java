package CG.CaesarCipher;


import java.io.FileNotFoundException;
import java.io.IOException;

public class MainApp {


    public static final char[] ALPHABET = "abcdefghijklmnopqrstvwxyz .,:?!".toCharArray();
    public static final String RUTA = "C:\\Users\\jefes\\IdeaProjects\\Java_Project_Cyber_Caesar\\.idea\\src\\CG\\CaesarCipher\\";

    public static final Menu menu = new Menu();

    public static void main(String[] args) throws IOException {

        // programa

        while (true){
            menu.menuPrincipal();

            switch (menu.numSelector()){
                case 1:
                    System.out.println("\n- CIFRAR -");

                    //Valida Key y File

                    if(validarFileKey()){continue;};

                    //Prepara archivos para leer, (encriptar o desencriptar) y guardar

                    encryptOrDencrypt("encrypt");

                    continue;

                case 2:

                    System.out.println("\n- DESCIFRAR -");

                    if(validarFileKey()){continue;};

                    //Prepara archivos para leer y guardar

                    encryptOrDencrypt("dencrypt");


                    continue;
                case 3:
                    menu.close();
                    break;
                default:
                    menu.noValido();
                    continue;
            }
            break;
        }

    }

    public static boolean validarFileKey() throws FileNotFoundException {
        Validator validator = new Validator();
        if(!validator.file(RUTA + menu.pathFile())){   menu.pathFileInvalido(); return true;  }
        if(!validator.key(menu.key(),ALPHABET)){    menu.keyInvalido(); return true;   }
        return false;
    }

    public static void encryptOrDencrypt(String process) throws IOException {
        FileManager fileManager = new FileManager(RUTA + menu.pathFile);
        menu.saveFile();
        fileManager.saveFile(RUTA + menu.saveFile + ".txt");

        //Lee, Encripta y Guarda

        Cipher cipher = new Cipher(ALPHABET);

        String line;
        while ((line = fileManager.readFile()) != null){
            switch (process){
                case "encrypt":
                    line = cipher.encrypt(line, menu.key);
                    fileManager.writeFile(line);
                    continue;
                case "dencrypt":
                    line = cipher.dencrypt(line, menu.key);
                    fileManager.writeFile(line);
                    continue;
            }

        }
        fileManager.close();
    }



}
