package happyToken;

import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class HappyTokenBoardTest {
	
	@Test
	public void test(){
		// test token creation
		Token t = new Token(TokenColor.BLACK);
		Token y = new Token(TokenColor.WHITE);
		assertEquals("White token should be white", TokenColor.BLACK, t.getColor());
		assertEquals("Black token should be black", TokenColor.WHITE, y.getColor());
		
		// test board creation
		HappyTokenBoard myBoard = new HappyTokenBoard();

		// test bad token adds
		assertEquals("Should not be able to add token", false, myBoard.addTokenToPosition(TokenColor.BLACK, 5));
		assertEquals("Should not be able to add token", false, myBoard.addTokenToPosition(TokenColor.WHITE, -1));
		System.out.println(Arrays.toString(myBoard.viewStatus()));
		
		// test empty board
		myBoard.reset();
		assertEquals("Board should match", "[0, 0, 0, 0, 0, 0, -1]", Arrays.toString(myBoard.viewStatus()));

		// test good token adds
		assertEquals("Should be able to add token", true, myBoard.addTokenToPosition(TokenColor.WHITE, 0));
		assertEquals("Should be able to add token", true, myBoard.addTokenToPosition(TokenColor.BLACK, 0));
		assertEquals("Should be able to add token", true, myBoard.addTokenToPosition(TokenColor.WHITE, 0));
		assertEquals("Should be able to add token", true, myBoard.addTokenToPosition(TokenColor.BLACK, 0));
		assertEquals("Should be able to add token", true, myBoard.addTokenToPosition(TokenColor.WHITE, 0));

		assertEquals("Should be able to add token", true, myBoard.addTokenToPosition(TokenColor.WHITE, 1));
		assertEquals("Should be able to add token", true, myBoard.addTokenToPosition(TokenColor.WHITE, 1));
		assertEquals("Should be able to add token", true, myBoard.addTokenToPosition(TokenColor.WHITE, 1));
		assertEquals("Should be able to add token", true, myBoard.addTokenToPosition(TokenColor.WHITE, 1));
		assertEquals("Should be able to add token", true, myBoard.addTokenToPosition(TokenColor.BLACK, 1));
		assertEquals("Should be able to add token", true, myBoard.addTokenToPosition(TokenColor.BLACK, 1));

		assertEquals("Should be able to add token", true, myBoard.addTokenToPosition(TokenColor.WHITE, 2));
		assertEquals("Should be able to add token", true, myBoard.addTokenToPosition(TokenColor.BLACK, 2));
		assertEquals("Should be able to add token", true, myBoard.addTokenToPosition(TokenColor.BLACK, 2));

		System.out.println(Arrays.toString(myBoard.viewStatus()));
		assertEquals("Board should match", "[2, 3, 2, 4, 2, 1, -1]", Arrays.toString(myBoard.viewStatus()));


		//test board position logic through mixed good and bad adds
		myBoard.reset();
		assertEquals("Should be able to add token", true, myBoard.addTokenToPosition(TokenColor.BLACK, 0));
		assertEquals("Should not be able to add token", false, myBoard.addTokenToPosition(TokenColor.BLACK, 0));
		assertEquals("Should be able to add token", true, myBoard.addTokenToPosition(TokenColor.WHITE, 0));
		assertEquals("Should be able to add token", true, myBoard.addTokenToPosition(TokenColor.BLACK, 0));
		assertEquals("Should be able to add token", true, myBoard.addTokenToPosition(TokenColor.WHITE, 0));
		assertEquals("Should not be able to add token", false, myBoard.addTokenToPosition(TokenColor.WHITE, 0));

		System.out.println(Arrays.toString(myBoard.viewStatus()));
		assertEquals("Board should match", "[2, 2, 0, 0, 0, 0, -1]", Arrays.toString(myBoard.viewStatus()));

		assertEquals("Should be able to add token", true, myBoard.addTokenToPosition(TokenColor.BLACK, 1));
		assertEquals("Should not be able to add token", false, myBoard.addTokenToPosition(TokenColor.WHITE, 1));
		assertEquals("Should be able to add token", true, myBoard.addTokenToPosition(TokenColor.BLACK, 1));
		assertEquals("Should be able to add token", true, myBoard.addTokenToPosition(TokenColor.WHITE, 1));
		assertEquals("Should not be able to add token", false, myBoard.addTokenToPosition(TokenColor.BLACK, 1));
		assertEquals("Should be able to add token", true, myBoard.addTokenToPosition(TokenColor.WHITE, 1));
		assertEquals("Should be able to add token", true, myBoard.addTokenToPosition(TokenColor.BLACK, 1));

		System.out.println(Arrays.toString(myBoard.viewStatus()));
		assertEquals("Board should match", "[2, 2, 3, 2, 0, 0, -1]", Arrays.toString(myBoard.viewStatus()));

		assertEquals("Should be able to add token", true, myBoard.addTokenToPosition(TokenColor.BLACK, 2));
		assertEquals("Should be able to add token", true, myBoard.addTokenToPosition(TokenColor.WHITE, 2));
		assertEquals("Should be able to add token", true, myBoard.addTokenToPosition(TokenColor.WHITE, 2));
		assertEquals("Should not be able to add token", false, myBoard.addTokenToPosition(TokenColor.BLACK, 2));
		assertEquals("Should be able to add token", true, myBoard.addTokenToPosition(TokenColor.WHITE, 2));
		assertEquals("Should be able to add token", true, myBoard.addTokenToPosition(TokenColor.BLACK, 2));
		assertEquals("Should not be able to add token", false, myBoard.addTokenToPosition(TokenColor.WHITE, 2));
		assertEquals("Should be able to add token", true, myBoard.addTokenToPosition(TokenColor.BLACK, 2));

		System.out.println(Arrays.toString(myBoard.viewStatus()));
		assertEquals("Board should match", "[2, 2, 3, 2, 3, 3, -1]", Arrays.toString(myBoard.viewStatus()));


		// test email functionality
		myBoard.reset();
		for (int i = 0; i<10; i++) {
			if (i % 2 == 0)
				myBoard.addTokenToPosition(TokenColor.WHITE, 0);
			else
				myBoard.addTokenToPosition(TokenColor.BLACK, 0);
		}

		System.out.println(Arrays.toString(myBoard.viewStatus()));
		assertEquals("Board should match", "[5, 5, 0, 0, 0, 0, -1]", Arrays.toString(myBoard.viewStatus()));

		System.out.println("Done with test!");
	}
}