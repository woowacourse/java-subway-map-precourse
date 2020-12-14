package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.option.SectionOption;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;

public class SectionService extends BaseService {
    private static final String HEADER = "구간 관리 화면";
    private static final int MIN_LINE_LENGTH = 2;
    private static final String REGISTER_SECTION_LINE_NAME_QUESTION = "노선을 입력하세요.";
    private static final String REGISTER_SECTION_STATION_NAME_QUESTION = "역이름을 입력하세요.";
    private static final String REGISTER_SECTION_ORDER_NUMBER_QUESTION = "순서를 입력하세요.";
    private static final String REGISTER_SECTION_SUCCESS = "구간이 등록되었습니다.";
    private static final String DELETE_SECTION_LINE_NAME_QUESTION = "삭제할 구간의 노선을 입력하세요.";
    private static final String DELETE_SECTION_STATION_NAME_QUESTION = "삭제할 구간의 역을 입력하세요.";
    private static final String DELETE_SECTION_SUCCESS = "구간이 삭제되었습니다.";

    private static final String ERR_DUPLICATE_STATION_IN_LINE = "동일 노선에 동일한 이름의 역이 이미 있습니다.";
    private static final String ERR_MIN_LINE_LENGTH = "노선의 길이가 짧습니다.";
    private static final String ERR_NO_STATION_ON_LINE = "노선에 입력한 역이 없습니다.";

    public static void view() {
        getUserChoiceWithinOptionList(Arrays.asList(SectionOption.values()), HEADER);
    }

    public static void register() {
        Line line = getLineByQuestion(REGISTER_SECTION_LINE_NAME_QUESTION);
        Station station = getStationByQuestion(REGISTER_SECTION_STATION_NAME_QUESTION);
        checkDuplicateStationInLine(line, station);
        int index = getStationIndexToAdd();
        line.add(index, station);
        OutputView.printInfo(REGISTER_SECTION_SUCCESS);
    }

    public static void delete() {
        Line line = getLineByQuestion(DELETE_SECTION_LINE_NAME_QUESTION);
        Station station = getStationByQuestion(DELETE_SECTION_STATION_NAME_QUESTION);
        checkLineLengthPossibleToDelete(line);
        removeStationInLine(line, station);
        OutputView.printInfo(DELETE_SECTION_SUCCESS);
    }

    private static Line getLineByQuestion(String question) {
        OutputView.printQuestion(question);
        return LineRepository.getLine(InputView.getLineName());
    }

    private static Station getStationByQuestion(String question) {
        OutputView.printQuestion(question);
        return StationRepository.getStation(InputView.getStationName());
    }

    private static int getStationIndexToAdd() {
        OutputView.printQuestion(REGISTER_SECTION_ORDER_NUMBER_QUESTION);
        return InputView.getOrder() - 1;
    }

    private static void checkDuplicateStationInLine(Line line, Station station) {
        if (line.hasStation(station)) {
            throw new IllegalArgumentException(ERR_DUPLICATE_STATION_IN_LINE);
        }
    }

    private static void checkLineLengthPossibleToDelete(Line line) {
        if (line.getLength() <= MIN_LINE_LENGTH) {
            throw new IllegalArgumentException(ERR_MIN_LINE_LENGTH);
        }
    }

    private static void removeStationInLine(Line line, Station station) {
        if (!line.remove(station)) {
            throw new IllegalArgumentException(ERR_NO_STATION_ON_LINE);
        }
    }
}
