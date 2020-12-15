package subway.controller;

import subway.domain.StationFactory;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class StationMenuHandler {

    public static final String STATION = "역";
    public static final String SUBWAY_STATION = "지하철 역";
    public static final String ADD = "등록";
    public static final String DELETE = "삭제";

    public static void addStation() {
        OutputView.showAddMessage(STATION);
        StationRepository.addStation(StationFactory.makeStation(InputView.nextLine().trim()));
        OutputView.showCompleteMessage(SUBWAY_STATION, ADD);
    }

    public static void deleteStation() {
        OutputView.showDeleteMessage(STATION);
        StationRepository.deleteStation(InputView.nextLine().trim());
        OutputView.showCompleteMessage(SUBWAY_STATION, DELETE);
    }

    public static void showStation() {
        OutputView.showList(StationRepository.getStationNames());
    }

    public static void back() {
    }
}
