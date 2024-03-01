package lab7p1_jonatanvallecillo;

import java.util.Random;
import java.util.Scanner;


public class Lab7P1_JonatanVallecillo {

    static Scanner leer = new Scanner(System.in);
    static Scanner leer1 = new Scanner(System.in);
    static Random rand = new Random();
    
    public static void main(String[] args) {
        int menu = 1;
        while(menu == 1){
            
            int submenu = 1;
            int opcion = 0;
            while(submenu == 1){
                System.out.print("**** MENU ****\n"
                    + "1. Metodos que necesita\n"
                    + "2. Numero solitario\n"
                    + "3. Intercambio de filas y/o columnas\n"
                    + "4. Salir\n"
                    + "Ingrese la opcion que desea: ");
                opcion = leer.nextInt();
                
                if(opcion > 0 && opcion < 5){
                    submenu = 0;
                }else{
                    System.out.println("ERROR. Intente de nuevo.");
                }
            }
            
            switch(opcion){
                case 1:
                    System.out.print("\nIngrese la cantidad de filas: ");
                    int fila = leer.nextInt();
                    System.out.print("Ingrese la cantidad de columnas: ");
                    int columna = leer.nextInt();
                    System.out.println();
                    
                    int [][] matriz = new int [fila][columna];
                    matriz = generarMatriz(matriz);
                    imprimirMatriz(matriz);
                    PuntoEquilibrio(matriz);
                    
                    System.out.println();
                    break;
                    
                case 2: 
                    System.out.print("\nIngrese las filas: ");
                    fila = leer.nextInt();
                    System.out.print("Ingrese las columnas: ");
                    columna = leer.nextInt();
                    System.out.println();
                    
                    matriz = new int [fila][columna];
                    matriz = generarMatriz(matriz);
                    imprimirMatriz(matriz);
                    
                    NumSolitario(matriz);
                    
                    System.out.println();
                    
                    break; 
                    
                case 3:
                    System.out.print("\nIngrese el tamano: ");
                    int tamaño = leer.nextInt();
                    
                    matriz = new int [tamaño][tamaño];
                    matriz = generarMatriz(matriz);
                    imprimirMatriz(matriz);
                    
                    
                    System.out.println("Ingrese comando de rotacion: ");
                    String rotacion = leer1.nextLine();
                    matrizRotada(matriz, rotacion);
                    
                    System.out.println();
                    break;
                    
                case 4:
                    menu = 0;
                    break;
            }
        }
    }
    
    public static int[][] generarMatriz(int[][] matriz) {//Ejercicio 1 y 2
        Random ran = new Random();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = rand.nextInt(5) + 2;
            }
        }
        return matriz;
    } 
    
    public static void imprimirMatriz(int[][] matriz) { //Ejercicio 1 y 2
    System.out.println("");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
             System.out.print("[" + matriz[i][j] + "] ");
            }
        System.out.println("");
        }
    }
    
    public static void PuntoEquilibrio(int [][] matriz){
        int P_equilibrio1 = 0;
        int P_equilibrio2 = 0;
        int sumaF = 0;
        int sumaF2 = 0;
        int sumaC = 0;
        int sumaC2 = 0;
        int punto = 0;
        int posx = 0;
        int posy = 0;
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[i].length; j++){
                sumaF = 0;
                sumaC = 0;
                
                for(int u = 0; u < matriz.length; u++){
                    for(int v = 0; v < matriz[i].length; v++){
                        if(u == i && v != j){
                            sumaF += matriz[u][v];
                        }else if(u != i && v == j){
                            sumaC += matriz[u][v];
                        }
                    }
                }
                P_equilibrio2 = sumaC + sumaF;
                if((P_equilibrio2 < P_equilibrio1) || i == 0 && j == 0){
                    P_equilibrio1 = P_equilibrio2;
                    punto = matriz[i][j];
                    sumaF2 = sumaF;
                    sumaC2 = sumaC;
                    posx = i;
                    posy = j;
                }
            }
        }
        System.out.println("El punto de equilibrio esta en ["+posx+"]["+posy+"] = "+punto+"\n"
                + "Porque su suma en horizontal es "+sumaF2+" y su suma en vertical es "+sumaC2);
    } //Ejericio 1
    
    public static void NumSolitario(int [][] matriz){ //Ejercicio 2
        int cantidad = 0;
        int sumaF = 0;
        int sumaC = 0;
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[i].length; j++){
                cantidad = matriz[i][j];
                int cantidad2 = cantidad;
                
                for(int u = 0; u < matriz.length; u++){
                    for(int v = 0; v < matriz[i].length; v++){
                        if(u == i && v != j && cantidad2 > 0){
                            cantidad2 --;
                        }else if(u != i && v == j){
                            if(cantidad - v >= 0){
                                sumaC += matriz[u][v];
                            }else{
                                
                            }
                        }
                    }
                }
            }
        }
    }
    
    public static int [][] matrizRotada(int [][] matriz, String rotacion){
        int [][] temporal = new int [matriz.length][matriz.length];
        char carac = ' ';
        
        for(int i = 0; i < rotacion.length(); i++){
            int dimension1 = 0;
            int dimension2 = 0;
            int pos1 = 0;
            int posy = 0;
            carac = rotacion.charAt(i);
            if(carac == 'f' && i == 0){
                dimension1 = 1;
                pos1 = rotacion.charAt(i+1);
            }else if(carac == 'c' && i == 0){
                dimension1 = 0;
                pos1 = rotacion.charAt(i+1);
            }else if(carac == 'f'){
                dimension2 = 1;
            }else if(carac == 'c'){
                dimension2 = 0;
            }
            
        }
        
        for(int i = 0; i < temporal.length; i++){
            for(int j = 0; j < temporal[i].length; j++){
                
            }
        }
        
        return temporal;
    }
        
}
