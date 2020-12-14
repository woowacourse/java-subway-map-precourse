package subway.controller.manager;

import java.util.stream.Collectors;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.screen.ActionType;
import subway.view.View;

public class MapManager {
    private View view;
    
    MapManager(View view) {
        this.view = view;
    }
    
    void manageMap(ActionType actionType) {
        if(actionType == ActionType.PRINT) {
            printMap();
        }
    }
    
    private void printMap() {
        view.printPrintMapMessage();
        for (Line line : LineRepository.lines()) {
            view.printRoute(line.getName(),
                    line.getRoute().stream().map(station -> station.getName()).collect(Collectors.toList()));
        }
    }
}
