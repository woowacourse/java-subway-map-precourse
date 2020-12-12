package subway.controller;

import subway.domain.*;
import subway.view.*;

import static subway.controller.LineFunctionController.PRINT_ERROR_HEAD;
import static subway.domain.LineNameValidator.makeEnrolledLineName;
import static subway.domain.StationNameValidator.makeEnrolledStationName;

public class WayFunctionController {
    public static void doFunction(DetailFunctions detailFunction, InputView inputView) {
        if (detailFunction.equals(DetailFunctions.ENROLL)) {
            enrollWay(inputView);
        }
        if (detailFunction.equals(DetailFunctions.REMOVE)) {
            removeWay(inputView);
        }
    }

    private static void enrollWay(InputView inputView){
        Line enrolledLine = receiveEnrollLine(inputView);
        Station enrolledStation = receiveEnrollStation(inputView);
        Integer order = receiveOrder(inputView, SubwayRepository.subway().get(enrolledLine).size());
        SubwayRepository.addLineStationSpecificPlace(enrolledLine, enrolledStation, order);
        WayOutputView.printSuccess(DetailFunctions.ENROLL);
        OutputView.printOneLine();
    }

    private static Line receiveEnrollLine(InputView inputView) {
        try{
            WayOutputView.printEnrollLine();
            return LineRepository.findLineByName(makeEnrolledLineName(inputView.receiveFunctionInfo()));
        }catch (IllegalArgumentException e){
            System.out.println();
            System.out.println(PRINT_ERROR_HEAD+e.getMessage());
            return receiveEnrollLine(inputView);
        }
    }

    private static Station receiveEnrollStation(InputView inputView) {
        try{
            WayOutputView.printEnrollStation();
            return StationRepository.findStationByName(makeEnrolledStationName(inputView.receiveFunctionInfo()));
        }catch (IllegalArgumentException e){
            System.out.println();
            System.out.println(PRINT_ERROR_HEAD+e.getMessage());
            return receiveEnrollStation(inputView);
        }
    }

    private static void removeStationFromLine(Line selectedLine, Station selectedStation) {
        try {
            SubwayRepository.deleteStationFromLine(selectedLine, selectedStation);
            WayOutputView.printSuccess(DetailFunctions.REMOVE);
        }catch (IllegalArgumentException e){
            System.out.println();
            System.out.println(PRINT_ERROR_HEAD+e.getMessage());
        }
    }

    private static Line receiveRemoveLine(InputView inputView) {
        try{
            WayOutputView.printRemoveLine();
            return LineRepository.findLineByName(makeEnrolledLineName(inputView.receiveFunctionInfo()));
        }catch (IllegalArgumentException e){
            System.out.println();
            System.out.println(PRINT_ERROR_HEAD+e.getMessage());
            return receiveRemoveLine(inputView);
        }
    }

    private static Station receiveRemoveStation(InputView inputView, Line selectedLine) {
        try{
            WayOutputView.printRemoveStation();
            return SubwayRepository.findStationWithLine(selectedLine, inputView.receiveFunctionInfo());
        }catch (IllegalArgumentException e){
            System.out.println();
            System.out.println(PRINT_ERROR_HEAD+e.getMessage());
            return receiveRemoveStation(inputView, selectedLine);
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
        }catch (IllegalArgumentException e){
            System.out.println();
            System.out.println(PRINT_ERROR_HEAD+e.getMessage());
            return receiveOrder(inputView, lineSize);
        }
    }
}
