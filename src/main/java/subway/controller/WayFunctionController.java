package subway.controller;

import subway.domain.*;
import subway.view.*;

import static subway.domain.LineNameValidator.makeEnrolledLineName;
import static subway.domain.StationNameValidator.makeEnrolledStationName;

public class WayFunctionController {
    public static void doFunction(DetailFunctions detailFunction, InputView inputView) {
        if (detailFunction.equals(DetailFunctions.ENROLL)) {
            enrollWay(inputView, detailFunction);
        }
        if (detailFunction.equals(DetailFunctions.REMOVE)) {
            removeWay(inputView, detailFunction);
        }
    }

    private static void enrollWay(InputView inputView, DetailFunctions detailFunction){
        WayOutputView.printEnrollLine();
        Line enrolledLine = LineRepository.findLineByName(makeEnrolledLineName(inputView.receiveFunctionInfo()));
        WayOutputView.printEnrollStation();
        Station enrolledStation = StationRepository.findStationByName(makeEnrolledStationName(inputView.receiveFunctionInfo()));
        WayOutputView.printOrder();
        SubwayRepository.addLineStationSpecificPlace(enrolledLine, enrolledStation, OrderValidator.makeValidOrder(inputView.receiveFunctionInfo()));
        WayOutputView.printSuccess(detailFunction);
        OutputView.printOneLine();
    }

    private static void removeWay(InputView inputView, DetailFunctions detailFunction) {
        WayOutputView.printRemoveLine();
        Line selectedLine = LineRepository.findLineByName(makeEnrolledLineName(inputView.receiveFunctionInfo()));
        WayOutputView.printRemoveStation();
        Station selectedStation = StationRepository.findStationByName(makeEnrolledStationName(inputView.receiveFunctionInfo()));
        WayOutputView.printOrder();
        SubwayRepository.deleteStationFromLine(selectedLine, selectedStation);
        WayOutputView.printSuccess(detailFunction);
        OutputView.printOneLine();
    }
}
