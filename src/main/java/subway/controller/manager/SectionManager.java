package subway.controller.manager;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exception.SubwayCustomException;
import subway.utils.ValidateUtils;
import subway.view.InputView;
import subway.view.OutputView;
import subway.menu.SectionMenu;

public class SectionManager {

    public static void mangeSection() {
        OutputView.showSectionMenu();
        OutputView.chooseCategory();
        try {
            SectionMenu.execute(InputView.inputValue());
        } catch (SubwayCustomException exception) {
            OutputView.showErrorMessage(exception);
            mangeSection();
        }
    }

    public static void addSection() {
        int position;
        Station station;
        Line line;
        try {
            OutputView.guideInsertSectionLineName();
            line = LineRepository.searchLine(InputView.inputValue());
            OutputView.guideInsertSectionStationName();
            station = StationRepository.searchStation(InputView.inputValue());
            ValidateUtils.isAlreadyExistingSection(line, station);
            OutputView.guideInsertSectionPostionName();
            position = Integer.parseInt(InputView.inputValue());
            line.addSectionWithPosition(position, station);
            OutputView.doneInsertSection();
        } catch (SubwayCustomException exception) {
            OutputView.showErrorMessage(exception);
            mangeSection();
        }
    }

    public static void deleteSection() {
        Station station;
        Line line;
        try {
            OutputView.guideRemoveSectionLineName();
            line = LineRepository.searchLine(InputView.inputValue());
            ValidateUtils.isLessThanTwoStation(line);
            OutputView.guideRemoveSectionStationName();
            station = line.searchSection(InputView.inputValue());
            line.deleteSection(station);
            OutputView.doneRemoveSection();
        } catch (SubwayCustomException exception) {
            OutputView.showErrorMessage(exception);
            mangeSection();
        }
    }
}
