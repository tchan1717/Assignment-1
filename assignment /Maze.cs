/**
* Author: <Your name here>
* Student Id: <Your Student id> 
* Email: <Your student email goes here>
*/

public class Maze {  
    private int mazeLength;
    private int mazeWidth;
    private int mazeSeed;
    private int mazeType;
    private int pacManX = 1;
    private int pacManY = 1;
    private int gameNumber;
    private int hitBoundaryWall;
    private int numberOfMoves;
    private int totalScore;

    // constructors
    public Maze() {
        
    }
    public Maze(int length, int width, int seed) {
        this.mazeLength = length;
        this.mazeWidth = width;
        this.mazeSeed = seed;
    }
    /*
    public Maze(int mazeType) {
        this.mazeType = mazeType;
    }
    */
    // getter methods 
    public int getLength() {
        return mazeLength;
    }
    public int getWidth() {
        return mazeWidth;
    }
    public int getMazeType() {
        return mazeType;
    }
    public int getSeed() {
        return mazeSeed;
    }
    public int getpacManX() {
        return pacManX;
    }
    public int getpacManY() {
        return pacManY;
    }

    //setter methods
    public int setMazeType(int mazeSelector) {
        this.mazeType = mazeSelector;
        return this.mazeType;
    }

    // Maze parameteres
    public void printMaze() { 
        for(int i = 0; i < mazeWidth; i++) {
            for(int n = 0; n < mazeLength; n++){
                System.out.print("#");
            }
            System.out.println();
        }
        System.out.println(mazeLength);  // Print newline at the end
    }
    
    public void printTest() {
        System.out.println(mazeLength);
        System.out.println(mazeWidth);
    }
     public void printMazeType() {      //delete
        System.out.println(mazeType);
    }
    
    
    // method to choose mazeType
    public void mazeOption() {
        if (mazeType == 1) {
            System.out.println("1");
        } else if (mazeType == 2) {
            System.out.println("2");
        } else if (mazeType == 3) {
            System.out.println("3");
        } else {
            System.out.println("Invalid Input");
        }
        
    }

    //print lower triangle maze
      public void printLowerTriangularMaze() {
        for (int i = 0; i < mazeWidth; i++) {
            for (int j = 0; j < mazeLength; j++) {
                if (i == 0 || i == mazeWidth - 1 || j == 0 || j == mazeLength -1) {
                    System.out.print("#");
                } else if (j > i ) {
                    System.out.print("-"); // triangle walls
                } else if (i == pacManY && j == pacManX) {
                    System.out.print("P"); // PACMAN start position
                } else if (i == rowPosFood && j == colPosFood) { //testing
                    System.out.print("*");
                } else {
                    System.out.print("."); // Navigable path
                }
        }
        System.out.println();
       }
      }
    //print upper triangle maze
      public void printUpperTriangularMaze() {
        for (int i = 0; i < mazeWidth; i++) {
            for (int j = 0; j < mazeLength; j++) {
                if (i == 0 || i == mazeWidth - 1 || j == 0 || j == mazeLength -1) {
                    System.out.print("#");
                } else if (j < i) {
                    System.out.print("-"); // triangle walls
                } else if (i == pacManY && j == pacManX) {
                    System.out.print("P"); // PACMAN start position
                } else if (i == 3 && j == 3){
                    System.out.print("*");
                } else {
                    System.out.print("."); // Navigable path
                }
        }
        System.out.println();
       }
      }
    //print horizontal triangle maze
      public void printHorizontalMaze() {
        for (int i = 0; i < mazeWidth; i++) {
            for (int j = 0; j < mazeLength; j++) {
                if (i == 0 || i == mazeWidth - 1 || j == 0 || j == mazeLength - 1) {
                    System.out.print("#");  // Boundary walls
                } else if (i % 2 == 0 && j > 1 && j < mazeWidth) {  // Rows with walls
                    System.out.print("-");  // Horizontal wall     
                } else if (i == pacManY && j == pacManX) {
                    System.out.print("P");  // PACMAN position
                } else {
                    System.out.print(".");  // Navigable path
                }
            }
            System.out.println();  // Move to the next row
        }
    }
    /*pacman position*/
   public void pacmanPosition(char usrSelection, int mazeType) {
        switch(usrSelection) {
            case 'w':
                if(pacManY == 1) {
                    System.out.println("You have hit the boundary."); //sample, edit as needed
                    this.hitBoundaryWall++;
                    break;
                } else if (mazeType == 1 && pacManY > pacManX){   
                    pacManY--;
                    this.numberOfMoves++;
                } else if (mazeType == 2 && pacManY < pacManX){
                    pacManY--;
                    this.numberOfMoves++;
                    break;
                } else if (mazeType == 3) {
                   if (pacManX > 1 && pacManX < mazeLength -2) { // PACMAN on an even row and can move up
                     System.out.println("You have hit a wall.");
                     this.hitBoundaryWall++;
                   } else {
                    pacManY--;
                    this.numberOfMoves++;
                   }
                } else {
                    pacManY--;
                    this.numberOfMoves++;
                }
                       break; // Ensure break to prevent fall-through  

            case 's':
                if(pacManY == mazeWidth - 2) {
                    System.out.println("You have hit the boundary.");
                    this.hitBoundaryWall++;
                    break;
                } else if(mazeType == 1 ){
                    pacManY++;   
                    this.numberOfMoves++;                                           //pacman can go down ()                                          
                    break;
                } else if (mazeType == 2 && pacManX <= pacManY) {
                    System.out.println("You have hit a wall.");
                    this.hitBoundaryWall++;
                    break;                                            //pacman cannot go down because wall                                                                             
                } else if (mazeType == 3) {
                   if (pacManX > 1 && pacManX < mazeLength -2) { // PACMAN on an even row and can move up
                     System.out.println("You have hit a wall.");
                     this.hitBoundaryWall++;
                   } else {
                    pacManY++;
                    this.numberOfMoves++;
                   }
                } else {
                    pacManY++;
                    this.numberOfMoves++;
                }
                 break;
            case 'a':
                if(pacManX == 1) {
                    System.out.println("You have hit the boundary.");
                    this.hitBoundaryWall++;
                    break;
                } else if (mazeType == 1 && pacManX == 1 ) {
                    System.out.println("You have hit the boundary.2");
                    this.hitBoundaryWall++;
                    break;
                } else if (mazeType == 2 && pacManX == pacManY) {
                    System.out.println("You have hit a wall.");
                    this.hitBoundaryWall++;
                    break;
                } else if(mazeType == 3){
                    if(pacManY == 0 || pacManY == mazeWidth || pacManY%2 == 0){
                        System.out.println("You have hit a wall.");
                        this.hitBoundaryWall++;
                        break;
                    } else {
                        pacManX--;   // does it work?
                        this.numberOfMoves++;
                    }
                }
                else {
                pacManX--;
                this.numberOfMoves++;
                   break;                            //  -------reprint maze here and BREAK---------------
                   }
                break;
            case 'd':
                if(pacManX == mazeLength - 2) {
                    System.out.println("You have hit a boundary.");
                    this.hitBoundaryWall++;
                    break;
                } else if (mazeType == 1 && pacManX == pacManY) {
                    System.out.println("You have hit a wall.");
                    this.hitBoundaryWall++;
                    break;
                } else if (mazeType == 2 && pacManX == mazeLength - 2) {
                    System.out.println("You have hit a boundary.2");
                    this.hitBoundaryWall++;
                    break;
                } else if (mazeType == 3) {
                    if(pacManY == 0 || pacManY == mazeLength || pacManY%2 == 0){
                        System.out.println("You have hit a wall");
                        this.hitBoundaryWall++;
                        break;
                    } else {
                        pacManX++;
                        this.numberOfMoves++;
                    }
                }
                else {
                   pacManX++;  
                   this.numberOfMoves++;
                   break;                             
                }         
                break;
          default:
            System.out.println("Invalid Input");

        }
         if (mazeType == 1) {
           printLowerTriangularMaze();
           mazeInstruction();
          } else if (mazeType == 2) {
           printUpperTriangularMaze();
           mazeInstruction();
          } else if (mazeType == 3) {
           printHorizontalMaze();
           mazeInstruction();
          }   
         
   }
    public void mazeInstruction() {
         System.out.println("Press W to move up.");
         System.out.println("Press A to move left.");
         System.out.println("Press S to move down.");
         System.out.println("Press D to move right.");
         System.out.println("Press Q to exit.");
    }

