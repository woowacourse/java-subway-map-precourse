package subway.controller;

import subway.domain.DetailFunctions;
import subway.domain.Station;
import subway.domain.StationNameValidator;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.StationOutputView;

public class StationFunction {

    public static void doFunction(DetailFunctions detailFunction, InputView inputView) {
        if (detailFunction.equals(DetailFunctions.ENROLL)) {
            StationRepository.addStation(new Station(makeValidateName(inputView)));
            StationOutputView.printSuccessEnroll();
        }
    }

    private static String makeValidateName(InputView inputView) {
        try {
            StationOutputView.printEnroll();
            return StationNameValidator.makeName(inputView.receiveFunctionInfo());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] "+e.getMessage());
            return makeValidateName(inputView);
        }
    }
}
