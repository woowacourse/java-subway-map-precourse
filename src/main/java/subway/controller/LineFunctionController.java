package subway.controller;

import subway.domain.*;
import subway.view.InputView;
import subway.view.LineOutputView;

public class LineFunctionController {

    public static final String PRINT_ERROR_HEAD = "[ERROR] ";

    public static void doFunction(DetailFunctions detailFunction, InputView inputView) {
        if (detailFunction.equals(DetailFunctions.ENROLL)) {
            enrollLine(inputView);
        }
        if (detailFunction.equals(DetailFunctions.REMOVE)) {
            LineRepository.deleteLineByName((makeValidateEnrolledName(inputView)));
            LineOutputView.printSuccess(detailFunction);
        }
        if (detailFunction.equals(DetailFunctions.RESEARCH)) {
            LineOutputView.printResearch(LineRepository.lines());
        }
    }

    private static void enrollLine(InputView inputView) {
        String enrollingLine = makeValidateEnrollName(inputView);
        LineRepository.addLine(new Line(enrollingLine));
        SubwayRepository.addLine(LineRepository.findLineByName(enrollingLine));
        SubwayRepository.addLineStation(LineRepository.findLineByName(enrollingLine), makeValidateStation("상행", inputView));
        SubwayRepository.addLineStation(LineRepository.findLineByName(enrollingLine), makeValidateStation("하행", inputView));
        LineOutputView.printSuccess(DetailFunctions.ENROLL);
    }

    private static Station makeValidateStation(String startOrFinish, InputView inputView) {
        try{
            LineOutputView.printStartOrFinishStation(startOrFinish);
            return StationRepository.findStationByName(StationNameValidator.makeEnrolledStationName(inputView.receiveFunctionInfo()));
        } catch (IllegalArgumentException e){
            System.out.println(PRINT_ERROR_HEAD +e.getMessage());
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

    public static String makeValidateEnrolledName(InputView inputView) {
        try {
            LineOutputView.printFunction(DetailFunctions.REMOVE);
            return LineNameValidator.makeEnrolledLineName(inputView.receiveFunctionInfo());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] "+e.getMessage());
            return makeValidateEnrolledName(inputView);
        }
    }

}
