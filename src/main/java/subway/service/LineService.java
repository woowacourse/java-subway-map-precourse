package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.exception.CannotFindLineByNameException;
import subway.view.OutputView;

public class LineService {

    public static final String LINE_REGISTER_SUCCESS = "지하철 노선이 등록되었습니다.";
    public static final String LINE_UNREGISTER_SUCCESS = "지하철 노선이 삭제되었습니다.";

    public static void resisterLine(String name, Station firstStation, Station lastStation) {
        Line.of(name, firstStation, lastStation).save();
        OutputView.printInfo(LINE_REGISTER_SUCCESS);
    }

    public static void removeLineByName(String name) {
        if (!LineRepository.exists(name)) {
            throw new CannotFindLineByNameException(name);
        }
        LineRepository.deleteLine(name);
        OutputView.printInfo(LINE_UNREGISTER_SUCCESS);
    }

    public static void listAllStations() {
        LineRepository.lines().forEach(line -> OutputView.printInfo(line.getName()));
    }
}
