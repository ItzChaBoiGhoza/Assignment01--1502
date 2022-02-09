package mru.game.model;

public class Player {
	
	/**
	 * This class represent each player record in the Database
	 * It is basically a model class for each record in the txt file
	 */
	
	String name;
	int balance;
	int numOfWins;
	
	
	public Player(String name, int balance, int numOfWins) {
		this.name = name;
		this.balance = balance;
		this.numOfWins = numOfWins;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void setWins(int numOfWins) {
		this.numOfWins = numOfWins;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getBalance() {
		return this.balance;
	}
	
	public int getWins() {
		return this.numOfWins;
	}
	
	/*
	 * toString method prints out the information 
	 * in the setter and getters
	 */
	public String toString() {
		return "Name: " + name + "," + " Balance: $" + balance + "," +" Number of Wins: " + numOfWins;
	}
	
	// create the format Name; ID; wins
	public String format() {
		return name + "," + balance + "," + numOfWins;
	}
}
