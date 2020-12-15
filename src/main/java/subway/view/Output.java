package subway.view;

import subway.screen.MainScreen;

public class Output {
    private MainScreen main;
	
    public Output() {
        main = new MainScreen();
    }
		
    public void printMainMenu() {
        main.printScreen();
    }   
}