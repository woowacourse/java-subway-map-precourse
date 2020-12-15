package subway;

import java.util.Scanner;
import subway.constant.BoundaryCheckDigit;
import subway.domain.Line;
import subway.domain.LineRepository;
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
            OutputView.lineAddGuidePrint();
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
        newLine.addStation(StationRepository.getStationByName(upTerminus));
        newLine.addStation(StationRepository.getStationByName(downTerminus));
        LineRepository.addLine(newLine);
        OutputView.lineAddSuccessPrint();

        return true;
    }

    private static boolean isTwoNameSame(String upTerminus, String downTerminus) {
        return upTerminus.equals(downTerminus);
    }

    private static boolean lineDelete(Scanner scanner) {
        String lineName;

        lineName = InputView.scanLineDeleteName(scanner);
        if (notFoundStationName(lineName)) {
            OutputView.stationNameDeleteErrorPrint();
            return false;
        }
        OutputView.stationDeleteSuccessPrint();
        return true;
    }

    private static boolean notFoundStationName(String lineName) {
        return !LineRepository.deleteLineByName(lineName);
    }

    private static boolean lineCheck() {
        String[] lineList;
        lineList = LineRepository.getAllLineNames().toArray(String[]::new);
        if (isEmptyLineRepository(lineList)) {
            OutputView.zeroLineListErrorPrint();
            return false;
        }
        OutputView.lineListPrint(lineList);
        return true;
    }

    private static boolean isEmptyLineRepository(String[] lineList) {
        return lineList.length < BoundaryCheckDigit.LINE_LIST_LIMIT_MINIMUM
            .getBoundaryCheckDigit();
    }


    private static boolean isWorkSuccess(boolean workStatus) {
        return !workStatus;
    }

}
