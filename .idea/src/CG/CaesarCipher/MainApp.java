package CG.CaesarCipher;


import java.io.FileNotFoundException;
import java.io.IOException;

public class MainApp {


    public static final char[] ALPHABET = "abcdefghijklmnopqrstvwxyz .,:?!".toCharArray();

    public static void main(String[] args) throws IOException {

        // inicializar objetos

        Menu menu = new Menu();
        Cipher cipher = new Cipher(ALPHABET);


        // programa

        while (menu.activo){
            menu.menuPrincipal();

            switch (menu.numSelector()){
                case 1:

                    Validator validator = new Validator();
                    if(!validator.file(menu.pathFile())){   menu.pathFileInvalido();continue;  }
                    if(!validator.key(menu.key(),ALPHABET)){    menu.keyInvalido();continue;   }


                    FileManager fileManager = new FileManager(menu.pathFile);
                    String line;
                    while ((line = fileManager.readFile()) != null){
                        System.out.println(line);
                    }


                case 2:
                    menu.close();
                case 3:
                    menu.close();
                default:
                    menu.noValido();
                    continue;
            }

        }

    }






}
