package mru.game.view;

import java.util.Scanner;

import mru.game.model.Player;

public class AppMenu {
	
	Scanner input;
	
	public AppMenu() {
		input = new Scanner(System.in);
	}

	/**
	 * This class will be used to show the menus and sub menus to the user
	 * It also prompts the user for the inputs and validates them 
	 */
	public int showMainMenu() {
		System.out.println("Choose one of the option:\n");
		System.out.println("\t1. Play Game");
		System.out.println("\t2. Search");
		System.out.println("\t3. Save and Exit\n");
		System.out.print("Enter your option: ");
		int option = input.nextInt();
		return option;
	}
	
	/**
	 * This class will be use to show the sub menu to the user
	 * Prompts the user for inputs and validate them
	 */
	public char showSubMenu () {
		System.out.println("Select one option:\n");
		System.out.println("\t(T) Top Player");
		System.out.println("\t(S) Search by Name");
		System.out.println("\t(B) Back to Main Menu\n");
		System.out.print("Enter a character here: ");
		char option = input.nextLine().toLowerCase().charAt(0);
		return option;
	}
	
	public String promptName() {
		System.out.print("Enter a name: ");
		String name = input.nextLine().trim();
		return name;
	}
	
	public void showPlayer(Player ply) {
		System.out.println(ply);
	}
	
	public String promptId() {
		System.out.println("Enter Player Name: ");
		String name = input.nextLine().trim();
		return name;
	}

	public int ShowAppMenu() {
		int guess;
		
		System.out.println("Please enter a number between 1 and 10: ");
		guess = input.nextInt();
		
		return guess;
	}

	public void showGreaterMsg() {
		System.out.println("My number is greater than yours!");
	}

	public void showLesserMsg() {
		System.out.println("My number is less than yours!");
	}

	public void showCong() {
		System.out.println("You Win");
	}

	public void showSorryMsg(int number) {
		System.out.println("You Lose! the number is " + number);
	}
	
}
