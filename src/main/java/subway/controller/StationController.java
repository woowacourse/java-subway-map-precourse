package subway.controller;

import subway.domain.*;
import subway.view.InputView;
import subway.view.FunctionOutputView;
import subway.view.OutputView;

public class StationController {

    public static void doFunction(DetailFunctions detailFunction, InputView inputView) {
        if (detailFunction.equals(DetailFunctions.ENROLL)) {
            StationRepository.addStation(new Station(makeValidateEnrollName(inputView)));
            FunctionOutputView.printSuccess(DetailFunctions.ENROLL, MainFunctions.STATION);
        }
        if (detailFunction.equals(DetailFunctions.REMOVE)) {
            StationRepository.deleteStation((makeValidateRemoveName(inputView)));
            FunctionOutputView.printSuccess(DetailFunctions.REMOVE, MainFunctions.STATION);
        }
        if (detailFunction.equals(DetailFunctions.RESEARCH)) {
            FunctionOutputView.printResearch(MainFunctions.STATION);
        }
    }

    private static String makeValidateEnrollName(InputView inputView) {
        try {
            FunctionOutputView.printFunction(DetailFunctions.ENROLL, MainFunctions.STATION);
            return StationNameValidator.makeName(inputView.receiveFunctionInfo());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return makeValidateEnrollName(inputView);
        }
    }

    private static String makeValidateRemoveName(InputView inputView) {
        try {
            FunctionOutputView.printFunction(DetailFunctions.REMOVE, MainFunctions.STATION);
            return StationNameValidator.makeRemoveName(inputView.receiveFunctionInfo());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return makeValidateRemoveName(inputView);
        }
    }

}
