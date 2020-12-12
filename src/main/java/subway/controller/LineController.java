package subway.controller;

import subway.domain.*;
import subway.view.InputView;
import subway.view.FunctionOutputView;
import subway.view.OutputView;

public class LineController {
    public static void doFunction(DetailFunctions detailFunction, InputView inputView) {
        if (detailFunction.equals(DetailFunctions.ENROLL)) {
            enrollLine(inputView);
        }
        if (detailFunction.equals(DetailFunctions.REMOVE)) {
            LineRepository.deleteLineByName((makeValidRemoveLineName(inputView)));
            FunctionOutputView.printSuccess(detailFunction, MainFunctions.LINE);
        }
        if (detailFunction.equals(DetailFunctions.RESEARCH)) {
            FunctionOutputView.printResearch(MainFunctions.LINE);
        }
    }

    private static void enrollLine(InputView inputView) {
        String enrollingLine = makeValidEnrollLineName(inputView);

        LineRepository.addLine(new Line(enrollingLine));
        SubwayRepository.addLine(LineRepository.findLineByName(enrollingLine));
        enrollLineToSubway(inputView, enrollingLine, "상행");
        enrollLineToSubway(inputView, enrollingLine, "하행");

        FunctionOutputView.printSuccess(DetailFunctions.ENROLL, MainFunctions.LINE);
    }

    private static String makeValidEnrollLineName(InputView inputView) {
        try {
            FunctionOutputView.printFunction(DetailFunctions.ENROLL, MainFunctions.LINE);
            return LineNameValidator.makeName(inputView.receiveFunctionInfo());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return makeValidEnrollLineName(inputView);
        }
    }

    private static void enrollLineToSubway(InputView inputView, String enrollingLine, String startOrFinish) {
        try {
            SubwayRepository.addLineStation(LineRepository.findLineByName(enrollingLine), makeValidStation(startOrFinish, inputView));
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            enrollLineToSubway(inputView, enrollingLine, startOrFinish);
        }
    }

    private static Station makeValidStation(String startOrFinish, InputView inputView) {
        try {
            FunctionOutputView.printStartOrFinishStation(startOrFinish);
            return StationRepository.findStationByName(StationNameValidator.makeEnrolledStationName(inputView.receiveFunctionInfo()));
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return makeValidStation(startOrFinish, inputView);
        }
    }

    public static String makeValidRemoveLineName(InputView inputView) {
        try {
            FunctionOutputView.printFunction(DetailFunctions.REMOVE, MainFunctions.LINE);
            return LineNameValidator.makeEnrolledLineName(inputView.receiveFunctionInfo());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return makeValidRemoveLineName(inputView);
        }
    }

}
