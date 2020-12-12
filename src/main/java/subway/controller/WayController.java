package subway.controller;

import subway.domain.*;
import subway.view.*;

import static subway.domain.LineNameValidator.makeEnrolledLineName;
import static subway.domain.StationNameValidator.makeEnrolledStationName;

public class WayController {
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

        FunctionOutputView.printSuccess(DetailFunctions.ENROLL, MainFunctions.WAY);
    }

    private static Line receiveEnrollLine(InputView inputView) {
        try {
            FunctionOutputView.printReceiveSomething(DetailFunctions.ENROLL, MainFunctions.LINE);
            return LineRepository.findLineByName(makeEnrolledLineName(inputView.receiveFunctionInfo()));
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return receiveEnrollLine(inputView);
        }
    }

    private static Station receiveEnrollStation(InputView inputView, Line enrolledLine) {
        try {
            FunctionOutputView.printReceiveSomething(DetailFunctions.ENROLL, MainFunctions.STATION);
            String validStationName = makeEnrolledStationName(inputView.receiveFunctionInfo());
            checkNotIncludeStationInLine(validStationName, enrolledLine);
            return StationRepository.findStationByName(validStationName);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
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
            FunctionOutputView.printSuccess(DetailFunctions.REMOVE, MainFunctions.WAY);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
        }
    }

    private static Line receiveRemoveLine(InputView inputView) {
        try {
            FunctionOutputView.printReceiveSomething(DetailFunctions.REMOVE, MainFunctions.LINE);
            String validLineName = makeEnrolledLineName(inputView.receiveFunctionInfo());
            return LineRepository.findLineByName(validLineName);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return receiveRemoveLine(inputView);
        }
    }

    private static Station receiveRemoveStation(InputView inputView, Line selectedLine) {
        try {
            FunctionOutputView.printReceiveSomething(DetailFunctions.REMOVE, MainFunctions.STATION);
            String validStationName = makeEnrolledStationName(inputView.receiveFunctionInfo());
            checkStationIncludeLine(validStationName, selectedLine);
            return StationRepository.findStationByName(validStationName);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
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
            FunctionOutputView.printOrder();
            return OrderValidator.makeValidOrder(inputView.receiveFunctionInfo(), lineSize);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return receiveOrder(inputView, lineSize);
        }
    }
}
