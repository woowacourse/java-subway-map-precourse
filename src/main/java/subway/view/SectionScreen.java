package subway.view;

import subway.Constants;

public class SectionScreen implements Screen {
    static SectionScreen instance;

    private SectionScreen() {
    }

    public static SectionScreen getInstance() {
        if (instance == null) {
            instance = new SectionScreen();
        }
        return instance;
    }

    @Override
    public String show() {
        System.out.println(Constants.SECTION_MANAGEMENT_USER_PROMPT);
        String userInput = InputView.createUserCategorySelection(
                Constants.COUNT_SECTION_MANAGEMENT_USER_PROMPT);
        return userInput;
    }

    public void printError(Exception e){
        System.out.println(e);
    }
}
