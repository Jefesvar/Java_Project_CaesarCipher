package CG.CaesarCipher;
import java.util.Scanner;

import java.io.PrintStream;
import java.util.Scanner;

public class MainApp {

    static PrintStream sysout = System.out;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        showMenu();
        scanner.nextInt();


    }


    public static void showMenu(){
        sysout.println("Bienvenido al Cifrado Caesar");
        sysout.println("Elije una opción (1-3):");
        sysout.println("1. Cifrar");
        sysout.println("2. Descifrar");
        sysout.println("3. Salir");
        sysout.println("Por favor, elige: ");
    }

}
