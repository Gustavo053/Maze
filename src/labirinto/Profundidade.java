/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labirinto;

import java.util.ArrayList;

/**
 *
 * @author gustavo
 */
public class Profundidade {
    private ArrayList<Estado> positionsVisited;
    private ArrayList<Estado> positionsValid; 
    
    public Profundidade() {
        this.positionsVisited = new ArrayList<>();
        this.positionsValid = new ArrayList<>();
    }
    
    public boolean search(String[][] maze, Estado initialState, Estado finalState) {
        
        if (maze[initialState.getX()][initialState.getY()].equalsIgnoreCase("0")) {
            positionsValid.add(initialState);
        }
        
        
        for (int i = 0; i < positionsVisited.size(); i++) {
            if (positionsVisited.get(i).getX() == initialState.getX() 
                && positionsVisited.get(i).getY() == initialState.getY()) {
                return false;
            }
        }
        
        positionsVisited.add(new Estado(initialState.getX(), initialState.getY()));
        
        if (initialState.getX() == finalState.getX() && initialState.getY() == finalState.getY()) {
            System.out.println("Achei a saída");
            return true;
        }
        
        if (search(maze, moveDown(maze, initialState), finalState)) {
            return true;
        }
        
        if (search(maze, moveRight(maze, initialState), finalState)) {
            return true;
        }
        
        if (search(maze, moveUp(maze, initialState), finalState)) {
            return true;
        }
        
        if (search(maze, moveLeft(maze, initialState), finalState)) {
            return true;
        }    
        
        return false;
    }
    
    private Estado moveDown(String[][] maze, Estado state) {
                
        if ((state.getX() + 1) > maze.length - 1) {
            return state;
        }
        
        if (maze[state.getX() + 1][state.getY()] != "#") {
//            maze[state.getX()][state.getY()] = "v";
            
            return new Estado(state.getX() + 1, state.getY());
        } else {
            return state;
        }
    }
    
    private Estado moveUp(String[][] maze, Estado state) {
        
        
        if ((state.getX() - 1) < 0) {
            return state;
        }
        
        if (maze[state.getX() - 1][state.getY()] != "#") {
//            maze[state.getX()][state.getY()] = "v";
            
            
            return new Estado(state.getX() - 1, state.getY());
        } else {
            return state;
        }
    }
    
    private Estado moveRight(String[][] maze, Estado state) {
        
        if ((state.getY() + 1) > maze.length - 1) {
            return state;
        }
        
        
        if (maze[state.getX()][state.getY() + 1] != "#") {
//            maze[state.getX()][state.getY()] = "v";
            
            
            return new Estado(state.getX(), state.getY() + 1);
        } else {
            return state;
        }
    }
    
    private Estado moveLeft(String[][] maze, Estado state) {
        
        if ((state.getY() - 1) < 0) {
            return state;
        }
          
        if (maze[state.getX()][state.getY() - 1] != "#") {
//            maze[state.getX()][state.getY()] = "v";
            
            
            return new Estado(state.getX(), state.getY() - 1);
        } else {
            return state;
        }
    }
    
    public void way() {
        for (Estado e: positionsValid) {
            System.out.println("(" + e.getX() + ", " + e.getY() + ")");
        }
    }    
}
