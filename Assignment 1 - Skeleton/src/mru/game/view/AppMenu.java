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
	 * takes in integer
	 */
	public int showMainMenu() {
		System.out.println("Select one option:\n");
		System.out.println("\t1. Play Game");
		System.out.println("\t2. Search");
		System.out.println("\t3. Save and Exit\n");
		System.out.print("Enter a number here: ");
		int option = input.nextInt();
		
		//plush out the scanner buffer
		input.nextLine();
		return option;
	}
	
	/**
	 * This class will be use to show the sub menu to the user
	 * Prompts the user for inputs and validate them
	 * takes in char
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
	/*
	 * This method is responsible for asking for:
	 * The players name
	 * Recording the name
	 * Returning the name to whoever calls it
	 */
	public String promptName() {
		System.out.print("Enter a name: ");
		String name = input.nextLine().trim();
		return name;
	}
	
	public void showPlayer(Player ply) {
		if (ply !=null) {
			System.out.println(ply);
		} else {
			System.out.println("No record found for that name ");
		}
	}
}
