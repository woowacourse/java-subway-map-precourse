package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.option.LineOption;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;

public class LineService extends BaseService {
    private static final String HEADER = "## 노선 관리 화면";
    private static final String REGISTER_LINE_QUESTION = "## 등록할 노선 이름을 입력하세요.";
    private static final String START_STATION_QUESTION = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String END_STATION_QUESTION = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    private static final String REGISTER_LINE_SUCCESS = "지하철 노선이 등록되었습니다.";
    private static final String DELETE_LINE_QUESTION = "## 삭제할 노선 이름을 입력하세요.";
    private static final String ERR_UNREGISTERED_LINE = "등록되지 않은 노선입니다.";
    private static final String DELETE_LINE_SUCCESS = "지하철 노선이 삭제되었습니다.";

    public static void view() {
        getUserChoiceWithinOptionList(Arrays.asList(LineOption.values()), HEADER);
    }

    public static void register() {
        OutputView.println(REGISTER_LINE_QUESTION);
        String lineName = InputView.getLineName();
        OutputView.printInfo(START_STATION_QUESTION);
        Station startStation = StationRepository.getStation(InputView.getStationName());
        OutputView.println(END_STATION_QUESTION);
        Station endStation = StationRepository.getStation(InputView.getStationName());
        LineRepository.addLine(new Line(lineName, startStation, endStation));
        OutputView.printInfo(REGISTER_LINE_SUCCESS);
    }

    public static void delete() {
        OutputView.println(DELETE_LINE_QUESTION);
        if (!LineRepository.deleteLineByName(InputView.getLineName())) {
            throw new IllegalArgumentException(ERR_UNREGISTERED_LINE);
        }
        OutputView.printInfo(DELETE_LINE_SUCCESS);
    }
    public static void printSubwayLineList() {
        OutputView.printSubwayLineList(LineRepository.lines());
    }
}
