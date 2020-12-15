package subway.controller;

import subway.domain.StationFactory;
import subway.domain.StationRepository;
import subway.view.InputView;

public class StationMenuHandler {
    public static void addStation() {
        System.out.println("역등록");
        StationRepository.addStation(StationFactory.makeStation(InputView.nextLine()));
    }

    public static void deleteStation() {
    }

    public static void showStation() {
    }

    public static void back() {
    }
}
