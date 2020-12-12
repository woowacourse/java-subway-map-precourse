package subway.section;

import subway.view.InputView;

public class SectionController {
    private SectionController() {
    }

    public static void register() {
        String lineName = InputView.getLineName();
        String stationName = InputView.getStationName();
        int order = InputView.getOrder();
        SectionService.register(lineName, stationName, order);
    }

    public static void remove() {
        String lineName = InputView.getLineNameForRemoval();
        String stationName = InputView.getStationNameForRemoval();
        SectionService.remove(lineName, stationName);
    }
}
