package CG.CaesarCipher;

import javax.swing.plaf.PanelUI;
import java.io.PrintStream;
import java.util.Scanner;

public class Menu {

    public int key = 0;
    public String pathFile = "";
    public String writeFile;

    static PrintStream sysout = System.out;
    static Scanner scanner = new Scanner(System.in);

    public void showPrincipalMenu() {
        sysout.println("\n- MENU PRINCIPAL -");
        sysout.println("Bienvenido al Cifrado Caesar");
        sysout.println("Elije una opción (1-3):");
        sysout.println("1. Cifrar");
        sysout.println("2. Descifrar");
        sysout.println("3. Fuerza Bruta");
        sysout.println("4. Salir\n");
    }

    public int requestPrincipalMenuSelection(){
        sysout.print("Elige un numero: ");
        return scanner.nextInt();
    }

    public String requestPathFile(){
        sysout.print("De la ruta del archivo: ");
        pathFile = scanner.next();
        return pathFile;
    }


    public void requestWriteFileName(){
        sysout.println("\nSe guardara en FORMATO .txt");
        sysout.print("De SOLO el nombre para guardar: ");
        writeFile = scanner.next();
    }

    public int requestKey(){
        sysout.print("De la llave/key (1-32): ");
        key =  scanner.nextInt();
        return key;
    }

    public boolean recuestContinueDecryptAndSave(){

        String yesOrNo="";
        while (true){
            sysout.print("Continuar Desencriptando (Y/N): ");
            yesOrNo = scanner.next();
            if (yesOrNo.equalsIgnoreCase("n")){
                return false;
            }
            if (yesOrNo.equalsIgnoreCase("y")){
                return true;
            }
            answerToInvalidSelection();
        }

    }

    public void answerToInvalidPathFile(){
        sysout.println("ARCHIVO NO ENCONTRADO\n");
    }

    public void answerToInvalidDictionary(){
        sysout.println("DICCIONARIO NO ENCONTRADO\n");
    }

    public void answerToInvalidKey(){
        sysout.println("LLAVE/KEY NO VALIDO\n");
    }

    public void answerToKeyNoFoundInBruteForce(){
        sysout.println("LLAVE/KEY NO ENCONTRADA");
        sysout.println("NO ES ENCRYPTADO CAESAR O EL TEXTO ES ILEGIBLE\n");
    }

    public void answerToKeyFoundInBruteForce(int key){
        sysout.println("POSIBLE LLAVE COMPATIBLE, PRUEBA CON " + key);
    }

    public void answerToInvalidSelection(){
        sysout.println("COMANDO NO VALIDO\n");
    }


    public void setWriteFileName(String writeFile){
        this.writeFile = writeFile;
    }

    public void close(){
        sysout.println("Bye");
    }

}

