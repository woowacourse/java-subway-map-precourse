package subway;

import java.util.Scanner;
import subway.constant.BoundaryCheckDigit;
import subway.domain.Line;
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

        lineName = InputView.scanLineAddName(scanner);
        System.out.println("임시 출력 문구 : 상행 종착역");
        upTerminus = scanner.nextLine();
        System.out.println("임시 출력 문구 : 하행 종착영");
        downTerminus = scanner.nextLine();
        newLine = new Line(lineName);
        newLine.addStation(StationRepository.getStationFromName(upTerminus));
        newLine.addStation(StationRepository.getStationFromName(downTerminus));

        OutputView.lineAddSuccessPrint();
        return true;
    }

    private static boolean lineDelete(Scanner scanner) {
        return true;
    }

    private static boolean lineCheck() {
        return true;
    }


    private static boolean isWorkSuccess(boolean workStatus) {
        return !workStatus;
    }

}
