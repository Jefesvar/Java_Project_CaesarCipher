package CG.CaesarCipher;

import java.io.PrintStream;
import java.util.Scanner;

public class Menu {

    public boolean activo = true;
    public int key = 0;
    public String pathFile = "";

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

    public int key(){
        sysout.print("De la llave/key (1-31): ");
        key =  scanner.nextInt();
        return key;
    }

    public void pathFileInvalido(){
        sysout.println("ARCHIVO NO ENCONTRADO");
    }

    public void keyInvalido(){
        sysout.println("LLAVE/KEY NO VALIDO");
    }

    public void noValido(){
        sysout.println("COMANDO NO VALIDO");
    }

    public void close(){
        sysout.println("Bye");
        activo = false;
    }

}

