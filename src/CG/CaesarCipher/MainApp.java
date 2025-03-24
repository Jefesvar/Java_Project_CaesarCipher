package CG.CaesarCipher;


public class MainApp {


    public static final char[] ALPHABET = "abcdefghijklmnopqrstvwxyz .,:?!".toCharArray();
    public static final String PATH = "src/CG/CaesarCipher/";

    public static final Menu menu = new Menu();

    public static void main(String[] args) {

        // programa

        boolean quit = false;
        while (!quit) {
            menu.showPrincipalMenu();

            switch (menu.requestPrincipalMenuSelection()) {
                case 1:
                    System.out.println("\n- CIFRAR -");

                    //Valida Key y File

                    if (!fileAndKeyValidation()) {
                        break;
                    }

                    //Prepara archivos para leer, (encriptar o desencriptar) y guardar

                    encryptOrDecrypt("encrypt");

                    break;


                case 2:

                    System.out.println("\n- DESCIFRAR -");

                    if (!fileAndKeyValidation()) {
                        break;
                    }

                    //Prepara archivos para leer y guardar

                    encryptOrDecrypt("dencrypt");


                    break;
                case 3:
                    menu.close();
                    quit = true;
                    break;
                default:
                    menu.answerToInvalidSelection();
                    break;
            }

        }

    }

    public static boolean fileAndKeyValidation() {
        Validator validator = new Validator();
        if (!validator.fileValidation(PATH + menu.requestPathFile())) {
            menu.answerToInvalidPathFile();
            return false;
        }
        if (!validator.keyValidation(menu.requestKey())) {
            menu.answerToInvalidKey();
            return false;
        }
        return true;
    }

    public static void encryptOrDecrypt(String process) {
        FileManager fileManager = new FileManager(PATH + menu.pathFile);
        menu.requestSaveFileName();
        fileManager.prepareBufferWriter(PATH + menu.writeFile + ".txt");

        //Lee, encriptar o desencriptar y Guarda

        Cipher cipher = new Cipher(ALPHABET, menu.key);

        String line;
        while ((line = fileManager.readLineFile()) != null) {
            switch (process) {
                case "encrypt":
                    line = cipher.encrypt(line);
                    fileManager.writeFile(line);
                    break;
                case "dencrypt":
                    line = cipher.dencrypt(line);
                    fileManager.writeFile(line);
                    break;
            }

        }
        fileManager.close();
    }


}
