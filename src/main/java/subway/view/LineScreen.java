package subway.view;

import subway.Constants;

public class LineScreen implements Screen {
    static LineScreen instance;

    private LineScreen() {
    }

    public static LineScreen getInstance() {
        if (instance == null) {
            instance = new LineScreen();
        }
        return instance;
    }

    @Override
    public String show() {
        System.out.println(Constants.LINE_MANAGEMENT_USER_PROMPT);
        String userInput = CategorySelection.createUserInput(
                Constants.COUNT_LINE_MANAGEMENT_USER_PROMPT);
        return userInput;
    }

    public void printError(Exception e){
        System.out.println(e);
    }
}
