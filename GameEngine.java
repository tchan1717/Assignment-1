/**
* Author: <Your name here>
* Student Id: <Your Student id> 
* Email: <Your student email goes here>
*/

import java.util.Scanner;

public class GameEngine {
    public static Scanner keyboard = new Scanner(System.in);
  

    public static void main(String[] args) {
      if (args.length != 3) {
        System.out.println("Invalid Inputs to set layout. Exiting the program now.");
        return;
        }
      int length = Integer.parseInt(args[0]);
      int width = Integer.parseInt(args[1]);
      int seed = Integer.parseInt(args[2]);
      if (length <= 0 || width <= 0 || seed <= 0) {
        System.out.println("Invalid Inputs to set layout. Exiting the program now.");
        return;
      }

      GameEngine engine = new GameEngine();
      Maze maze = new Maze(length, width, seed);

      engine.displayMessage();  
      engine.displayMenu(maze);
    }

    private void displayMessage() {
        System.out.println(" ____         __          ___        _  _         __         __ _ \n" +
                "(  _ \\       / _\\        / __)      ( \\/ )       / _\\       (  ( \\\n" +
                " ) __/      /    \\      ( (__       / \\/ \\      /    \\      /    /\n" +
                "(__)        \\_/\\_/       \\___)      \\_)(_/      \\_/\\_/      \\_)__)");
        System.out.println("");
        System.out.println("Let the fun begin");
        System.out.println("(`<    ...   ...  ...  ..........  ...");
        System.out.println("");
    }

     private void displayMenu(Maze maze) {
        System.out.println("Select an option to get started.");
        System.out.println("Press 1 to select a pacman maze type.");
        System.out.println("Press 2 to play the game.");
        System.out.println("Press 3 to resume the game.");
        System.out.println("Press 4 to view the scores.");
        System.out.println("Press 5 to exit.");
        int selector = keyboard.nextInt();
        switch (selector) {       
         case 1:
          optionMazeType(maze);
          break;
          //
         case 2:
          optionPlayGame(maze);
          break;
          //
         case 3:
          optionResume(maze);
          break;
          //
         case 4:
          optionViewScore(maze);
          break;
          //
         case 5:
           optionExit();
          break;
          }
     }

     // methods
     private void optionMazeType(Maze maze) {
       while(true) {
        System.out.println("> Please select a maze type.");
        System.out.println("Press 1 to select lower triangle maze.");
        System.out.println("Press 2 to select upper triangle maze.");
        System.out.println("Press 3 to select horizontal maze.");
        int selector = keyboard.nextInt();
         if (selector == 1) {
            maze.setMazeType(selector);
            break;
          } else if (selector == 2) {
            maze.setMazeType(selector);
            break;
          } else if (selector == 3) {   
            maze.setMazeType(selector);
            break;
          } else {
            System.out.println("Invalid Input.");
          }
      }
      System.out.println("> Maze created. Proceed to play the game.");
      displayMenu(maze);
     }

     private void optionPlayGame(Maze maze) {
      if (maze.getMazeType() == 0) {
        System.out.println("> Maze not created. Select option 1 from main menu.");
        displayMenu(maze);
      } else { 
         System.out.println("> Move the Pacman towards the food pellet.");
         System.out.println("  > You gain 20 points when Pacman get the food.");
         System.out.println("  > You lose 0.5 point when you hit the wall/boundary.");
         System.out.println("  > Score = 20 * Food - 0.5 * hits - 0.25 * moves.");
         int mazeNumber = maze.getMazeType(); 
         if (mazeNumber == 1) {
             maze.printLowerTriangularMaze();
          } else if (mazeNumber == 2) {
             maze.printUpperTriangularMaze();
          } else if (mazeNumber == 3) {
             maze.printHorizontalMaze();
          } // refer to end of game-engine comments block under horizontal maze diagram
         System.out.println("Press W to move up.");
         System.out.println("Press A to move left.");
         System.out.println("Press S to move down.");
         System.out.println("Press D to move right.");
         System.out.println("Press Q to exit.");
         /*
          * code block that scans for user input and calls pacman position according to key pressed
          * Scanner sc = new Scanner(System.in);
          * char usrSelection = sc.nextChar()
          * if player presses q keep the object maze
          *
          * maze.pacmanPosition(usrSelection, mazeNumber);
          *
          */ 
         }  
      }
     
     
     private void optionResume(Maze maze) {
       maze.printTest();
       maze.mazeOption();
     }
     private void optionViewScore(Maze maze) {
       maze.scoreCard();
     }
     private static void optionExit() {
       System.out.println("> Pacman says - Bye Bye Player.");
        keyboard.close();
     }
}

     
