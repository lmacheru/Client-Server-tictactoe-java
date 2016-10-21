package Sixteen32;

import java.io.IOException;

import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Client {
    private static Scanner scanner;
	private static Socket socket;
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		 scanner = new Scanner(System.in);
		 
		System.out.println( "please enter your sockek number");
		int Snumber =scanner.nextInt();
		
		
		socket = new Socket("localhost",Snumber);
		System.out.println( "Client connected");
		
        scanner = new Scanner(System.in);
        System.out.println("-----------------------");
        System.out.println("  TIC-TAC-TOE GAME");
        System.out.println("-----------------------");
        System.out.println("Please select a option");
        System.out.println();
        System.out.println("1. Start Game");
        System.out.println("2. Exit");
      
        switch (scanner.nextInt()){
            case 1:	
                Server board = new Server();
                scanner.nextLine();
                while (board.isFinished()!=true){
                    board.printBoard();
                    System.out.println("Choose the number position Eg \"pos(1 2)\" or (0 0)to end game");                                
                        int x = scanner.nextInt();
                        int y = scanner.nextInt();
                       
                        if(x == 0 || y== 0){
                        	System.out.println( "Game ended ");
                        	System.out.println( "Connection ended............");
                        	System.exit(0);
                        }
                        else
                        board.move(x,y);   
                        
                }
                board.printBoard();
                System.out.println("The Game is finished");
                System.out.println("Numbers of moves: "+Server.getNumbersOfMoves());
                System.out.println("Thanks for playing the game made by 1632 Guys ");
                break;
            case 2:
            	System.out.println("Client Stoped the game");
                System.out.println( "Connection ended............");
                System.exit(0);
                
                break;
        }

    }
}
