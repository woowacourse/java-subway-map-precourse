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
        SubwayRepository.addLineStation(LineRepository.findLineByName(enrollingLine), makeValidateStation("상행", inputView));
        SubwayRepository.addLineStation(LineRepository.findLineByName(enrollingLine), makeValidateStation("하행", inputView));
        LineOutputView.printSuccess(detailFunction);
    }

    private static Station makeValidateStation(String startOrFinish, InputView inputView) {
        try{
            LineOutputView.printStartOrFinishStation(startOrFinish);
            return StationRepository.findStationByName(StationNameValidator.makeIsolateName(inputView.receiveFunctionInfo()));
        } catch (IllegalArgumentException e){
            System.out.println("[ERROR] "+e.getMessage());
            return makeValidateStation(startOrFinish, inputView);
        }
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
