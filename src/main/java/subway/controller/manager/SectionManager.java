package subway.controller.manager;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exception.SubwayCustomException;
import subway.menu.SectionMenu;
import subway.utils.ValidateUtils;
import subway.view.InputView;
import subway.view.OutputView;

public class SectionManager {

    public static void mangeSection() {
        try {
            OutputView.showSectionMenu();
            OutputView.chooseCategory();
            SectionMenu.execute(InputView.inputValue());
        } catch (SubwayCustomException exception) {
            OutputView.showErrorMessage(exception);
            mangeSection();
        }
    }

    public static void addSection() {
        try {
            OutputView.guideInsertSectionLineName();
            Line line = LineRepository.searchLine(InputView.inputValue());
            OutputView.guideInsertSectionStationName();
            Station station = StationRepository.searchStation(InputView.inputValue());
            ValidateUtils.isAlreadyExistingSection(line, station);
            OutputView.guideInsertSectionPostionName();
            int position = Integer.parseInt(InputView.inputValue());
            line.addSectionWithPosition(position, station);
            OutputView.doneInsertSection();
        } catch (SubwayCustomException exception) {
            OutputView.showErrorMessage(exception);
            mangeSection();
        }
    }

    public static void deleteSection() {
        try {
            OutputView.guideRemoveSectionLineName();
            Line line = LineRepository.searchLine(InputView.inputValue());
            ValidateUtils.isLessThanTwoStation(line);
            OutputView.guideRemoveSectionStationName();
            Station station = line.searchSection(InputView.inputValue());
            line.deleteSection(station);
            OutputView.doneRemoveSection();
        } catch (SubwayCustomException exception) {
            OutputView.showErrorMessage(exception);
            mangeSection();
        }
    }
}
