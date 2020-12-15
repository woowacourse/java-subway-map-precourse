package subway.controller;

import subway.menuType.ManagementMenuType;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.dto.DTO;
import subway.view.menuView.LineView;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class LineManagement {
    private static LineView lineView = LineView.getInstance();
    private static ManagementMenuType menu;
    private static HashMap<ManagementMenuType, matchedFunction> mapToFunction;

    static {
        LineManagement.mapToFunction = new HashMap<>();
        mapToFunction.put(ManagementMenuType.CREATE, LineManagement::registerLine);
        mapToFunction.put(ManagementMenuType.DELETE, LineManagement::deleteLine);
        mapToFunction.put(ManagementMenuType.READ, LineManagement::printAllLines);
        mapToFunction.put(ManagementMenuType.ESCAPE, () -> {});
    }

    public static void run() {
        do {
            try {
                lineView.printMenu();
                menu = lineView.getMenuSelection();
                mapToFunction.get(menu).run();
            } catch (RuntimeException e) {
                lineView.printErrorMessage(e);
            }
        } while (!menu.equals(ManagementMenuType.ESCAPE));
    }

    private static void registerLine() {
        String lineName = lineView.getNameToCreate();
        Station upLineEndStation = StationRepository.searchByName(lineView.getUplineStationName());
        Station downLineEndStation = StationRepository.searchByName(lineView.getDownlineStationName());

        Line line = new Line(lineName, upLineEndStation, downLineEndStation);

        LineRepository.addLine(line);
        lineView.printCreateDone();
    }

    private static void deleteLine() {
        LineRepository.deleteLineByName(lineView.getNameToDelete());
        lineView.printDeleteDone();
    }

    private static void printAllLines() {
        List<DTO> lineNames = LineRepository.lines().stream()
                .map(Line::toDTO)
                .collect(Collectors.toList());

        lineView.printAll(lineNames);
    }

}
