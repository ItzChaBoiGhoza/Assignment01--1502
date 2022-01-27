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
	 * A method to load the txt file into an arraylist (if it exists, so you check if the txt file exists first)
	 * A save method to store the arraylist into the the txt file 
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
	 * 
	 */
	private void launchApplication() throws IOException{
		
		boolean flag = true;
		int option;
		while (flag) {
			option = appMen.showMainMenu();
			
			switch (option) {
			case 1:
				playGame();
				break;
			case 2:
				search();
				break;
			case 3:
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
		
		option =appMen.showSubMenu();
		switch (option) {
		case 't':
			findTopPlayer();
			break;
		case 's':
			String name = appMen.promptName(); // catches the name
			Player ply = searchByName(name);
			appMen.showPlayer(ply);
			break;
		case 'b':
			break;
		}
		
	}

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
			pw.println(p.format());
		}
		
		pw.close();
		
	}

	/**
	 * 
	 * @throws Exception
	 */
	private void loadData() throws Exception {
		File db = new File(FILE_PATH);
		String currentLine;
		String[] splittedLine;
		
		if(db.exists()) {
			Scanner fileReader = new Scanner(db);
			
			while(fileReader.hasNextLine()) {
				currentLine = fileReader.nextLine();
				splittedLine = currentLine.split(";");
				Player p = new Player(splittedLine[0], splittedLine[1], Integer.parseInt(splittedLine[2]));
				players.add(p);
			}
			
			fileReader.close();
		}
	}

}
