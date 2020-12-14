package subway.view;

import java.util.List;
import java.util.Scanner;

import subway.screen.ActionType;
import subway.screen.EntityType;
import subway.screen.Screen;

public class View {
    InputView inputView;
    OutputView outputView;
    
    public View(Scanner scanner) {
        inputView = new InputView(scanner);
        outputView = new OutputView();
    }
    
    public String askUserCommand(Screen screen) {
        String userCommand;
        
        outputView.printScreen(screen);
        outputView.printEmptyLine();
        outputView.printSelectFeature();
        userCommand = inputView.userInput();
        outputView.printEmptyLine();
        
        return userCommand;
    }
    
    public String askName(EntityType entityType, ActionType actionType) {
        String userInputName;
        
        outputView.printAskMessage(entityType, actionType);
        userInputName = inputView.userInput();
        outputView.printEmptyLine();
        
        return userInputName;
    }
    
    public String askUpwardEndStationName() {
        String userInputName;
        
        outputView.printAskUpwardEndStationMessage();
        userInputName = inputView.userInput();
        outputView.printEmptyLine();
        
        return userInputName;
    }
    
    public String askDownwardEndStationName() {
        String userInputName;
        
        outputView.printAskDownwardEndStationMessage();
        userInputName = inputView.userInput();
        outputView.printEmptyLine();
        
        return userInputName;
    }

    public String askStationNameToRegisterToRoute() {
        String userInputName;
        
        outputView.printAskStationNameToRegisterToRouteMessage();
        userInputName = inputView.userInput();
        outputView.printEmptyLine();
        
        return userInputName;
    }

    public String askStationOrderInRoute() {
        String userInputOrder;
        
        outputView.printAskStationOrderInRouteMessage();
        userInputOrder = inputView.userInput();
        outputView.printEmptyLine();
        
        return userInputOrder;
    }
    
    public void printMessage(String message) {
        outputView.printMessage(message);
        outputView.printEmptyLine();
    }
    
    public void printErrorMessage(Exception exception) {
        outputView.printErrorMessage(exception);
        outputView.printEmptyLine();
    }
    
    public void printSuccessMessage(EntityType entityType, ActionType actionType) {
        outputView.printSuccessMessage(entityType, actionType);
        outputView.printEmptyLine();
    }
    
    public void printNames(EntityType entityType, List<String> names) {
        outputView.printNames(entityType, names);
        outputView.printEmptyLine();
    }
}
