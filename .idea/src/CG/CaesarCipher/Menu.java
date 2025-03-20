package CG.CaesarCipher;

import java.io.PrintStream;
import java.util.Scanner;

public class Menu {

    public int key = 0;
    public String pathFile = "";
    public String saveFile;

    static PrintStream sysout = System.out;
    static Scanner scanner = new Scanner(System.in);

    public void menuPrincipal() {
        sysout.println("- MENU PRINCIPAL -");
        sysout.println("Bienvenido al Cifrado Caesar");
        sysout.println("Elije una opción (1-3):");
        sysout.println("1. Cifrar");
        sysout.println("2. Descifrar");
        sysout.println("3. Salir\n");
    }

    public int numSelector(){
        sysout.print("Elige un numero: ");
        return scanner.nextInt();
    }

    public String pathFile(){
        sysout.print("De la ruta del archivo: ");
        pathFile = scanner.next();
        return pathFile;
    }

    public String saveFile(){
        sysout.println("Se guardara en FORMATO .txt");
        sysout.print("De SOLO el nombre para guardar: ");
        saveFile = scanner.next();
        return saveFile;
    }

    public int key(){
        sysout.print("De la llave/key (1-31): ");
        key =  scanner.nextInt();
        return key;
    }

    public void pathFileInvalido(){
        sysout.println("ARCHIVO NO ENCONTRADO\n");
    }

    public void keyInvalido(){
        sysout.println("LLAVE/KEY NO VALIDO\n");
    }

    public void noValido(){
        sysout.println("COMANDO NO VALIDO\n");
    }

    public void close(){
        sysout.println("Bye");
    }

}

