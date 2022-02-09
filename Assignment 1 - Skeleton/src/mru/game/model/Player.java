package mru.game.model;

public class Player {
	
	/**
	 * This class represent each player record in the Database
	 * It is basically a model class for each record in the txt file
	 * 
	 * @author Denzel Pascual
	 */
	
	String name;
	int balance;
	int numOfWins;
	
	
	/**
	 * Constructor
	 * Sets name, balance, and number of wins
	 * 
	 * @param name
	 * @param balance
	 * @param numOfWins
	 */
	public Player(String name, int balance, int numOfWins) {
		this.name = name;
		this.balance = balance;
		this.numOfWins = numOfWins;
	}
	
	/**
	 * Name setter method
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Balance setter method
	 * 
	 * @param balance
	 */
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	/**
	 * Number of wins setter method
	 * @param numOfWins
	 */
	public void setWins(int numOfWins) {
		this.numOfWins = numOfWins;
	}
	
	/**
	 * Name getter method
	 * 
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Balance getter method
	 * 
	 * @return balance
	 */
	public int getBalance() {
		return this.balance;
	}
	
	/**
	 * Number of wins getter method
	 * 
	 * @return numOfWins
	 */
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
	
	/**
	 * create the format Name; ID; wins
	 * 
	 * @return format
	 */
	public String format() {
		return name + "," + balance + "," + numOfWins;
	}
}
