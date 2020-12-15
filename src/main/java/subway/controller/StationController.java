package subway.controller;

import subway.domain.Station;
import subway.domain.StationManageMenu;
import subway.domain.repositories.StationRepository;
import subway.utils.Validator;
import subway.view.InputView;
import subway.view.StationView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StationController {

    public static void stationAdd() {
        try {
            StationView.printStationAddReqMsg();
            String StationName = stationNameInputForAdd();
            StationRepository.addStation(new Station(StationName));
            StationView.printStationAddSuccessMsg();
            StationManageMenu.stationManageMenuStop();
        } catch (IllegalArgumentException e) {
            System.out.println();
            System.out.println("[ERROR] " + e.getMessage());
            System.out.println();
        }
    }

    public static void stationInit() {
        List<String> stationsNames = new ArrayList<>(Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"));
        for (String stationName : stationsNames) {
            StationRepository.addStation(new Station(stationName));
        }
    }

    private static String stationNameInputForAdd() throws IllegalArgumentException {
        String stationName = InputView.getInput();
        stationName = stationName.replace(" ", "");
        if (!Validator.isValidNameLength(stationName)) {
            throw new IllegalArgumentException("잘못된 이름 길이 입니다");
        }

        if (Validator.isExistStationName(stationName)) {
            throw new IllegalArgumentException("이미 등록된 역 이름 입니다");
        }
        return stationName;
    }

    public static void stationCheck() {
        StationView.printStationCheck();
        StationManageMenu.stationManageMenuStop();
    }

    public static void stationDelete() {
        try {
            StationView.printStationDeleteReqMsg();
            String StationName = stationNameInputForDelete();
            StationRepository.deleteStation(StationName);
            StationView.printStationDeleteSuccessMsg();
            StationManageMenu.stationManageMenuStop();
        } catch (IllegalArgumentException e) {
            System.out.println();
            System.out.println("[ERROR] " + e.getMessage());
            System.out.println();
        }
    }

    private static String stationNameInputForDelete() throws IllegalArgumentException {
        String stationName = InputView.getInput();
        stationName = stationName.replace(" ", "");

        if (!Validator.isExistStationName(stationName)) {
            throw new IllegalArgumentException("존재하지 않는 역 입니다.");
        }
        if (Validator.isStationContainLine(stationName)) {
            throw new IllegalArgumentException("노선에 포함되어 있는 역 입니다.");
        }
        return stationName;
    }
}
