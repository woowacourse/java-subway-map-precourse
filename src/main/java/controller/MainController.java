package controller;

import java.util.Map;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import utils.ConstantsString;
import view.MainView;

public class MainController {

    private MainView view;

    public MainController(MainView view) {
        this.view = view;
    }

    public String getAllLinesInfo() {
        Map<String, Line> map = LineRepository.lines();
        StringBuilder sb = new StringBuilder();
        for (Line line : map.values()) {
            sb.append(ConstantsString.INFO_PREFIX + line.getName() + "\n");
            sb.append(ConstantsString.INFO_PREFIX + ConstantsString.DIVISION_DASH + "\n");
            for (Station station : line.sections()) {
                sb.append(ConstantsString.INFO_PREFIX + station.getName() + "\n");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
