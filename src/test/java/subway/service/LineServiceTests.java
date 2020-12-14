package subway.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.station.Station;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LineServiceTests {
    private LineService lineService;
    private StationService stationService;

    @BeforeEach
    public void 초기화() {
        stationService = new StationService();
        lineService = new LineService(stationService);
    }

    @Test
    public void line_추가_테스트() {
        String lineName = "1호선";
        String upwardEndStationName = "소요산";
        String downwardEndStationName = "인천";
        stationService.addStation(new Station(upwardEndStationName));
        stationService.addStation(new Station(downwardEndStationName));

        Line line = Line.createLine(lineName, upwardEndStationName, downwardEndStationName);

        assertThatCode(() -> lineService.addLine(line))
                .doesNotThrowAnyException();

        List<Line> lines = LineRepository.lines();
        assertThat(lines.contains(line))
                .isTrue();
    }

    @Test
    public void line_없는_이름의_역추가_테스트() {
        String lineName = "10호선";
        String upwardEndStationName = "존재하는 역이름";
        String downwardEndStationName = "존재하지 않는 역이름";
        stationService.addStation(new Station(upwardEndStationName));

        Line line = Line.createLine(lineName, upwardEndStationName, downwardEndStationName);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> lineService.addLine(line));
    }
}
