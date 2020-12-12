package subway.controller;

import subway.domain.DetailFunctions;
import subway.domain.Station;
import subway.domain.StationNameValidator;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.StationOutputView;

public class StationFunctionController {

    public static void doFunction(DetailFunctions detailFunction, InputView inputView) {
        if (detailFunction.equals(DetailFunctions.ENROLL)) {
            StationRepository.addStation(new Station(makeValidateEnrollName(inputView)));
            StationOutputView.printSuccess(detailFunction);
        }
        if (detailFunction.equals(DetailFunctions.REMOVE)) {
            StationRepository.deleteStation((makeValidateRemoveName(inputView)));
            StationOutputView.printSuccess(detailFunction);
        }
        if (detailFunction.equals(DetailFunctions.RESEARCH)) {
            StationOutputView.printResearch(StationRepository.stations());
        }
    }

    private static String makeValidateEnrollName(InputView inputView) {
        try {
            StationOutputView.printFunction(DetailFunctions.ENROLL);
            return StationNameValidator.makeName(inputView.receiveFunctionInfo());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] "+e.getMessage());
            return makeValidateEnrollName(inputView);
        }
    }

    private static String makeValidateRemoveName(InputView inputView) {
        try {
            StationOutputView.printFunction(DetailFunctions.REMOVE);
            return StationNameValidator.makeRemoveName(inputView.receiveFunctionInfo());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] "+e.getMessage());
            return makeValidateRemoveName(inputView);
        }
    }

}
