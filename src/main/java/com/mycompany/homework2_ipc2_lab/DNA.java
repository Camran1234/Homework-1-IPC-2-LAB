/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.homework2_ipc2_lab;

import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author camran
 */
public class DNA {
    JTextField cadenaObjetoA;
    JTextField cadenaObjetoB;
    public DNA( JTextField cadenaA, JTextField cadenaB){
        this.cadenaObjetoA = cadenaA;
        this.cadenaObjetoB = cadenaB;
        arrancar();
    }
    
    private void arrancar(){
        //Declaracion de las variables que usaremos durante el programa
        String cadenaA = cadenaObjetoA.getText();
        String cadenaB= cadenaObjetoB.getText();
        
        //Arranque del programa e interaccion con el usuario
        System.out.println("Bienvenido al programa DECODIFICADOR ADN"
                + "\nEmpezando Programa:\n");
        System.out.println("Letras a Usar: T (tiamina), G(guanina), C(citosina), A(guanina) ");
        cadenaA = checkValidDNA(cadenaA,1);
        cadenaB=checkValidDNA(cadenaB,2);
        
        System.out.println("Los patrones encontrados en ambas cadenas: " + compareDNA(cadenaA, cadenaB));
        JOptionPane.showMessageDialog(null, "Los patrones encontrados en ambas cadenas: \n"+compareDNA(cadenaA,cadenaB), "RESULTADO", JOptionPane.WARNING_MESSAGE);
        
    }
    
    /**
     * Método que nos retornara los patrones similares encontrados en ambas cadenas
     * @param cadenaA
     * @param cadenaB
     * @return 
     */
    private String compareDNA(String cadenaA, String cadenaB){
        //Los dos strings nos servirán para corroborrar las cadenas similares de letras que encontremos
        //mientras que largocadena nos indicará de que tamaño ha sido la cadena más grande que ha encontrado
        //las variables counter y letters nos servirá para ubicarnos de primero en que posición se encuentra la letra
        //de la cadena que se está comparando y letters nos servirá para indicar que es mayor igual que dos letras para 
        //corroborar que es una cadena
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
            
            //Comparación del tamaño de la cadena y si es una cadena de caractéres
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
    private String checkValidDNA(String cadena, int identificadorCadena){
        cadena = cadena.toUpperCase();
        cadena = cadena.trim();
        
        // Parte del metodo que corrobara en ascii si las letras ingresadas o son T, G o C de lo contrario
        //Se ingresara nueva cadena.
        for(int letra = 0; letra<cadena.length();letra++){
            if( (cadena.charAt(letra)!=84) && (cadena.charAt(letra)!=71) && (cadena.charAt(letra)!=67)&& (cadena.charAt(letra)!=65)){
                System.out.println("Cadena incompatible\n");
                JOptionPane.showMessageDialog(null, "Cadena Incompatible", "Error",JOptionPane.ERROR_MESSAGE);
                newDNA(identificadorCadena);
                return null;
            }
        }
        
        
        return cadena;
    }
    
    /**
     * Reiniciara el textField para que el usuario ingrese de nuevo los datos
     * @param identificadorCadena
     */
    private void newDNA(int identificadorCadena){
        if(identificadorCadena == 1){
            this.cadenaObjetoA.setText("");
        }else{
            this.cadenaObjetoB.setText("");
        }
                
    }
}
