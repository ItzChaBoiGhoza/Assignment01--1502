package mru.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mru.game.controller.Card;

class SuitsandranksTest {

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