     public void mazeInstructionScore() {
         System.out.println("Move the Pacman towards the food pellet.");
         System.out.println("  > You gain 20 points when Pacman get the food.");
         System.out.println("  > You lose 0.5 point when you hit the wall/boundary.");
         System.out.println("  > Score = 20 * Food - 0.5 * hits - 0.25 * moves.");
    }
    /*food position*/
    private int colPosFood;
    private int rowPosFood;

    /*score/game related attributes*/
    public void scoreCard() {
        System.out.printf("|%8s|%8s|%8s|%8s|%n", "Game", "Hits", "Moves", "Score");
        System.out.printf("|%8s|%8s|%8s|%8s|%n", "========","========","========","========");
        System.out.printf("|%8s|%8s|%8s|%8s|%n", "1",this.hitBoundaryWall,this.numberOfMoves++,"4");

         
    }


    //write a constructor for Maze that invokes the generateFood method with appropriate params if 0 < mazeType < 4.
    // this generate position of the special food 
    /* 
   public Maze(int mazeType, int mazeLength, int mazeWidth, long seed) {
    this.mazeType = mazeType;
    this.mazeLength = mazeLength;
    this.mazeWidth = mazeWidth;
    this.mazeSeed = seed;

    if (mazeType > 0 && mazeType < 4) {
        generateFood(seed, mazeLength, mazeWidth, mazeType);
    } else {
        System.out.println("Invalid maze type. Food will not be generated.");
    }
}
    */

    //DO NOT MODIFY THIS CODE
    private void generateFood(long seed, int mazeLength, int mazeWidth, int mazeType) {
        FoodGenerator generator = new FoodGenerator(seed);
        while(true) {
            int xFood = generator.generatePosition(1, mazeLength-2);
            int yFood = generator.generatePosition(2, mazeWidth-2);
            if ((mazeType == 1 && xFood <= yFood) || (mazeType ==2 && xFood >=yFood) || (mazeType ==3 && !(yFood%2 == 0 && xFood!= 1 && xFood!= mazeLength-2))){
                this.colPosFood = xFood;
                this.rowPosFood = yFood;
                break;
            }

        }
    }

}

