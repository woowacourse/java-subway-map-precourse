package subway.view;

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
    
    public String askStationName(ActionType actionType) {
        outputView.printAskMessage(EntityType.STATION, actionType);
        return inputView.userInput();
    }
    
    public void printMessage(String message) {
        outputView.printMessage(message);
        outputView.printEmptyLine();
    }
    
    public void printSuccessMessage(EntityType entityType, ActionType actionType) {
        outputView.printSuccessMessage(entityType, actionType);
        outputView.printEmptyLine();
    }
}
