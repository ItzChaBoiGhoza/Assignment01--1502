package mru.game.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import mru.game.model.Player;
import mru.game.view.AppMenu;

public class GameManager {
	
	/* In this class toy'll need these methods:
	 * A constructor
	 * A method to load the text file into an array list (if it exists, so you check if the txt file exists first)
	 * A save method to store the array list into the the text file 
	 * A method to search for a player based their name
	 * A method to find the top players
	 * Depending on your designing technique you may need and you can add more methods here 
	 */
	
	private final String FILE_PATH = "res/CasinoInfo.txt";
	ArrayList<Player> players;
	AppMenu appMen;
	
	Guess gs;

	/**
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
	 * Responsible for running the whole Game
	 * Loops until the user hits save and exit
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
	
	private void playGame() {
		String name = appMen.promptName();
		Player p = searchByName(name); // check if the name exist
		
		//if p equals to null that means the player is new player
		if (p == null) {
			String id = appMen.promptId();
			players.add(new Player (name, id, 0));
			
		}
		
		gs = new Guess();
		boolean win = gs.launchGame();
		if (win) {
			for (Player pl : players) {
				if (pl.getName().equals(name)) {
					int num = pl.getWins();
					pl.setWins(num + 1);
				}
			}
		}
		
	}

	private void search() {
		char option; 
		
		//calls the showSubMenu method
		option =appMen.showSubMenu();
		switch (option) {
		case 't':
			findTopPlayer();
			break;
		case 's':
			String name = appMen.promptName(); // catches the name
			Player ply = searchByName(name); //calls searchByName method
			appMen.showPlayer(ply);
			break;
		case 'b':
			break;
		}
		
	}
	
	/*
	 * if the player exist it will work
	 * if he/she doesn't exist it will return null
	 * null means that player doesn't exist
	 * @param name
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

	private void findTopPlayer() {
		
		
	}

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
	 * Responsible for checking if the file exist or not
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
				//splittedLine[1] = ID, 
				//Integer.parseInt(splittedLine[2] = number of wins
				//integer parseInt converts  String splittedLine[2] into an integer
				Player p = new Player(splittedLine[0], splittedLine[1], Integer.parseInt(splittedLine[2]));
				players.add(p);
			}
			
			fileReader.close();
		}
	}

}
