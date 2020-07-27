package com.mycompany.homework2_ipc2_lab;

import java.util.Scanner;


/**
 *
 * @author camran
 */
public class HomeWork1 {
    
    public static void main(String[] args) {
        arrancar();
    }
    
    private static void arrancar(){
        //Declaracion de las variables que usaremos durante el programa
        Scanner escaner = new Scanner(System.in);
        String cadenaA;
        String cadenaB;
        
        //Arranque del programa e interaccion con el usuario
        System.out.println("Bienvenido al programa DECODIFICADOR ADN"
                + "\nEmpezando Programa:\n");
        System.out.println("Letras a Usar: T (tiamina), G(guanina), C(citosina), A(guanina) ");
        System.out.println("Escriba la primera cadena");
        cadenaA=escaner.nextLine();
        cadenaA = checkValidDNA(cadenaA);
        System.out.println("Escriba la segunda cadena");
        cadenaB=escaner.nextLine();
        cadenaB=checkValidDNA(cadenaB);
        
        System.out.println("Cadena a: "+cadenaA);
        System.out.println("Cadena b: "+cadenaB);
        System.out.println("Los patrones encontrados en ambas cadenas: " + compareDNA(cadenaA, cadenaB));
    }
    
    /**
     * Método que nos retornara los patrones similares encontrados en ambas cadenas
     * @param cadenaA
     * @param cadenaB
     * @return 
     */
    private static String compareDNA(String cadenaA, String cadenaB){
        String cadenaCombinada="";
        String cadena="";
        int counter;
        int letters=0;
        int largoCadena=0;
        for(int x=0; x<cadenaA.length();x++){
            counter=x;   
            cadena="";
            letters=0;
            for (int y=0;y<cadenaB.length(); y++){
                
                if(counter<cadenaA.length()){
                    if( cadenaA.charAt(counter) == cadenaB.charAt(y)){
                        cadena+= cadenaA.charAt(counter);
                        counter++;
                        letters++;                        
                    }else if(letters!=0){
                        break;
                    }
                }
            }
            
            if (letters>=2 && largoCadena<cadena.length()){
                cadenaCombinada= cadena;
                largoCadena = cadena.length();
            }
        }
        
        return cadenaCombinada;
    }
    
    /**
     * Método que corrobora si la cadena ingresada solo poseee las letras T (timina), G (guanina), C(citosina)
     * @param cadena
     * @return 
     */
    private static String checkValidDNA(String cadena){
        cadena = cadena.toUpperCase();
        cadena = cadena.trim();
        
        // Parte del metodo que corrobara en ascii si las letras ingresadas o son T, G o C de lo contrario
        //Se ingresara nueva cadena.
        for(int letra = 0; letra<cadena.length();letra++){
            if( (cadena.charAt(letra)!=84) && (cadena.charAt(letra)!=71) && (cadena.charAt(letra)!=67)&& (cadena.charAt(letra)!=65)){
                System.out.println("Cadena incompatible\n");
                cadena = newDNA();
                break;
            }
        }
        
        
        return cadena;
    }
    
    private static String newDNA(){
        String cadena;
        Scanner escaner = new Scanner(System.in);
        System.out.println("Escriba la cadena");
        cadena = escaner.nextLine();
        //Se vuelve a llamar al metodo de corroborar cadena para comprobar que todo esta en orden
        cadena = checkValidDNA(cadena);
        
        
        return cadena;
                
    }
    
}
