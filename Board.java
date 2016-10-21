package Sixteen32;


import java.util.Arrays;
import java.util.List;

public class Board {

    private boolean empty = true;
    private String[][] matrix = {{"", "", ""}, {"", "", ""}, {"", "", ""}};
    private static int numbersOfMoves;
    private String Player = "x";
    
    
    public String next_player() 
     { 
     	if(Player == "x") 
     		Player = "o"; 
    		else 
     			Player = "x";
		return Player; 
     
     
     } 

    
    
    public boolean isFinished() {
        if (allCellsAreOccupied())
            return true;

        return thereIsThreeElementsInARow();
    }


    private boolean allCellsAreOccupied() {
        for (int i = 0; i < matrix.length; i++) {
            List<String> fila = Arrays.asList(matrix[i]);
            if (fila.contains("")) {
                return false;
            }
        }

        return true;
    }

    public static int getNumbersOfMoves() {
        return numbersOfMoves;
    }

    private boolean thereIsThreeElementsInARow() {
        String pos11 = matrix[0][0];
        String pos12 = matrix[0][1];
        String pos13 = matrix[0][2];
        String pos21 = matrix[1][0];
        String pos22 = matrix[1][1];
        String pos23 = matrix[1][2];
        String pos31 = matrix[2][0];
        String pos32 = matrix[2][1];
        String pos33 = matrix[2][2];

        return
                //horizontal
                		pos11.equals(pos12) && pos11.equals(pos13) && !"".equals(pos11) ||
                        pos21.equals(pos22) && pos21.equals(pos23) && !"".equals(pos21) ||
                        pos31.equals(pos32) && pos31.equals(pos33) && !"".equals(pos31) ||
                        //vertical
                        pos11.equals(pos21) && pos11.equals(pos31) && !"".equals(pos11) ||
                        pos12.equals(pos22) && pos12.equals(pos32) && !"".equals(pos12) ||
                        pos13.equals(pos23) && pos13.equals(pos33) && !"".equals(pos13) ||
                        //diagonal
                        pos11.equals(pos22) && pos11.equals(pos33) && !"".equals(pos11) ||
                        pos31.equals(pos22) && pos31.equals(pos13) && !"".equals(pos31);
    }


    public boolean isEmpty() {
        return empty;
    }

    public void printBoard(){
        for (int i = 0; i <matrix.length ; i++) {
            System.out.print(" | ");
            for (int j = 0; j <matrix.length ; j++) {
                System.out.print(matrix[i][j]+" | ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public void move(int x, int y) {
        if(x > matrix.length || y > matrix.length){
            System.out.println( "I told you");  ;
        }
        if (!"".equals(matrix[x - 1][y - 1])) {
            System.out.println("This position is occupied");
        }
        
        
        matrix[x - 1][y - 1] = next_player();
        

        numbersOfMoves++;

        empty = false;
    }


    public String getValueAt(int x, int y) {
        return matrix[x - 1][y - 1];
    }


    
}

