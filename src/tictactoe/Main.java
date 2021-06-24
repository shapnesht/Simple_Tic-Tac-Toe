package tictactoe;
import java.util.Scanner;

// In this prject we are creating a XOgame which can be played between 2 players.
    
// Main begins
    
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // creating and initialising grid with all the elements as '_'
        
        char[][] arr = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = '_';
            }
        }
        boolean result = true;
        int con = 1;
        
        //loop to input, check the input and update the grid after that.
        
        while (result) {
        System.out.println("---------");
        System.out.println("| " + arr[0][0] + " " + arr[0][1] + " " + arr[0][2] + " |");
        System.out.println("| " + arr[1][0] + " " + arr[1][1] + " " + arr[1][2] + " |");
        System.out.println("| " + arr[2][0] + " " + arr[2][1] + " " + arr[2][2] + " |");
        System.out.println("---------");
        System.out.println("Enter the coordinates: ");
        boolean bool = true;
        char move;
            
        // to change X to O and vice versa after each turn.
            
        if (con % 2 == 0) {
            move = 'O';
        } else{
            move = 'X';
        }
            
        // To take input until valid input is found else print valid rejection reason and ask user to re enter the input (coordinates).
            
        while (bool) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                if (a > 3 || b > 3){
                    System.out.println("Coordinates should be from 1 to 3!");
                    System.out.println("Enter the coordinates: ");
                    bool = true;
                } else if (arr[a - 1][b - 1] != '_') {
                    System.out.println("This cell is occupied! Choose another one!");
                    System.out.println("Enter the coordinates: ");
                    bool = true;

                } else if (a != 1 && a!= 2 && a != 3 || b != 1 && b != 2 && b != 3) {
                    System.out.println("You should enter numbers!");
                    System.out.println("Enter the coordinates: ");
                    bool = true;

                } else if (arr[a - 1][b - 1] == '_') {
                    arr[a - 1][b - 1] = move;
                    con++;
                    break;
                }
            }
            
            // Cases for winning if any one of the following is true one wins.
            
            int totalX = 0;
            int totalY = 0;
            int row1 = arr[0][0] + arr[0][1] + arr[0][2];
            int row2 = arr[1][0] + arr[1][1] + arr[1][2];
            int row3 = arr[2][0] + arr[2][1] + arr[2][2];
            int col1 = arr[0][0] + arr[1][0] + arr[2][0];
            int col2 = arr[0][1] + arr[1][1] + arr[2][1];
            int col3 = arr[0][2] + arr[1][2] + arr[2][2];
            int dia1 = arr[0][0] + arr[1][1] + arr[2][2];
            int dia2 = arr[0][2] + arr[1][1] + arr[2][0];
            
            // To count number of X an O in the grid at any condition.
            
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (arr[i][j] == 'X') {
                        totalX++;
                    } else if (arr[i][j] == 'O') {
                        totalY++;
                    }
                }
            }
            
            // Conditions to check if X wins.
            
            boolean xWins = (row1 == 264 || row2 == 264 || row3 == 264 ||
            dia1 == 264 || dia2 == 264 ||col1 == 264 || col2 == 264 || col3 == 264);
            
            // Conditions to check if O wins.
            
            boolean oWins = (row1 == 237 || row2 == 237 || row3 == 237 || dia1 == 237 || dia2 == 237 ||
            col1 == 237 || col2 == 237 || col3 == 237);
            
            // checking the status of the grid.
            
            if (xWins) {
                System.out.println("---------");
                System.out.println("| " + arr[0][0] + " " + arr[0][1] + " " + arr[0][2] + " |");
                System.out.println("| " + arr[1][0] + " " + arr[1][1] + " " + arr[1][2] + " |");
                System.out.println("| " + arr[2][0] + " " + arr[2][1] + " " + arr[2][2] + " |");
                System.out.println("---------");
                System.out.println("X wins");
                result = false;
                
            } else if (oWins) {
                System.out.println("---------");
                System.out.println("| " + arr[0][0] + " " + arr[0][1] + " " + arr[0][2] + " |");
                System.out.println("| " + arr[1][0] + " " + arr[1][1] + " " + arr[1][2] + " |");
                System.out.println("| " + arr[2][0] + " " + arr[2][1] + " " + arr[2][2] + " |");
                System.out.println("---------");
                System.out.println("O wins");
                result = false;
                
            } else if (totalX + totalY == 9) {
                System.out.println("---------");
                System.out.println("| " + arr[0][0] + " " + arr[0][1] + " " + arr[0][2] + " |");
                System.out.println("| " + arr[1][0] + " " + arr[1][1] + " " + arr[1][2] + " |");
                System.out.println("| " + arr[2][0] + " " + arr[2][1] + " " + arr[2][2] + " |");
                System.out.println("---------");
                System.out.println("Draw");
                result = false;

            }
        }
    }
}
