package mru.game.controller;

import java.util.Random;

import mru.game.view.AppMenu;

public class Guess {
	Random rnd;
	AppMenu am;
	
	public Guess() {
		rnd = new Random();
		am = new AppMenu();
	}

	public boolean launchGame() {
		int guess;
		int compNumber = rnd.nextInt(10) + 1;
		boolean win = false;
		
		for(int i = 1; i <= 3; i++) {
			guess = am.ShowAppMenu();
			
			if(compNumber > guess) {
				am.showGreaterMsg();
			} else if(compNumber < guess) {
				am.showLesserMsg();
			} else {
				am.showCong();
				win = true;
				break;
			}
		}
		
		if(!win) {
			am.showSorryMsg(compNumber);
		}
		
		return win;
	}
}
