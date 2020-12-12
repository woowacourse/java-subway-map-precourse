package subway.section;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import subway.line.domain.Line;
import subway.line.domain.LineRepository;
import subway.line.domain.Route;
import subway.line.exception.NotExistLineException;
import subway.station.domain.Station;
import subway.station.domain.StationRepository;
import subway.station.exception.AlreadyExistStationException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class SectionServiceTest {
    private static final String LINE_NUMBER_ONE = "1호선";
    private static final String TOP_STATION = "대구역";
    private static final String BOTTOM_STATION = "대구역";

    @BeforeEach
    void setUp() {
        Station topStation = new Station(TOP_STATION);
        Station bottomStation = new Station(BOTTOM_STATION);
        StationRepository.register(topStation);
        StationRepository.register(bottomStation);
        LineRepository.register(new Line(LINE_NUMBER_ONE, new Route(topStation, bottomStation)));
    }

    @AfterEach
    void clearUp() {
        LineRepository.removeAll();
        StationRepository.removeAll();
    }

    @Test
    void 구간_등록_동작_확인() {
        //given
        String lineName = LINE_NUMBER_ONE;
        String newStation = "새로운역";
        int order = 1;

        StationRepository.register(new Station(newStation));

        //when
        SectionService.register(lineName, newStation, order);
        boolean isExist = LineRepository.findByName(lineName)
                .isExist(newStation);

        //then
        assertThat(isExist).isTrue();
    }

    @Test
    void 추가하려는_노선이_등록되지_않은_노선이면_예외_발생() {
        //given
        String notExistLine = "등록되지않은노선";
        String newStation = "새로운역";
        int order = 1;

        StationRepository.register(new Station(newStation));

        //when & then
        assertThatExceptionOfType(NotExistLineException.class)
                .isThrownBy(() -> SectionService.register(notExistLine, newStation, order));
    }

    @Test
    void 추가하려는_구간의_역_해당_노선에_이미_존재하는_역이면_예외_발생() {
        //given
        String alreadyExistStation = TOP_STATION;
        int order = 1;

        //when & then
        assertThatExceptionOfType(AlreadyExistStationException.class)
                .isThrownBy(() -> SectionService.register(LINE_NUMBER_ONE, alreadyExistStation, order));
    }
}