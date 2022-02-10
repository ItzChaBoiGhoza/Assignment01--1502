package mru.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mru.game.controller.Card;

class SuitsandranksTest {
	
	/**
	 * The test shows that all suits cards can be printed
	 * As well demonstrates that the number ranking for Ace, Jack, Queen, And King(1, 11, 12, 13)
	 * Can be printed into a string using the toString method
	 */

	@Test
	void test() {
		Card test1 = new Card(1, "Diamonds");
		String output1 = test1.toString();
		assertEquals("Ace of Diamonds", output1);

		Card test2 = new Card(11, "Clubs");
		String output2 = test2.toString();
		assertEquals("Jack of Clubs", output2);

		Card test3 = new Card(12, "Hearts");
		String output3 = test3.toString();
		assertEquals("Queen of Hearts", output3);

		Card test4 = new Card(13, "Spades");
		String output4 = test4.toString();
		assertEquals("King of Spades", output4);
	}

}
