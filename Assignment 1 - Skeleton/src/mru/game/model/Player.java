package mru.game.model;

public class Player {
	
	/**
	 * This class represent each player record in the Database
	 * It is basically a model class for each record in the txt file
	 */
	
	String name;
	String id;
	int numOfWins;
	
	
	public Player(String name, String id, int numOfWins) {
		this.name = name;
		this.id = id;
		this.numOfWins = numOfWins;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setWins(int numOfWins) {
		this.numOfWins = numOfWins;
	}
	
	public String getName() {
		return name;
	}
	
	public String getId() {
		return id;
	}
	
	public int getWins() {
		return numOfWins;
	}
	
	/*
	 * toString method prints out the information 
	 * in the setter and getters
	 */
	public String toString() {
		return "Name: " + name + " ID: " + id + " Number of Wins: " + numOfWins;
	}
	
	// create the format Name; ID; wins
	public String format() {
		return name + "," + id + "," + numOfWins;
	}
}
