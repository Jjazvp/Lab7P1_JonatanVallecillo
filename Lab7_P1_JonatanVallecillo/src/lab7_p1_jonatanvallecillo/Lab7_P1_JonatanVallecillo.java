
package lab7_p1_jonatanvallecillo;

import java.util.Random;
import java.util.Scanner;
//fila 3, silla 8

public class Lab7_P1_JonatanVallecillo {
    
static Scanner leer = new Scanner(System.in);
static Random random = new Random();

    public static void main(String[] args) {
        char s = 's';
        while (s == 's' || s == 'S'){
            System.out.println("***** Menu *******");
            System.out.println("1. Tres en raya");
            System.out.println("2. Puntos de silla");
            System.out.println("3. Salir");
            System.out.print("Ingrese su opcion: ");
            int opcion = leer.nextInt();
            System.out.println();
            while (opcion > 0 && opcion < 3){
                switch (opcion){
                    case 1:
                        char S = 's';
                        while (S == 's' || S == 'S'){
                            System.out.println("Tres en Rayas");
                            char [][] tablero = generarTablero();
                            imprimir(tablero);
                            System.out.println();
                            opcion = 3;
                            boolean verificacion = verificacion(tablero);
                            while (verificacion == true){
                                System.out.println("Es el turno de: X");
                                int fila = fila();
                                int columna = columna();
                                char s2 = 's';
                                while (s2 == 's' || s == 'S'){
                                    if(ver2(fila, columna, tablero) == true){
                                        System.out.println("El usuario ha elegido la posicion: ("+fila+", "+columna+")");
                                        tablero = turnoX(fila, columna, tablero);
                                        imprimir(tablero);
                                        System.out.println();
                                        s2 = 'n';
                                    }else{
                                        System.out.println();
                                        System.out.print("Ingrese otra fila (0, 1, 2): ");
                                        fila = fila();
                                        System.out.println();
                                        System.out.print("Ingrese otra columna (0, 1, 2): ");
                                        columna = columna();
                                    }
                                }
                                
                                s2 = 's';
                                verificacion = verificacion(tablero);
                                if ( verificacionvicx(tablero) == true){
                                    System.out.println("El ganador es el jugador");
                                    s2 = 'N';
                                    verificacion = false;
                                }else if (verificacionvicy(tablero) == true){
                                    System.out.println("La maquina ha ganado");
                                    s2 = 'N';
                                }else if (verificacion(tablero) == false){
                                    System.out.println("Ha habido un empate");
                                    s2 = 'N';
                                }
                                
                                System.out.println("Es el turno de: 0");
                                while (s2 == 's' || s2 == 'S'){
                                    fila = random.nextInt(3-0)+0;
                                    columna = random.nextInt(3-0)+0;
                                    if(ver2(fila, columna, tablero) == true){
                                        System.out.println("La maquina ha elegido la posicion: ("+fila+", "+columna+")");
                                        tablero = turno0(tablero, fila, columna);
                                        imprimir(tablero);
                                        System.out.println();
                                        s2 = 'n';
                                    }else{
                                        fila = random.nextInt(3-0)+0;
                                        columna = random.nextInt(3-0)+0;
                                    }
                                }
                                imprimir(tablero);
                                System.out.println();
                                verificacion = verificacion(tablero);
                                if ( verificacionvicx(tablero) == true){
                                    System.out.println("El ganador es el jugador");
                                    verificacion = false;
                                }else if (verificacionvicy(tablero) == true){
                                    System.out.println("La maquina ha ganado");
                                }else if (verificacion(tablero) == false){
                                    System.out.println("Ha habido un empate");
                                }
                            }
                            System.out.println("Desea jugar de nuevo? (S/N)");
                            S = leer.next().charAt(0);
                            
                        }
                        System.out.println();
                        break; 
                        
                    case 2:
                        System.out.print("Ingrese el numero de filas: ");
                        int filas = leer.nextInt();
                        System.out.print("Ingrese le numero de columnas: ");
                        int columnas = leer.nextInt();
                        int [][] matriz = matriz(filas, columnas);
                        imprimirm(matriz);
                        puntosilla(matriz);
                }
            }
        }
    }
    public static char [][] generarTablero(){
        char temporal [][] = new char [3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
               temporal[i][j] = ' '; 
            }
        }
        return temporal;
    }
    
    public static void imprimir(char [][] tablero){
        System.out.println("Tablero actual");
        for(int i = 0; i < 3; i++){
            System.out.print("[ ");
            for (int j = 0; j < 3; j++){
                if(j < 2){
                    System.out.print(tablero[i][j]+", ");
                }else if (j == 2){
                    System.out.print(tablero[i][j]);
                }
                
            }
            System.out.println("]");
        }
    }
    
    public static boolean verificacion(char [][] tablero){
        boolean si_no = false;
        for(int i = 0; i < tablero.length; i++){
            for(int j = 0; j < tablero.length; j++){
                if (tablero[i][j] == ' '){
                    si_no = true;
                    j = 4;
                    i = 4;
                }
            }
        }
        return si_no;
    } //verificar si sigue el juego
    
    public static int fila(){
        System.out.print("Ingrese la fila (0, 1, 2): ");
        int fila = leer.nextInt();
        return fila;
    }
    
    public static int columna(){
        System.out.print("Ingrese la columna (0, 1, 2): ");
        int columna = leer.nextInt();
        return columna;
    }
    
    public static char [][] turnoX(int fila, int columna, char [][] tablero){
        char [][] temporal = tablero;
        for (int i = 0; i < temporal.length; i++){
            for(int j = 0; j < temporal.length; j++){
                if (i == fila && j == columna){
                    temporal[i][j] = 'X';
                }
            }
        }
        return temporal;
    }
    
    public static char [][] turno0(char [][] tablero, int fila, int columna){
        char [][] temporal = tablero;
        for (int i = 0; i < temporal.length; i++){
            for(int j = 0; j < temporal.length; j++){
                if (i == fila && j == columna){
                    temporal[i][j] = '0';
                }
            }
        }
        return temporal;
    }
    
    public static boolean ver2(int fila, int columna, char [][] tablero){
        boolean espacio = false;
        if (tablero [fila][columna] == ' '){
            espacio = true;
        }
        return espacio;
    } //verificar que el espacio no esta ocupado
    
    public static boolean verificacionvicx(char [][] tablero){
        boolean vic = false;
        int sumadorx;
        int sumador0 = 0;
        for (int i = 0; i < tablero.length; i++){
            sumadorx = 0;
            for(int j = 0; j < tablero.length; j++){
                if(tablero[i][j] == 'X'){
                    sumadorx += 1;
                }
            }
            if (sumadorx == 3){
                vic = true;
            }
        }
        if (vic == false){
            for(int i = 0; i < tablero.length; i++){
                sumadorx = 0;
                for (int j = 0; j < tablero.length; j++){
                    if (tablero[j][i] == 'X'){
                        sumadorx += 1;
                    }
                }
                if (sumadorx == 3){
                vic = true;
                }
            }
        }
        if (vic == false){
            for(int i = 0; i < tablero.length; i++){
                sumadorx = 0;
                for (int j = 0; j < tablero.length; j++){
                    if (i == j && tablero[i][j] == 'X'){
                        sumadorx += 1;
                    }
                }
                if (sumadorx == 3){
                vic = true;
                }
            }
        }
        
        return vic;
    }
    
    public static boolean verificacionvicy(char [][] tablero){
        boolean vic = false;
        int sumadorx;
        int sumador0 = 0;
        for (int i = 0; i < tablero.length; i++){
            sumadorx = 0;
            for(int j = 0; j < tablero.length; j++){
                if(tablero[i][j] == '0'){
                    sumadorx += 1;
                }
            }
            if (sumadorx == 3){
                vic = true;
            }
        }
        if (vic == false){
            for(int i = 0; i < tablero.length; i++){
                sumadorx = 0;
                for (int j = 0; j < tablero.length; j++){
                    if (tablero[j][i] == '0'){
                        sumadorx += 1;
                    }
                }
                if (sumadorx == 3){
                vic = true;
                }
            }
        }
        if (vic == false){
            for(int i = 0; i < tablero.length; i++){
                sumadorx = 0;
                for (int j = 0; j < tablero.length; j++){
                    if (i == j && tablero[i][j] == '0'){
                        sumadorx += 1;
                    }
                }
                if (sumadorx == 3){
                vic = true;
                }
            }
        }
        
        return vic;
    }
    
    
    public static int [][] matriz(int filas, int columnas){
        int [][] temporal = new int [filas][columnas];
        for (int i = 0; i < filas; i++){
            for (int j = 0; j < columnas; j++){
                temporal[i][j] = random.nextInt(99-0)+0;
            }
        }
        return temporal;
    }
    
    public static void imprimirm(int [][] matriz){
        for(int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz.length; j++){
                System.out.print("["+matriz[i][j]+"] ");
            }
            System.out.println();
        }
    }
    
    public static void puntosilla(int [][] matriz){
        int mayor = 0;
        int menor = 0;
        for (int i = 0; i < matriz.length; i++){
            menor = matriz [i][0];
            for (int j = 0; j < matriz.length; j++){
                if(matriz[i][j] < menor){
                    menor = matriz[i][j];
                    mayor = matriz[i][j];
                }
            }
            for(int k = 0; k < matriz.length; k++){
                if (matriz[k][i] > mayor){
                    mayor = matriz[k][i];
                }
            }
            
        }
        
        if (menor == mayor){
            System.out.println("Se entonctro el punto silla en: "+mayor);
        }else{
            System.out.println("No se encontro el punto de silla");
        }
    }
}
