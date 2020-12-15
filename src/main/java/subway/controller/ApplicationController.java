package subway.controller;


public class ApplicationController {
    public static void run() {
        MenuController.callMainMenu();
    }
    
    public static void Quit() {
        System.exit(0);
    }
}
