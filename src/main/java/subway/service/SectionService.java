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
    private static final String ERR_MIN_LINE_LENGTH = "노선의 길이가 짧습니다.";
    private static final String ERR_NO_STATION_ON_LINE = "노선에 입력한 역이 없습니다.";
    private static final String DELETE_SECTION_SUCCESS = "구간이 삭제되었습니다.";

    public static void view() {
        getUserChoiceWithinOptionList(Arrays.asList(SectionOption.values()), HEADER);
    }

    public static void register() {
        OutputView.printQuestion(REGISTER_SECTION_LINE_NAME_QUESTION);
        Line line = LineRepository.getLine(InputView.getLineName());
        OutputView.printQuestion(REGISTER_SECTION_STATION_NAME_QUESTION);
        Station station = StationRepository.getStation(InputView.getStationName());
        OutputView.printQuestion(REGISTER_SECTION_ORDER_NUMBER_QUESTION);
        int order = InputView.getOrder();
        line.add(order - 1, station);
        OutputView.printInfo(REGISTER_SECTION_SUCCESS);
    }

    public static void delete() {
        OutputView.printQuestion(DELETE_SECTION_LINE_NAME_QUESTION);
        Line line = LineRepository.getLine(InputView.getLineName());
        OutputView.printQuestion(DELETE_SECTION_STATION_NAME_QUESTION);
        Station station = StationRepository.getStation(InputView.getStationName());
        if (line.getLength() <= MIN_LINE_LENGTH) {
            throw new IllegalArgumentException(ERR_MIN_LINE_LENGTH);
        }
        if (!line.remove(station)) {
            throw new IllegalArgumentException(ERR_NO_STATION_ON_LINE);
        }
        OutputView.printInfo(DELETE_SECTION_SUCCESS);
    }
}
