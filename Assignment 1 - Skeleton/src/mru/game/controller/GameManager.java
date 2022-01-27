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

	/**
	 * 
	 * @throws Exception
	 */
	public GameManager() throws Exception {
		players = new ArrayList<>();
		appMen = new AppMenu();
		loadData();
		lanuchApplication();
	}
	
	/**
	 * 
	 */
	private void lanuchApplication() throws IOException{
		boolean flag = true;
		int option;
		
		while(flag) {
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
		
	}

	private void search() {
		char option; 
		
		option =appMen.showSubMenu();
		switch (option) {
		case 't':
			findTopPlayer();
			break;
		case 's':
			Player ply = searchByName();
			appMen.showPlayer(ply);
			break;
		case 'b':
			break;
		}
		
	}

	private Player searchByName() {
		String name = appMen.promptName();
		Player ply = null;
		
		
		for(Player p: players) {
			if(p.getName().equals(name)) {
				ply = p;
				break;
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
