package mru.game.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import mru.game.model.Player;
import mru.game.view.AppMenu;

public class GameManager {
	
	/**
	 * The GameManager class is what runs the program. 
	 * The menu and sub menu is controlled in this class
	 * As well as launching the game
	 *
	 * @author Denzel Pascual
	 */

	/*
	 * The final instance "FILE_PATH" locates the txt file "CasinoInfo.txt"
	 */
	private final String FILE_PATH = "res/CasinoInfo.txt";
	Scanner input = new Scanner(System.in);
	ArrayList<Player> players;
	AppMenu appMen;
	String playerName;
	

	/**
	 * The method GameManager calls 2 methods, 
	 * loadData(); and launchApplication();
	 * 
	 * @throws Exception
	 */
	public GameManager() throws Exception {
		players = new ArrayList<>();
		appMen = new AppMenu();
		loadData();
		launchApplication();
	}
	
	/**
	 * The method launchApplication is responsible for running the Game.
	 * Calls showMainMenu from the appMenu Class();
	 * Displays three choices; 1PlayGame, 2Search, 3Save and Exit
	 * Loops until the user hits save and exit
	 * 
	 * @throws IOException
	 */
	private void launchApplication() throws IOException{
		
		boolean flag = true;
		int option;
		while (flag) {
			//read the appMenu method
			option = appMen.showMainMenu();
			
			switch (option) {
			
			case 1:
				//Calls playGame Method
				playGame();
				break;
			case 2:
				//Calls search Method
				search();
				break;
			case 3:
				//Call save Method
				save();
				flag = false;
			}
		}
	}
	
	/**
	 * This method call promptName from appMenu class
	 * It will display to the user "Enter your name", as well checks if the name exists
	 * otherwise it will say null and create a new player
	 */
	
	// Note: not completed yet
	private void playGame() {
		String name = appMen.promptName();
		playerName = name;
		Player p = searchByName(name); // check if the name exist
		int balance;
		
		//if p equals to null that means the player is new player
		if (p == null) {
			balance = 100;
			players.add(new Player (name, balance, 0));
			String newPlayer = "Welcome " + name + " Your current balance is " + balance + " $";
			System.out.println(newPlayer);
		} else {
			balance = p.getBalance();
			playerName = p.getName();
			String welcome = "Welcome Back " + name + " Your balance is " + balance + " $";
			System.out.println(welcome);
		}
	}
	
	/**
	 * This method calls the showSubMenu from the appMenu class
	 * This method will display the sub menu
	 * It will prompt the user for three choices, find top player, search player name, and a return to main menu option
	 * 
	 */
	private void search() {
		char option; 
		
		//calls the showSubMenu method
		option =appMen.showSubMenu();
		switch (option) {
		case 't':
			findTopPlayer();
			System.out.println("");
			System.out.println("Press Enter To Continue: ");
			input.nextLine();
			break;
		case 's':
			String name = appMen.promptName(); // catches the name
			Player ply = searchByName(name); //calls searchByName method
			appMen.showPlayer(ply);
			System.out.println("");
			System.out.println("Press Enter To Continue: ");
			input.nextLine();
			break;
		case 'b':
			break;
		}
		
	}
	
	/*
	 * This method searches for the players name from the getName method in the Player Class
	 * If the player exist it will function, otherwise it will return null
	 * null means that player doesn't exist
	 * 
	 * @param name
	 * @return ply
	 */
	private Player searchByName(String name) {
        Player ply = null; // if it return null their is no player with that name
		
		//array list called players
		for (Player p : players) {
			if (p.getName().equals(name)) {
				ply = p;
				break; // not important if you find the name break out
			}
		}
		return ply;
	}
	
	/**
	 * This method finds the top player with the most wins in the text file "CasinoInfo.txt"
	 */
	private void findTopPlayer() {
		
		int maxOne = 0;
		String n1 = "";
		int maxTwo = 0;
		String n2 = "";
		
		for(Player p : players) {
			if(maxOne < p.getWins()) {
				maxTwo = maxOne;
				maxOne = p.getWins();
				n1 = p.getName();
			} else if(maxTwo < p.getWins()) {
				maxTwo = p.getWins();
				n2 = p.getName();
			}
		}
		
		if(maxOne > maxTwo) {
			System.out.println("NAME: " + n1 + ", " + "#WINS: " + maxOne);
		} else {
			System.out.println("NAME" + " " + "# WINS" );
			System.out.println(n1 + " " + maxOne);
			System.out.println(n2 + " " + maxTwo);
		}
		
		
	}

	/**
	 * This method saves the game and update the existing file text
	 * As well as exits the program
	 * 
	 * @throws IOException
	 */
	private void save() throws IOException {
		File db = new File(FILE_PATH);
		PrintWriter pw = new PrintWriter(db);
		
		System.out.println("Saving your game");
		
		for(Player p: players) {
			//.format calls format method
			//format the object then prints it to the file
			pw.println(p.format());
		}
		
		pw.close();
		
	}

	/**
	 * This method load the data from "CasinoInfo.txt" and reads the file
	 * Responsible for checking if the file exist or not
	 * 
	 * @throws Exception
	 */
	private void loadData() throws Exception {
		File db = new File(FILE_PATH);
		String currentLine;
		String[] splittedLine;
		
		//db.exists check whether the file exist or not
		if(db.exists()) {
			//Scan the file and throws the memory in fileReader
			Scanner fileReader = new Scanner(db);
			
			//Read all of the line in the database
			//Reads the line and put it in a array list
			while(fileReader.hasNextLine()) {
				currentLine = fileReader.nextLine();
				
				//.split(",") splits the array in the res folder
				//by reading the comma
				splittedLine = currentLine.split(",");
				
				//Player comes from Player class
				//The constructor of the Player Class takes in the name, id, and number of wins
				//splittedLine[0] = name, 
				//Integer.parseInt(splittedLine[1] = Balance, 
				//Integer.parseInt(splittedLine[2] = number of wins
				//integer parseInt converts  String splittedLine[1] and [2] into an integer
				Player p = new Player(splittedLine[0], Integer.parseInt(splittedLine[1]), Integer.parseInt(splittedLine[2]));
				players.add(p);
			}
			
			fileReader.close();
		}
	}

}
