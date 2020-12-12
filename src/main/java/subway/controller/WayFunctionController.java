package subway.controller;

import subway.domain.*;
import subway.view.*;

import static subway.domain.LineNameValidator.makeEnrolledLineName;
import static subway.domain.StationNameValidator.makeEnrolledStationName;
import static subway.view.OutputView.PRINT_ERROR_HEAD;

public class WayFunctionController {
    public static void doFunction(DetailFunctions detailFunction, InputView inputView) {
        if (detailFunction.equals(DetailFunctions.ENROLL)) {
            enrollWay(inputView);
        }
        if (detailFunction.equals(DetailFunctions.REMOVE)) {
            removeWay(inputView);
        }
    }

    private static void enrollWay(InputView inputView) {
        Line enrolledLine = receiveEnrollLine(inputView);
        Station enrolledStation = receiveEnrollStation(inputView, enrolledLine);
        Integer order = receiveOrder(inputView, SubwayRepository.subway().get(enrolledLine).size());
        SubwayRepository.addLineStationSpecificPlace(enrolledLine, enrolledStation, order);
        WayOutputView.printSuccess(DetailFunctions.ENROLL);
        OutputView.printOneLine();
    }

    private static Line receiveEnrollLine(InputView inputView) {
        try {
            WayOutputView.printEnrollLine();
            return LineRepository.findLineByName(makeEnrolledLineName(inputView.receiveFunctionInfo()));
        } catch (IllegalArgumentException e) {
            System.out.println();
            System.out.println(PRINT_ERROR_HEAD + e.getMessage());
            return receiveEnrollLine(inputView);
        }
    }

    private static Station receiveEnrollStation(InputView inputView, Line enrolledLine) {
        try {
            WayOutputView.printEnrollStation();
            String validStationName = makeEnrolledStationName(inputView.receiveFunctionInfo());
            checkNotIncludeStationInLine(validStationName, enrolledLine);
            return StationRepository.findStationByName(validStationName);
        } catch (IllegalArgumentException e) {
            System.out.println();
            System.out.println(PRINT_ERROR_HEAD + e.getMessage());
            return receiveEnrollStation(inputView, enrolledLine);
        }
    }

    private static void checkNotIncludeStationInLine(String inputStation, Line enrolledLine) {
        if (SubwayRepository.findStationWithLine(enrolledLine, inputStation) != null) {
            throw new IllegalArgumentException("이미 호선에 역이 존재합니다.");
        }
    }

    private static void removeStationFromLine(Line selectedLine, Station selectedStation) {
        try {
            SubwayRepository.deleteStationFromLine(selectedLine, selectedStation);
            WayOutputView.printSuccess(DetailFunctions.REMOVE);
        } catch (IllegalArgumentException e) {
            System.out.println();
            System.out.println(PRINT_ERROR_HEAD + e.getMessage());
        }
    }

    private static Line receiveRemoveLine(InputView inputView) {
        try {
            WayOutputView.printRemoveLine();
            String validLineName = makeEnrolledLineName(inputView.receiveFunctionInfo());
            return LineRepository.findLineByName(validLineName);
        } catch (IllegalArgumentException e) {
            System.out.println();
            System.out.println(PRINT_ERROR_HEAD + e.getMessage());
            return receiveRemoveLine(inputView);
        }
    }

    private static Station receiveRemoveStation(InputView inputView, Line selectedLine) {
        try {
            WayOutputView.printRemoveStation();
            String validStationName = makeEnrolledStationName(inputView.receiveFunctionInfo());
            checkStationIncludeLine(validStationName, selectedLine);
            return StationRepository.findStationByName(validStationName);
        } catch (IllegalArgumentException e) {
            System.out.println();
            System.out.println(PRINT_ERROR_HEAD + e.getMessage());
            return receiveRemoveStation(inputView, selectedLine);
        }
    }

    private static void checkStationIncludeLine(String inputStation, Line selectedLine) {
        if (SubwayRepository.findStationWithLine(selectedLine, inputStation) == null) {
            throw new IllegalArgumentException("노선에 역이 존재하지 않습니다.");
        }
    }

    private static void removeWay(InputView inputView) {
        Line selectedLine = receiveRemoveLine(inputView);
        Station selectedStation = receiveRemoveStation(inputView, selectedLine);
        removeStationFromLine(selectedLine, selectedStation);
        OutputView.printOneLine();
    }

    private static Integer receiveOrder(InputView inputView, Integer lineSize) {
        try {
            WayOutputView.printOrder();
            return OrderValidator.makeValidOrder(inputView.receiveFunctionInfo(), lineSize);
        } catch (IllegalArgumentException e) {
            System.out.println();
            System.out.println(PRINT_ERROR_HEAD + e.getMessage());
            return receiveOrder(inputView, lineSize);
        }
    }
}
