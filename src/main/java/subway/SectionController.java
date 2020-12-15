package subway;

import java.util.Scanner;
import subway.constant.UserChoiceOptionToName;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class SectionController {

    private SectionController() {

    }

    public static void sectionControlMenu(Scanner scanner) {
        String choiceMenu;
        boolean workStatus = false;

        while (isWorkSuccess(workStatus)) {
            OutputView.sectionMenuPrint();
            choiceMenu = InputView.scanSectionMenu(scanner);

            if (choiceMenu.
                equals(UserChoiceOptionToName.SECTION_ADD.getUserChoiceOptionToName())) {
                workStatus = sectionAdd(scanner);
            }
            if (choiceMenu.
                equals(UserChoiceOptionToName.SECTION_DELETE.getUserChoiceOptionToName())) {
                workStatus = sectionDelete(scanner);
            }
            if (choiceMenu.equals(UserChoiceOptionToName.BACK.getUserChoiceOptionToName())) {
                break;
            }
        }
    }

    private static boolean sectionDelete(Scanner scanner) {
        return true;
    }

    private static boolean sectionAdd(Scanner scanner) {
        String lineName;
        String stationName;
        Station insertStation;
        Line line;
        int stationNumber;

        try {
            OutputView.sectionAddLineNamePrint();
            lineName = InputView.scanSectionLineName(scanner);

            OutputView.sectionAddStationNamePrint();
            stationName = InputView.scansectionStationName(scanner);

            OutputView.sectionAddIndexPrint();
            line = LineRepository.getLineByName(lineName);
            stationNumber = InputView.scanSectionAddIndex(scanner, line);

        } catch (IllegalArgumentException error) {
            return false;
        }

        insertStation = StationRepository.getStationByName(stationName);
        LineRepository.getLineByName(lineName).addStation(insertStation, stationNumber);

        OutputView.sectionAddSuccess();
        return true;
    }

    private static boolean isWorkSuccess(boolean workStatus) {
        return !workStatus;
    }

}
