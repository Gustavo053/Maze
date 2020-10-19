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
 */
public class Labirinto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // TODO code application logic here
        
        String[][] maze = new String[5][5];
        
        //5-5
        //# 0 # # # # 0 # 0 # # 0 # 0 # # 0 0 0 # # # # 0 #
        
        for(int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {
                maze[i][j] = scan.next();
            }
        }
        
        for(int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println("");
        }
        
        Profundidade profundidade = new Profundidade();
        Estado inicial = new Estado(0, 1);
        Estado finalState = new Estado(maze.length - 1, maze[0].length - 2);
        
        profundidade.search(maze, inicial, finalState);
        profundidade.way();
    }
}
