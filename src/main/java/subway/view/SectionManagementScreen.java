package subway.view;

import subway.Constants;
import subway.Load;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.ArrayList;

public class SectionManagementScreen implements Screen {
    static SectionManagementScreen instance;

    private SectionManagementScreen() {
    }

    public static SectionManagementScreen getInstance() {
        if (instance == null) {
            instance = new SectionManagementScreen();
        }
        return instance;
    }

    @Override
    public String show() {
        System.out.println(Constants.SECTION_MANAGEMENT_USER_PROMPT);
        String userInput = UserInputNumberSelection.createUserSelectionInput(
                Constants.COUNT_SECTION_MANAGEMENT_USER_PROMPT);
        return userInput;
    }
}
