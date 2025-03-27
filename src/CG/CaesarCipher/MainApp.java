package CG.CaesarCipher;


public class MainApp {


    public static final char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz .,:?!".toCharArray();
    public static final String PATH = "src/CG/CaesarCipher/";
    public static final String DICTIONARY = "src/CG/CaesarCipher/DICTIONARY.txt";

    public static final Menu menu = new Menu();


    public static void main(String[] args) {

        // programa

        boolean quit = false;
        while (!quit) {
            menu.showPrincipalMenu();

            switch (menu.requestPrincipalMenuSelection()) {
                case 1:
                    System.out.println("\n- CIFRAR -");

                    //Inserta y Valida Key y File

                    if (!fileValidation()) {
                        break;
                    }
                    if (!keyValidation()){
                        break;
                    }

                    //Prepara archivos para leer, (encriptar o desencriptar) y guardar

                    String[] stringLinesEncrypted = fileToArrayProcess("encrypt");

                    menu.requestWriteFileName();
                    writeArrayInWriteFile(stringLinesEncrypted);

                    break;


                case 2:

                    System.out.println("\n- DESCIFRAR -");

                    if (!fileValidation()) {
                        break;
                    }
                    if (!keyValidation()){
                        break;
                    }

                    //Prepara archivos para leer y guardar

                    String[] stringLinesDecrypted = fileToArrayProcess("decrypt");

                    menu.requestWriteFileName();
                    writeArrayInWriteFile(stringLinesDecrypted);


                    break;
                case 3:

                    System.out.println("\n- FUERZA BRUTA -");

                    if (!fileValidation()) {
                        break;
                    }

                    if (!dictionaryValidation()){
                        break;
                    }

                    String[] stringLinesBruteDecrypted = bruteForceDecrypt();
                    if(stringLinesBruteDecrypted==null){
                        break;
                    }

                    menu.requestWriteFileName();
                    writeArrayInWriteFile(stringLinesBruteDecrypted);

                    break;
                case 4:
                    menu.close();
                    quit = true;
                    break;
                default:
                    menu.answerToInvalidSelection();
                    break;
            }

        }

    }

    public static boolean fileValidation() {
        Validator validator = new Validator();
        if (!validator.fileValidation(PATH + menu.requestPathFile())) {
            menu.answerToInvalidPathFile();
            return false;
        }
        return true;
    }

    public static boolean keyValidation(){
        Validator validator = new Validator();
        if (!validator.keyValidation(menu.requestKey())) {
            menu.answerToInvalidKey();
            return false;
        }
        return true;
    }

    public static String[] fileToArrayProcess(String process) {
        FileManager fileManager = new FileManager(PATH + menu.pathFile, "read");

        //Lee, encriptar o desencriptar y Guarda

        Cipher cipher = new Cipher(ALPHABET, menu.key);

        String[] stringLines = fileManager.readFileLines();
        fileManager.close();
        return switch (process) {
            case "encrypt" -> cipher.arrayEncrypt(stringLines);
            case "decrypt" -> cipher.arrayDecrypt(stringLines);
            default -> stringLines;
        };
    }

    public static void writeArrayInWriteFile(String[] arrayContent) {
        FileManager fileManager = new FileManager(PATH + menu.writeFile + ".txt", "write");
        fileManager.arrayWriteFile(arrayContent);
        fileManager.close();
    }

    public static boolean dictionaryValidation(){
        Validator validator = new Validator();
        if (!validator.fileValidation(DICTIONARY)){
            menu.answerToInvalidDictionary();
            return false;
        }
        return true;
    }

    public static String[] bruteForceDecrypt() {
        String[] stringLines = fileToArrayProcess("default");

        //String[] sampleLines = stringLines; | alternativa para evitar leer el texto completo

        FileManager fileManager = new FileManager(DICTIONARY, "read");
        String[] dictionary = fileManager.readFileLines();
        fileManager.close();

        BruteForce bruteForce = new BruteForce(stringLines, dictionary, ALPHABET);
        if(bruteForce.bruteKey !=-1){
            menu.answerToKeyFoundInBruteForce(bruteForce.bruteKey);
            if(menu.recuestContinueDecryptAndSave()) {
                Cipher cipher = new Cipher(ALPHABET, bruteForce.bruteKey);
                return cipher.arrayDecrypt(stringLines);
            }
        }
        menu.answerToKeyNoFoundInBruteForce();
        return null;
    }

}
