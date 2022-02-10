package mru.game.controller;

import java.util.ArrayList;

import mru.game.model.Player;
import mru.game.view.GameOptions;

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
	
	public PuntoBancoGame(int money) throws Exception {
		cd = new CardDeck();
		go = new GameOptions();
		players = new ArrayList<>();
		gm = new GameManager();
		cashTotal = money;
		playGame();
	}
	
	public void playGame() {
		startGame();
		go = new GameOptions();
		
		go.gameMenu();
	}
	
	public int getWins() {
		return wins;
	}
	
	public void startGame() {
		Card playerHand; 
		Card bankerHand;
		
		playerHand = cd.getDeck().remove(0);
		playerHand = cd.getDeck().remove(0);
		
		bankerHand = cd.getDeck().remove(0);
		bankerHand = cd.getDeck().remove(0);
	}

	public void playerScore(int rank) {
		
	}
}