package subway;

import java.util.List;
import java.util.Scanner;
import subway.constant.UserChoiceOptionToName;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {

    Scanner scanner;

    public SubwayController(Scanner scanner) {
        this.scanner = scanner;
    }


    public void mainMenu() {
        String mainMenuOptionChoice = "";

        while (!mainMenuOptionChoice.
            equals(UserChoiceOptionToName.EXIT.getUserChoiceOptionToName())) {

            OutputView.mainMenuPrint();
            mainMenuOptionChoice = InputView.scanMainMenu(scanner);

            if (mainMenuOptionChoice
                .equals(UserChoiceOptionToName.STATION_MANAGEMENT.getUserChoiceOptionToName())) {
                StationController.stationControlMenu(scanner);
            }
            if (mainMenuOptionChoice
                .equals(UserChoiceOptionToName.LINE_MANAGEMENT.getUserChoiceOptionToName())) {
                LineController.lineControlMenu(scanner);
            }
            if (mainMenuOptionChoice
                .equals(UserChoiceOptionToName.SECTION_MANAGEMENT.getUserChoiceOptionToName())) {
                SectionController.sectionControlMenu(scanner);
            }
            if (mainMenuOptionChoice
                .equals(UserChoiceOptionToName.STATION_MAP_PRINT.getUserChoiceOptionToName())) {
                stationMapPrint();
            }
        }
    }

    private void stationMapPrint() {
        List<Line> lines = LineRepository.lines();

        if (noRegisteredLine()) {
            OutputView.zeroLineListErrorPrint();
            return;
        }
        OutputView.stationMapGuidePrint();
        for (Line line : lines) {
            OutputView.infoLineNamePrint(line);
            OutputView.line();
            for (Station station : line.getLineMembers()) {
                OutputView.infoStationNamePrint(station.getName());
            }
            OutputView.spacePrint();
        }
    }

    private boolean noRegisteredLine() {
        return LineRepository.lines().isEmpty();
    }


}
