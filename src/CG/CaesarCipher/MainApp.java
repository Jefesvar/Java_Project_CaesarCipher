package CG.CaesarCipher;


public class MainApp {


    public static final char[] ALPHABET = "abcdefghijklmnopqrstvwxyz .,:?!".toCharArray();
    public static final String RUTA = "src/CG/CaesarCipher/";

    public static final Menu menu = new Menu();

    public static void main(String[] args) {

        // programa

        boolean salir = false;
        while (!salir) {
            menu.menuPrincipal();

            switch (menu.numSelector()) {
                case 1:
                    System.out.println("\n- CIFRAR -");

                    //Valida Key y File

                    if (validarFileKey()) {
                        break;
                    }

                    //Prepara archivos para leer, (encriptar o desencriptar) y guardar

                    encryptOrDencrypt("encrypt");

                    break;

                case 2:

                    System.out.println("\n- DESCIFRAR -");

                    if (validarFileKey()) {
                        break;
                    }

                    //Prepara archivos para leer y guardar

                    encryptOrDencrypt("dencrypt");


                    break;
                case 3:
                    menu.close();
                    salir = true;
                    break;
                default:
                    menu.noValido();
                    break;
            }

        }

    }

    public static boolean validarFileKey() {
        Validator validator = new Validator();
        if (!validator.file(RUTA + menu.pathFile())) {
            menu.pathFileInvalido();
            return true;
        }
        if (!validator.key(menu.key())) {
            menu.keyInvalido();
            return true;
        }
        return false;
    }

    public static void encryptOrDencrypt(String process) {
        FileManager fileManager = new FileManager(RUTA + menu.pathFile);
        menu.saveFile();
        fileManager.saveFile(RUTA + menu.saveFile + ".txt");

        //Lee, encriptar o desencriptar y Guarda

        Cipher cipher = new Cipher(ALPHABET, menu.key);

        String line;
        while ((line = fileManager.readFile()) != null) {
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
