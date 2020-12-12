package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.question.LineQuestion;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;

public class LineService extends BaseService {
    private static final String ERR_UNREGISTERED_LINE = "등록되지 않은 노선입니다.";

    public static void main () {
        view(Arrays.asList(LineQuestion.values()), LineQuestion.HEADER);
    }

    public static void register() {
        OutputView.printRegisterLineQuestion();
        String lineName = InputView.getLineName();
        OutputView.printLineStartStationQuestion();
        Station startStation = StationRepository.getStation(InputView.getStationName());
        OutputView.printLineEndStationQuestion();
        Station endStation = StationRepository.getStation(InputView.getStationName());
        LineRepository.addLine(new Line(lineName, startStation, endStation));
        OutputView.printRegisterLineSuccess();
    }

    public static void delete() {
        OutputView.printDeleteLineQuestion();
        if (!LineRepository.deleteLineByName(InputView.getLineName())) {
            throw new IllegalArgumentException(ERR_UNREGISTERED_LINE);
        }
        OutputView.printDeleteLineSuccess();
    }
    public static void printSubwayLineList() {
        OutputView.printSubwayLineList(LineRepository.lines());
    }

}
