package mru.game.controller;

import java.util.ArrayList;

import mru.game.model.Player;
import mru.game.view.GameOptions;

//Note: not completed yet
public class PuntoBancoGame extends CardDeck{
	
	/**
	 * In this class you implement the game
	 * You should use CardDeck class here
	 * See the instructions for the game rules
	 */
	
	char winChoice; 
	private int playerDeck; 
	private int bankerDeck; 
	int cashTotal; 
	int wins = 0; 
	
	CardDeck cd; 
	GameOptions go; 
	GameManager gm; 
	ArrayList<Player> players; 
	
	/**
	 * Constructor
	 * @param money
	 * @throws Exception
	 */
	public PuntoBancoGame(int money) throws Exception {
		cd = new CardDeck();
		go = new GameOptions();
		players = new ArrayList<>();
		gm = new GameManager();
		cashTotal = money;
		playGame();
	}
	
	/**
	 * playGame method
	 */
	public void playGame() {
		startGame();
		go = new GameOptions();
		
		go.gameMenu();
	}
	
	/**
	 * Method to getWins for the user
	 * @return
	 */
	public int getWins() {
		return wins;
	}
	
	/**
	 * Initialization of the game
	 * Get card for the player and banker
	 */
	public void startGame() {
		Card playerHand; 
		Card bankerHand;
		
		//Deal two cards to the player
		playerHand = cd.getDeck().remove(0);
		playerHand = cd.getDeck().remove(0);
		
		//Deal two cars to the banker
		bankerHand = cd.getDeck().remove(0);
		bankerHand = cd.getDeck().remove(0);
	}
}