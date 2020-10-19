/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labirinto;

import java.util.Scanner;

/**
 *
 * @author gustavo
 * 
 * Recebe uma String junta e separa ela por espaços.
 */
public class Translate {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Insira a string: ");
        
        String translateMaze = scan.next();
        
        int i = 0;
        
        String result = "";
        while(i < translateMaze.length()) {
            result += translateMaze.charAt(i) + " ";
            
            i++;
        }
        
        System.out.println(result);
    }
}
