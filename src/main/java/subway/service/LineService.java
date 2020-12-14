package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.option.LineOption;
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

    private static final String ERR_DUPLICATE_LINE_NAME = "이미 등록된 노선 이름입니다.";
    private static final String ERR_UNREGISTERED_LINE = "등록되지 않은 노선입니다.";

    public static void view() {
        getUserChoiceWithinOptionList(Arrays.asList(LineOption.values()), HEADER);
    }

    public static void register() {
        String lineName = getLineNameByQuestion(REGISTER_LINE_QUESTION);
        checkDuplicateLineName(lineName);
        Station startStation = getStationByQuestion(START_STATION_QUESTION);
        Station endStation = getStationByQuestion(END_STATION_QUESTION);
        registerLine(lineName, startStation, endStation);
    }

    public static void delete() {
        String lineName = getLineNameByQuestion(DELETE_LINE_QUESTION);
        deleteLine(lineName);
    }

    public static void printSubwayLineList() {
        OutputView.printSubwayLineList(LineRepository.lines());
    }

    private static void checkDuplicateLineName(String lineName) {
        if (LineRepository.hasLineNamed(lineName)) {
            throw new IllegalArgumentException(ERR_DUPLICATE_LINE_NAME);
        }
    }

    private static void registerLine(String lineName, Station startStation, Station endStation) {
        Line line = new Line(lineName);
        line.add(startStation,endStation);
        LineRepository.addLine(line);
        OutputView.printInfo(REGISTER_LINE_SUCCESS);
    }

    private static void deleteLine(String lineName) {
        if (!LineRepository.deleteLineByName(lineName)) {
            throw new IllegalArgumentException(ERR_UNREGISTERED_LINE);
        }
        OutputView.printInfo(DELETE_LINE_SUCCESS);
    }
}
