package subway.maintain;

import subway.controller.Controller;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.view.OutputView;

import java.util.List;
import java.util.Scanner;

public class MapMaintain {

    public MapMaintain(Scanner scanner) {
        map();
        new Controller(scanner);
    }

    private void map() {
        LineRepository.allStatus();
    }
}
