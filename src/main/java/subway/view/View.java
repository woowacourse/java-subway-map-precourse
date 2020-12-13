package subway.view;

import java.util.Scanner;
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
    
    public void printMessage(String message) {
        outputView.printMessage(message);
        outputView.printEmptyLine();
    }
}
