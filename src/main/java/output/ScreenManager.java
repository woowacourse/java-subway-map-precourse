package output;

import input.Input;
import output.screen.MainScreen;
import output.screen.ManagementScreen;

import java.util.Scanner;

public class ScreenManager {
    final Scanner scanner;
    final Input input;
    final MainScreen mainScreen = new MainScreen();
    private Menu selectedMenu;
    private boolean reTry = true;

    public ScreenManager(Scanner scanner){
        this.scanner = scanner;
        input = new Input(scanner);
    }

    public void startMainScreen(){
        while(reTry) {
            mainScreen.visualize();
            mainScreen.logic(input);
            logic();
        }
    }

    private void logic(){
        ManagementScreen managementScreen = null;
        selectedMenu = mainScreen.getSelectedScreen();
        if(selectedMenu == Menu.SUBWAY_MAP){

        }
        if(selectedMenu == Menu.QUIT){
            reTry = false;
        }
        if(selectedMenu != Menu.SUBWAY_MAP && selectedMenu != Menu.QUIT){
            managementScreen = new ManagementScreen(selectedMenu);
            managementScreen.visualize();
            managementScreen.logic(input);
        }
    }
}
