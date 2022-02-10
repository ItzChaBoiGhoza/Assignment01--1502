package mru.game.view;

import java.util.Scanner;

import mru.game.model.Player;

public class GameOptions {
	
	private Scanner input;
	Player player;
	
	public GameOptions() {
		input = new Scanner(System.in);
	}
	
	/**
	 * Method on betAmount
	 * @return bet
	 */
	public int betAmount() {
		
		int bet = 0;
		boolean validBet = false;
		while(validBet == false) {
			System.out.print("How much do you want to bet this round? ");
			if(!input.hasNextInt()) {
				bet = input.nextInt();
				input.nextLine();
				if(bet > player.getBalance()) {
					System.out.println("You do not have that much balance");
				}
				if(bet <= player.getBalance()) {
					validBet = true;
				}
			} else {
				System.out.println("You do not have enough balance");
				input.nextLine();
			}
		}
		
		return bet;
	}
	
	/**
	 * Method to display gamemenu
	 * @return option
	 */
	public char gameMenu() {
		System.out.println("Who do you want to bet on?");
		System.out.println("\t (P) Player Wins");
		System.out.println("\t (B) Banker Wins");
		System.out.println("\t (T) Tie Game");
		System.out.print("Enter your choice: ");
		char option = input.nextLine().toLowerCase().charAt(0);
		return option;
	}
	
}