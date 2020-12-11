package subway.controller;

import subway.domain.DetailFunctions;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.StationOutputView;

public class StationFunction {

    public static void doFunction(DetailFunctions detailFunction, InputView inputView) {
        if (detailFunction.equals(DetailFunctions.ENROLL)) {
            StationOutputView.printEnroll();
            StationRepository.addStation(new Station(inputView.receiveFunctionInfo()));
        }
    }
}
