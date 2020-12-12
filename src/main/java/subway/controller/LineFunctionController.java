package subway.controller;

import subway.domain.*;
import subway.view.InputView;
import subway.view.FunctionOutputView;

import static subway.view.OutputView.PRINT_ERROR_HEAD;

public class LineFunctionController {
    public static void doFunction(DetailFunctions detailFunction, InputView inputView) {
        if (detailFunction.equals(DetailFunctions.ENROLL)) {
            enrollLine(inputView);
        }
        if (detailFunction.equals(DetailFunctions.REMOVE)) {
            LineRepository.deleteLineByName((makeValidRemoveName(inputView)));
            FunctionOutputView.printSuccess(detailFunction, MainFunctions.LINE);
        }
        if (detailFunction.equals(DetailFunctions.RESEARCH)) {
            FunctionOutputView.printResearch(MainFunctions.LINE);
        }
    }

    private static void enrollLine(InputView inputView) {
        String enrollingLine = makeValidEnrollName(inputView);

        LineRepository.addLine(new Line(enrollingLine));
        SubwayRepository.addLine(LineRepository.findLineByName(enrollingLine));
        SubwayRepository.addLineStation(LineRepository.findLineByName(enrollingLine), makeValidStation("상행", inputView));
        SubwayRepository.addLineStation(LineRepository.findLineByName(enrollingLine), makeValidStation("하행", inputView));

        FunctionOutputView.printSuccess(DetailFunctions.ENROLL, MainFunctions.LINE);
    }

    private static Station makeValidStation(String startOrFinish, InputView inputView) {
        try {
            FunctionOutputView.printStartOrFinishStation(startOrFinish);
            return StationRepository.findStationByName(StationNameValidator.makeEnrolledStationName(inputView.receiveFunctionInfo()));
        } catch (IllegalArgumentException e) {
            System.out.println(PRINT_ERROR_HEAD + e.getMessage());
            return makeValidStation(startOrFinish, inputView);
        }
    }

    private static String makeValidEnrollName(InputView inputView) {
        try {
            FunctionOutputView.printFunction(DetailFunctions.ENROLL, MainFunctions.LINE);
            return LineNameValidator.makeName(inputView.receiveFunctionInfo());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return makeValidEnrollName(inputView);
        }
    }

    public static String makeValidRemoveName(InputView inputView) {
        try {
            FunctionOutputView.printFunction(DetailFunctions.REMOVE, MainFunctions.LINE);
            return LineNameValidator.makeEnrolledLineName(inputView.receiveFunctionInfo());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return makeValidRemoveName(inputView);
        }
    }

}
