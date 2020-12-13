package subway.domain;

import subway.view.InputView;
import subway.view.OutputView;

public class Station {
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void add(InputView inputView, String stationMessage) {
        OutputView.printAddActionMessage(stationMessage);
    }
}
