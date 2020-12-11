package subway.controller.manager;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exception.SubwayCustomException;
import subway.utils.ValidateUtils;
import subway.menu.LineMenu;
import subway.view.InputView;
import subway.view.OutputView;

public class LineManager {

    public static void manageLine() {
        OutputView.showLineMenu();
        OutputView.chooseCategory();
        try {
            LineMenu.execute(inputView.inputValue());
        } catch (SubwayCustomException exception) {
            OutputView.showErrorMessage(exception);
            manageLine();
        }
    }

    public static void addLine() {

        try {
            OutputView.guideInsertLine();
            Line line = new Line(inputView.makeNewLineName());
            LineRepository.addLine(line);
            addStartSection(line);
            addEndSection(line);
            OutputView.doneInsertLine();
        } catch (SubwayCustomException exception) {
            OutputView.showErrorMessage(exception);
            manageLine();
        }
    }

    private static void addStartSection(Line line) {
        OutputView.guideStartStationOfLine();
        Station startStation = StationRepository.searchStation(inputView.inputValue());
        line.addSection(startStation);
    }

    private static void addEndSection(Line line) {
        OutputView.guideEndStationOfLine();
        Station endStation = StationRepository.searchStation(inputView.inputValue());
        ValidateUtils.isAlreadyExistingSection(line, endStation);
        line.addSection(endStation);
    }

    public static void deleteLine() {
        try {
            OutputView.guideRemoveLine();
            LineRepository.deleteLine(inputView.inputValue());
            OutputView.doneRemoveLine();
        } catch (SubwayCustomException exception) {
            OutputView.showErrorMessage(exception);
            manageLine();
        }
    }

}
