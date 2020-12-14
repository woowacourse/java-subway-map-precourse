package subway.view;

import subway.Constants;
import subway.Load;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class LineManagementScreen implements Screen {
    static LineManagementScreen instance;

    private LineManagementScreen() {
    }

    public static LineManagementScreen getInstance() {
        if (instance == null) {
            instance = new LineManagementScreen();
        }
        return instance;
    }

    @Override
    public String show() {
        System.out.println(Constants.LINE_MANAGEMENT_USER_PROMPT);
        String userInput = UserInputNumberSelection.createUserSelectionInput(
                Constants.COUNT_LINE_MANAGEMENT_USER_PROMPT);
        return userInput;
    }
}
