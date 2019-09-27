package test;

import static org.junit.Assert.*;
import main.TicTacToe;

import org.junit.Before;
import org.junit.Test;

public class TicTacToeTest {

	TicTacToe ticTacToe;

	@Before
	public void initializeTicTacToe()
	{
		ticTacToe=new TicTacToe();
	}

	@Test
	public void testGameStartsWithX()
	{
		assertEquals("{{-,-,-},{-,-,-},{-,-,X}}",ticTacToe.move(2, 2));	
	}

	@Test
	public void testXAndOPlayAlternately()
	{
		assertEquals("{{-,X,-},{-,-,-},{-,-,-}}",ticTacToe.move(0, 1));	
		assertEquals("{{-,X,O},{-,-,-},{-,-,-}}",ticTacToe.move(0, 2));
	}

	@Test
	public void testDuplicateMove()
	{
		assertEquals("{{-,X,-},{-,-,-},{-,-,-}}",ticTacToe.move(0, 1));	
		assertEquals("Position is already occupied.",ticTacToe.move(0, 1));
	}

	@Test
	public void testReturnGameStatusWinRow()
	{
		assertEquals("{{X,-,-},{-,-,-},{-,-,-}}",ticTacToe.move(0, 0));
		assertEquals("{{X,-,-},{O,-,-},{-,-,-}}",ticTacToe.move(1, 0));
		assertEquals("{{X,X,-},{O,-,-},{-,-,-}}",ticTacToe.move(0, 1));
		assertEquals("{{X,X,-},{O,-,O},{-,-,-}}",ticTacToe.move(1, 2));
		assertEquals("{{X,X,X},{O,-,O},{-,-,-}}",ticTacToe.move(0, 2));
		assertEquals("X is the winner.",ticTacToe.returnGameStatus());
	}

}
