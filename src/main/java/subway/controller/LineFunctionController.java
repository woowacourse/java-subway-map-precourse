package subway.controller;

import subway.domain.*;
import subway.view.InputView;
import subway.view.LineOutputView;

public class LineFunctionController {

    public static void doFunction(DetailFunctions detailFunction, InputView inputView) {
        if (detailFunction.equals(DetailFunctions.ENROLL)) {
            enrollLine(detailFunction, inputView);
        }
        if (detailFunction.equals(DetailFunctions.REMOVE)) {
            LineRepository.deleteLineByName((makeValidateRemoveName(inputView)));
            LineOutputView.printSuccess(detailFunction);
        }
        if (detailFunction.equals(DetailFunctions.RESEARCH)) {
            LineOutputView.printResearch(LineRepository.lines());
        }
    }

    private static void enrollLine(DetailFunctions detailFunction, InputView inputView) {
        String enrollingLine = makeValidateEnrollName(inputView);
        LineRepository.addLine(new Line(enrollingLine));
        LineOutputView.printStartStation();
        SubwayRepository.addLineStation(LineRepository.findLineByName(enrollingLine), StationRepository.findStationByName(inputView.receiveFunctionInfo()));
        LineOutputView.printFinishStation();
        SubwayRepository.addLineStation(LineRepository.findLineByName(enrollingLine), StationRepository.findStationByName(inputView.receiveFunctionInfo()));
        LineOutputView.printSuccess(detailFunction);
    }

    private static String makeValidateEnrollName(InputView inputView) {
        try {
            LineOutputView.printFunction(DetailFunctions.ENROLL);
            return LineNameValidator.makeName(inputView.receiveFunctionInfo());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] "+e.getMessage());
            return makeValidateEnrollName(inputView);
        }
    }

    private static String makeValidateRemoveName(InputView inputView) {
        try {
            LineOutputView.printFunction(DetailFunctions.REMOVE);
            return LineNameValidator.makeRemoveName(inputView.receiveFunctionInfo());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] "+e.getMessage());
            return makeValidateRemoveName(inputView);
        }
    }

}
