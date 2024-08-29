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
                } else if (i == pacManX && j == pacManY) {
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
                } else if (i == pacManX && j == pacManY) {
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
                } else if (i == pacManX && j == pacManY) {
                    System.out.print("P");  // PACMAN position
                } else {
                    System.out.print(".");  // Navigable path
                }
            }
            System.out.println();  // Move to the next row
        }
    }
    /*pacman position*/
    // public void pacmanPosition(char usrSelection, int mazeType) {
    //     switch(usrSelection) {
    //         case 'W':
    //             if(pacManY == 1) {
    //                 System.out.println("move not allowed"); //sample, edit as needed
    //             } else if (mazeType == 1 && col > row){
    //                 System.out.println("move not allowed, this is a wall position");
    //                 break;
    //             } else if (mazeType == 2 && col < row) {
    //                 System.out.println("move not allowed, this is a wall position");
    //                 break;
    //             } else if (mazeType == 3){
    //                 for (int i = 0; i < length; i++) {
    //                  for (int j = 0; j< width; j++) {
    //                     if(i == 0 || i == length) {
    //                          pacman should not be on these lines
    //                     } else if (i%2 != 0 && i != length) { 
    //                         if(j ==1 || j < width-2)
    //                             pacManY-- (pacman goes down)
    //                         -------reprint maze here and BREAK---------------
    //                     } else if( i%2 == 0 && i>0) {             //if pacman is on even line and the line below is not the hashtags
    //                         pacman will be on either j == 1 or on j == width -1 and going down is fine
    //                          pacManY--
    //                         -------reprint maze here and BREAK---------------
    //                     }
    //                  }
    //                 }                 
    //             }
    //             else {
    //                 col--;
    //          -------reprint maze here and BREAK---------------
    //                 break;
    //             }
    //              
    //         case 'S':
    //             if( pacManY == mazeLength -1) {
    //                 System.out.println("move not allowed, end of maze already");
    //                 break;
    //             } else if( mazeType == 1 ){
    //                 pacman can go down (pacManY++)
    //                 reprint maze with updated position
    //                 break;
    //             } else if (mazeType == 2 && pacManX < pacManY) {
    //                 pacman cannot go down because wall
    //                 do not reprint maze
    //                 break
    //             } else if (mazeType == 3) {
    //                 for (int i = 0; i < length; i++) {
    //                  for (int j = 0; j< width; j++) {
    //                     if(i == 0 || i == length) {
    //                          pacman should not be on these lines
    //                     } else if (i%2 != 0 && i != length) { 
    //                         if(j ==1 || j < width-2)
    //                             pacManY++ (pacman goes down)
    //                         -------reprint maze here and BREAK---------------
    //                     } else if( i%2 == 0 && i<length-1) {             //if pacman is on even line and the line below is not the hashtags
    //                         pacman will be on either j == 1 or on j == width -1 and going down is fine
    //                          pacManY++
    //                          reprint maze here and BREAK
    //                     }
    //                  }
    //                 }
    //             }
    //             col++;
    //      -------reprint maze here and BREAK---------------
    //             break;
    //         case 'A':
    //             if(pacManX == 1) {
    //                 System.out.println("not allowed first col already");
    //                 break;
    //             } else if (mazeType == 1 && pacManX ==1 ) {
    //                 System.out.println("move not allowed, pacman must stay inside maze boundary");
    //                 break;
    //             } else if (mazeType == 2 && pacManX == pacManY) {
    //                 System.out.println("move not allowed, this is a wall position");
    //                 break;
    //             } else if(mazeType == 3){
    //                 if(pacManY == 0 || pacManY == length || pacManY%2 == 0){
    //                     System.out.println("pacman cannot go left. illegal move")
    //                 }
    //             }
    //             else {
    //                pacManX--
    //         -------reprint maze here and BREAK---------------
    //                break
    //             }
    //         case 'D':
    //             if(pacManX == width-1) {
    //                 System.out.println("not allowed last col already, must stay inside boundary");
    //                 break;
    //             } else if (mazeType == 1 && pacManX == pacManY) {
    //                 System.out.println("move not allowed, this is a wall position");
    //                 break;
    //             } else if (mazeType == 2 && pacManX == width - 1) {
    //                 System.out.println("move not allowed, this is the maze boundary");
    //                 break;
    //             } else if (mazeType == 3) {
    //                 if(pacManY == 0 || pacManY == length || pacManY%2 == 0){
    //                     System.out.println("pacman cannot go right. illegal move")
    //                 }
    //             }
    //             else {
    //             pacManX++;
    //      -------reprint maze here and BREAK---------------
    //             break;
    //             }
    //     }
    /*
     * for a horizontal maze:
     * pacman cannot move to even numbered lines 0 && last line at all or cannot move to even numbered lines unless col != 1 or col = width-1
     * 
     * #############  0
     * #...........#  1
     * #.---------.#  2
     * #...........#  3
     * #.---------.#  4
     * #############  5
     * 
     * for (int i = 0; i < length; i++) {
     *  for (int j = 0; j< width; j++) {
     *     if(i%2 == 0 || i == length) {
     *          if(j == 1 || j == width - 2)
     *          pacman cannot go
     *      } else if (i%2 != 0 && i != length) {
     *          pacman can go
     *      }
     *  }
     * }
     * 
     * SWITCH CASE FOR GAMEENGINE IF-ELSE BLOCK (LINE NUMBER 110 IN GAMEEMGINE.JAVA)
     * switch(mazeNumber):
     *  case 1: maze.printLowerTriangle
     *  case 2: maze.printUpperTriangle
     *  case 3: maze.printHorizontal
     *  defailt: System.out.println("Invalid input try again") 
     * 
     */
    // }
     public void pacmanPosition(int row, int col, char playerInput, int mazeType, int mazeWidth, int mazeLength) {
    switch (playerInput) {
        case 'W': // Move up
            if (row == 1) {
                System.out.println("Move not allowed, top of the maze reached.");
            } else if (mazeType == 1 && col > row) {
                System.out.println("Move not allowed, this is a wall position (lower triangle).");
            } else if (mazeType == 2 && col < row) {
                System.out.println("Move not allowed, this is a wall position (upper triangle).");
            } else {
                row--; // Move up
            }
            break;

        case 'S': // Move down
            if (row == mazeLength - 2) { // Boundary check for bottom of the maze
                System.out.println("Move not allowed, bottom of the maze reached.");
            } else {
                row++; // Move down
            }
            break;

        case 'A': // Move left
            if (col == 1) {
                System.out.println("Move not allowed, left edge of the maze reached.");
            } else if (mazeType == 1 && col > row) {
                System.out.println("Move not allowed, this is a wall position (lower triangle).");
            } else if (mazeType == 2 && col < row) {
                System.out.println("Move not allowed, this is a wall position (upper triangle).");
            } else {
                col--; // Move left
            }
            break;

        case 'D': // Move right
            if (col == mazeWidth - 2) { // Boundary check for right edge of the maze
                System.out.println("Move not allowed, right edge of the maze reached.");
            } else if (mazeType == 1 && col > row) {
                System.out.println("Move not allowed, this is a wall position (lower triangle).");
            } else if (mazeType == 2 && col < row) {
                System.out.println("Move not allowed, this is a wall position (upper triangle).");
            } else {
                col++; // Move right
            }
            break;

        default:
            System.out.println("Invalid input! Use W, A, S, D to move.");
            break;
    }

    // Print the new position of PACMAN
    System.out.println("PACMAN's new position: (" + row + ", " + col + ")");
}


    /*food position*/
    private int colPosFood;
    private int rowPosFood;

    /*score/game related attributes*/
    public void scoreCard() {
        System.out.printf("|%8s|%8s|%8s|%8s|%n", "Game", "Hits", "Moves", "Score");
        System.out.printf("|%8s|%8s|%8s|%8s|%n", "========","========","========","========");
        System.out.printf("|%8s|%8s|%8s|%8s|%n", "1","2","3","4");

         
    }


    //write a constructor for Maze that invokes the generateFood method with appropriate params if 0 < mazeType < 4.
    // this generate position of the special food 
    /* 
    public Maze(mazeType) {
        gener
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

