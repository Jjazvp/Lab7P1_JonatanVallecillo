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
                    matriz = matrizRotada(matriz, rotacion);
                    imprimirMatriz(matriz);
                    
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
                matriz[i][j] = rand.nextInt(10);
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
        int [][] temporal = matriz;
        int [][] matriz2 = matriz;
        char carac = ' ';
        int dimension1 = 0;
        int dimension2 = 0;
        int pos1 = 0;
        int pos2 = 0;
        
        for(int i = 0; i < rotacion.length(); i++){
            carac = rotacion.charAt(i);
            char carac2 = ' ';
            String car = " ";
            
            if(carac == 'f' && i == 0){
                dimension1 = 1;
                carac2 = rotacion.charAt(i+1);
                car = ""+carac2;
                pos1 = Integer.parseInt(car);
            }else if(carac == 'c' && i == 0){
                dimension1 = 2;
                carac2 = rotacion.charAt(i+1);
                car = ""+carac2;
                pos1 = Integer.parseInt(car);
            }else if(carac == 'f' && i == 3){
                dimension2 = 3;
                carac2 = rotacion.charAt(i+1);
                car = ""+carac2;
                pos2 = Integer.parseInt(car);
            }else if(carac == 'c' && i == 3){
                dimension2 = 4;
                carac2 = rotacion.charAt(i+1);
                car = ""+carac2;
                pos2 = Integer.parseInt(car);
            }
            
        }
        System.out.println("pos1 "+pos1);
        System.out.println("pos2 "+pos2);
        int intercambio = 0;
        int intercambio2 = 0;
    
        
        for(int i = 0; i < temporal.length; i++){
            for(int j = 0; j < temporal[i].length; j++){
                if(dimension1 == 1 && dimension2 == 3){
                    temporal[pos2][j] = matriz2[pos1][j];
                    temporal[pos1][j] = matriz2[pos2][j];
                }else if(dimension1 == 2 && dimension2 == 4){
                    temporal[i][pos2] = matriz2[i][pos1];
                    temporal[i][pos1] = matriz2[i][pos2];
                }else if((dimension1 == 1 && dimension2 == 2)){
                    temporal[i][pos2] = matriz2[pos1][j];
                    temporal[pos1][j] = matriz2[i][pos2];
                }
            }
        }
        
        return temporal;
    }
        
}
