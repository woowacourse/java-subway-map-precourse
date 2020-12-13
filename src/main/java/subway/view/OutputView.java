package subway.view;

import subway.CommonConstants;
import subway.screen.Choice;
import subway.screen.Screen;

public class OutputView {
    private static String NEW_MESSAGE_PREFIX = "##";
    private static String SELECT_FEATURE_MESSAGE = "원하는 기능을 선택하세요.";
    
    OutputView() {
    }
    
    void printScreen(Screen screen) {
        System.out.println(NEW_MESSAGE_PREFIX + CommonConstants.SPACE + screen.getScreenType().toString());
        for (Choice choice : screen.getChoices()) {
            System.out.println(choice.toString());
        }
    }
    
    void printSelectFeature() {
        System.out.println(NEW_MESSAGE_PREFIX + CommonConstants.SPACE + SELECT_FEATURE_MESSAGE);
    }
    
    void printMessage(String message) {
        System.out.println(message);
    }
    
    void printEmptyLine() {
        System.out.println(CommonConstants.EMPTY);
    }
}
