package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class SectionService {
    private static final int MIN_LINE_LENGTH = 2;
    private static final String ERR_MIN_LINE_LENGTH = "노선의 길이가 짧습니다.";
    private static final String ERR_NO_STATION_ON_LINE = "노선에 입력한 역이 없습니다.";

    public static void register() {
        OutputView.printRegisterSectionLineNameQuestion();
        Line line = LineRepository.getLine(InputView.getLineName());
        OutputView.printRegisterSectionStationNameQuestion();
        Station station = StationRepository.getStation(InputView.getStationName());
        OutputView.printRegisterSectionOrderNumberQuestion();
        int order = InputView.getOrder();
        line.add(order-1, station);
        OutputView.printRegisterSectionSuccess();
    }

    public static void delete() {
        OutputView.printDeleteSectionLineNameQuestion();
        Line line = LineRepository.getLine(InputView.getLineName());
        OutputView.printDeleteSectionStationNameQuestion();
        Station station = StationRepository.getStation(InputView.getStationName());
        if (line.getLength() <= MIN_LINE_LENGTH) {
            throw new IllegalArgumentException(ERR_MIN_LINE_LENGTH);
        }
        if (!line.remove(station)) {
            throw new IllegalArgumentException(ERR_NO_STATION_ON_LINE);
        }
        OutputView.printDeleteSectionSuccess();
    }
}
