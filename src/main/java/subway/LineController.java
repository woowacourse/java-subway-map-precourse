package subway;

import java.util.Scanner;
import subway.constant.BoundaryCheckDigit;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;
import subway.constant.UserChoiceOptionToName;

public class LineController {

    private LineController() {

    }

    public static void lineControlMenu(Scanner scanner) {
        String choiceMenu;
        boolean workStatus = false;
        while (isWorkSuccess(workStatus)) {
            OutputView.lineMenuPrint();
            choiceMenu = InputView.scanLineMenu(scanner);

            if (choiceMenu.
                equals(UserChoiceOptionToName.STATION_ADD.getUserChoiceOptionToName())) {
                workStatus = lineAdd(scanner);
            }
            if (choiceMenu.
                equals(UserChoiceOptionToName.STATION_DELETE.getUserChoiceOptionToName())) {
                workStatus = lineDelete(scanner);
            }
            if (choiceMenu.
                equals(UserChoiceOptionToName.STATION_CHECK.getUserChoiceOptionToName())) {
                workStatus = lineCheck();
            }
            if (choiceMenu.equals(UserChoiceOptionToName.BACK.getUserChoiceOptionToName())) {
                break;
            }
        }

    }

    private static boolean lineAdd(Scanner scanner) {
        Line newLine;
        String lineName;
        String upTerminus;
        String downTerminus;
        try {
            OutputView.LineAddGuidePrint();
            lineName = InputView.scanLineAddName(scanner);

            OutputView.upTerminusAddGuidePrint();
            upTerminus = InputView.scanStationName(scanner);

            OutputView.downTerminusAddGuidePrint();
            downTerminus = InputView.scanStationName(scanner);


        } catch (IllegalArgumentException error) {
            return false;
        }

        if (isTwoNameSame(upTerminus, downTerminus)) {
            OutputView.twoNameSameErrorPrint();
            return false;
        }

        newLine = new Line(lineName);
        newLine.addStation(StationRepository.getStationFromName(upTerminus));
        newLine.addStation(StationRepository.getStationFromName(downTerminus));

        OutputView.lineAddSuccessPrint();
        return true;
    }

    private static boolean isTwoNameSame(String upTerminus, String downTerminus) {
        return upTerminus.equals(downTerminus);
    }

    private static boolean lineDelete(Scanner scanner) {
        String lineName;

        lineName = InputView.scanLineDeleteName(scanner);

        if (!StationRepository.deleteStation(lineName)) { // 역 이름이 존재하지 않을 경우
            OutputView.stationNameDeleteErrorPrint();
            return false;
        }

        OutputView.stationDeleteSuccessPrint();
        return true;
    }

    private static boolean lineCheck() {
        String[] lineList;
        lineList = (String[]) LineRepository.getAllLineNames().toArray();

        if (lineList.length < BoundaryCheckDigit.LINE_LIST_LIMIT_MINIMUM
            .getBoundaryCheckDigit()) {
            OutputView.zeroLineListErrorPrint();
            return false;
        }
        OutputView.LineListPrint(lineList);
        return true;
    }


    private static boolean isWorkSuccess(boolean workStatus) {
        return !workStatus;
    }

}
