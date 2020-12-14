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
    private static final String HEADER = "노선 관리 화면";
    private static final String REGISTER_LINE_QUESTION = "등록할 노선 이름을 입력하세요.";
    private static final String START_STATION_QUESTION = "등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String END_STATION_QUESTION = "등록할 노선의 하행 종점역 이름을 입력하세요.";
    private static final String REGISTER_LINE_SUCCESS = "지하철 노선이 등록되었습니다.";
    private static final String DELETE_LINE_QUESTION = "삭제할 노선 이름을 입력하세요.";
    private static final String DELETE_LINE_SUCCESS = "지하철 노선이 삭제되었습니다.";

    private static final String ERR_UNREGISTERED_LINE = "등록되지 않은 노선입니다.";

    public static void view() {
        getUserChoiceWithinOptionList(Arrays.asList(LineOption.values()), HEADER);
    }

    public static void register() {
        String lineName = getLineNameByQuestion(REGISTER_LINE_QUESTION);
        Station startStation = getStationByQuestion(START_STATION_QUESTION);
        Station endStation = getStationByQuestion(END_STATION_QUESTION);
        addLine(lineName, startStation, endStation);
    }

    public static void delete() {
        String lineName = getLineNameByQuestion(DELETE_LINE_QUESTION);
        deleteLine(lineName);
    }

    public static void printSubwayLineList() {
        OutputView.printSubwayLineList(LineRepository.lines());
    }

    private static void addLine(String lineName, Station startStation, Station endStation) {
        LineRepository.addLine(new Line(lineName, startStation, endStation));
        OutputView.printInfo(REGISTER_LINE_SUCCESS);
    }

    private static void deleteLine(String lineName) {
        if (!LineRepository.deleteLineByName(lineName)) {
            throw new IllegalArgumentException(ERR_UNREGISTERED_LINE);
        }
        OutputView.printInfo(DELETE_LINE_SUCCESS);
    }
}
