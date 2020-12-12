package subway.controller.manager;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exception.SubwayCustomException;
import subway.menu.LineMenu;
import subway.utils.ValidateUtils;
import subway.view.InputView;
import subway.view.OutputView;

public class LineManager {

    public static void manageLine() {
        try {
            OutputView.showLineMenu();
            OutputView.chooseCategory();
            LineMenu.execute(InputView.inputValue());
        } catch (SubwayCustomException exception) {
            OutputView.showErrorMessage(exception);
            manageLine();
        }
    }

    public static void addLine() {
        try {
            OutputView.guideInsertLine();
            Line line = new Line(InputView.makeNewLineName());
            addStartSection(line);
            addEndSection(line);
            LineRepository.addLine(line);
            OutputView.doneInsertLine();
        } catch (SubwayCustomException exception) {
            OutputView.showErrorMessage(exception);
            manageLine();
        }
    }

    private static void addStartSection(Line line) {
        OutputView.guideStartStationOfLine();
        Station startStation = StationRepository.searchStation(InputView.inputValue());
        line.addSection(startStation);
    }

    private static void addEndSection(Line line) {
        OutputView.guideEndStationOfLine();
        Station endStation = StationRepository.searchStation(InputView.inputValue());
        ValidateUtils.isAlreadyExistingSection(line, endStation);
        line.addSection(endStation);
    }

    public static void deleteLine() {
        try {
            OutputView.guideRemoveLine();
            LineRepository.deleteLine(InputView.inputValue());
            OutputView.doneRemoveLine();
        } catch (SubwayCustomException exception) {
            OutputView.showErrorMessage(exception);
            manageLine();
        }
    }
}
