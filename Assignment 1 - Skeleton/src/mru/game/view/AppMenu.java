package mru.game.view;

import java.util.Scanner;

public class AppMenu {
	
	Scanner input;
	
	public AppMenu() {
		input = new Scanner(System.in);
	}

	/**
	 * This class will be used to show the menus and sub menus to the user
	 * It also prompts the user for the inputs and validates them 
	 */
	public void showMainMenu() {
		System.out.println("Choose one of the option:\n");
		System.out.println("\t1. Play Game");
		System.out.println("\t2. Search");
		System.out.println("\t3. Save and Exit\n");
		System.out.print("Enter your option: ");
	}
	
	
}
