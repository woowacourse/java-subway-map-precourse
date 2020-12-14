package subway.controller;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.utils.Validator;
import subway.view.InputView;
import subway.view.StationView;

public class StationController {

    public static void stationAdd() throws IllegalArgumentException {
        try {
            StationView.printStationAddReqMsg();
            String StationName = stationNameInput();
            StationRepository.addStation(new Station(StationName));
            StationView.printStationAddSuccessMsg();
        } catch (IllegalArgumentException e) {
            System.out.println();
            System.out.println("[ERROR] " + e.getMessage());
            System.out.println();
        }
    }

    private static String stationNameInput() throws IllegalArgumentException {
        String stationName = InputView.getInput();
        stationName = stationName.replace(" ", "");
        if (!Validator.isValidNameLength(stationName)) {
            throw new IllegalArgumentException("잘못된 이름 길이 입니다");
        }

        if (!Validator.isNonDuplicateStationName(stationName)) {
            throw new IllegalArgumentException("이미 등록된 역 이름 입니다");
        }
        return stationName;
    }
}
