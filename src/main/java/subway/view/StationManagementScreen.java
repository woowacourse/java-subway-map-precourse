package subway.view;

import subway.Constants;
import subway.Load;
import subway.domain.Station;
import subway.domain.StationRepository;

public class StationManagementScreen implements Screen {
    static StationManagementScreen instance;

    private StationManagementScreen() {
    }

    public static StationManagementScreen getInstance() {
        if (instance == null) {
            instance = new StationManagementScreen();
        }
        return instance;
    }

    @Override
    public String show() {
        System.out.println(Constants.STATION_MANAGEMENT_USER_PROMPT);
        String userInput = UserInputNumberSelection.createUserSelectionInput(
                Constants.COUNT_STATION_MANAGEMENT_USER_PROMPT);
        return userInput;
    }
}
