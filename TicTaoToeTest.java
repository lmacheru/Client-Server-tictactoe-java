package Sixteen32;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TicTaoToeTest {

    private Server board;

   


    @Before
    public void setUp() {
        board = new Server();
    }
    
    @Test
    public void newBoardNotFinished() {
        board = new Server();
        assertEquals(board.isFinished(), false);
    }


    @Test
    public void newBoardisEmpty()  {
        assertEquals(board.isEmpty(), true);
    }


    @Test
    public void afterFirstMoveBoardIsNotEmpty(){
        board.move(1, 1);

        assertEquals(board.isEmpty(), false);
    }


    @Test
    public void playerChanges(){
        board.next_player();

        assertEquals(board.next_player(), "x");
    }
   

    @Test
    public void afterSecondMoveBoardIsNotEmpty()  {
        board.move(1, 1);
        board.move(1, 2);

        assertEquals(board.isEmpty(), false);
    }


    @Test
    public void after5MovesGameIsFinished()  {
        /**Eg
         * XXX
         * OO-
         * ---
         */
        board.move(1, 1);
        board.move(2, 1);
        board.move(1, 2);
        board.move(2, 2);
        board.move(1, 3);

        assertEquals(board.isFinished(), true);

    }

    @Test
    public void after9MovesGameIsFinished() {
        /**Eg
         * XXO
         * OOX
         * XOX---
         */
        board.move(1, 1);
        board.move(1, 2);
        board.move(1, 3);
        board.move(2, 1);
        board.move(2, 2);
        board.move(2, 3);
        board.move(3, 1);
        board.move(3, 2);
        board.move(3, 3);

        assertEquals(board.isFinished(), true);

    }

    }
