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

        while (true){
            menu.menuPrincipal();

            switch (menu.numSelector()){
                case 1:
                    System.out.println("- CIFRAR -");

                    //Valida Key y File

                    Validator validator = new Validator();
                    if(!validator.file(RUTA + menu.pathFile())){   menu.pathFileInvalido();continue;  }
                    if(!validator.key(menu.key(),ALPHABET)){    menu.keyInvalido();continue;   }

                    //Prepara archivos para leer y guardar

                    FileManager fileManager = new FileManager(RUTA + menu.pathFile);
                    menu.saveFile();
                    fileManager.saveFile(RUTA + menu.saveFile + ".txt");

                    //Lee, Encripta y Guarda

                    String line;
                    while ((line = fileManager.readFile()) != null){
                        line = cipher.encrypt(line, menu.key);
                        fileManager.writeFile(line);
                    }
                    fileManager.close();
                    continue;

                case 2:

                    Validator validator2 = new Validator();
                    if(!validator2.file(RUTA + menu.pathFile())){   menu.pathFileInvalido();continue;  }
                    if(!validator2.key(menu.key(),ALPHABET)){    menu.keyInvalido();continue;   }

                    //Prepara archivos para leer y guardar

                    FileManager fileManager2 = new FileManager(RUTA + menu.pathFile);
                    menu.saveFile();
                    fileManager2.saveFile(RUTA + menu.saveFile + ".txt");

                    //Lee, Encripta y Guarda

                    String line2;
                    while ((line2 = fileManager2.readFile()) != null){
                        line = cipher.dencrypt(line2, menu.key);
                        fileManager2.writeFile(line);
                    }
                    fileManager2.close();
                    continue;
                case 3:
                    menu.close();
                    break;
                default:
                    menu.noValido();
                    continue;
            }

        }

    }







}
