package subway.controller.manager;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exception.SubwayCustomException;
import subway.menu.StationMenu;
import subway.utils.ValidateUtils;
import subway.view.InputView;
import subway.view.OutputView;

public class StationManager {

    public static void manageStation() {
        OutputView.showStationMenu();
        OutputView.chooseCategory();
        try {
            StationMenu.execute(InputView.inputValue());
        } catch (SubwayCustomException exception) {
            OutputView.showErrorMessage(exception);
            manageStation();
        }
    }

    public static void addStation() {
        try {
            OutputView.guideInsertStation();
            StationRepository.addStation(new Station(InputView.makeNewStationName()));
            OutputView.doneInsertStation();
        } catch (SubwayCustomException exception) {
            OutputView.showErrorMessage(exception);
            manageStation();
        }
    }

    public static void deleteStation() {
        try {
            OutputView.guideRemoveStation();
            Station station = StationRepository.searchStation(InputView.inputValue());
            ValidateUtils.isExistingSection(station);
            StationRepository.deleteStation(station);
            OutputView.doneRemoveStation();
        } catch (SubwayCustomException exception) {
            OutputView.showErrorMessage(exception);
            manageStation();
        }
    }
}
