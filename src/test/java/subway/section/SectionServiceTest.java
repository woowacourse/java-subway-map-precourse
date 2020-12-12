package subway.section;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import subway.line.domain.Line;
import subway.line.domain.LineRepository;
import subway.line.domain.Route;
import subway.line.exception.NotExistLineException;
import subway.section.exception.InvalidOrderException;
import subway.station.domain.Station;
import subway.station.domain.StationRepository;
import subway.station.exception.AlreadyExistStationException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class SectionServiceTest {
    private static final String LINE_NUMBER_ONE = "1호선";
    private static final String TOP_STATION = "대구역";
    private static final String BOTTOM_STATION = "대구역";
    private static final String EXTRA_STATION = "반월당역";

    @BeforeEach
    void setUp() {
        Station topStation = new Station(TOP_STATION);
        Station bottomStation = new Station(BOTTOM_STATION);
        Station extraStation = new Station(EXTRA_STATION);

        StationRepository.register(topStation);
        StationRepository.register(bottomStation);
        StationRepository.register(extraStation);

        LineRepository.register(new Line(LINE_NUMBER_ONE, new Route(topStation, bottomStation)));
        SectionService.register(LINE_NUMBER_ONE, EXTRA_STATION, 2);
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

    @Test
    void 추가하려는_구간의_순서가_허용범위를_벗어나면_예외_발생() {
        //given
        String newStation = "새로운역";
        int order = 5;

        StationRepository.register(new Station(newStation));

        //when & then
        assertThatExceptionOfType(InvalidOrderException.class)
                .isThrownBy(() -> SectionService.register(LINE_NUMBER_ONE, newStation, order));
    }

    @Test
    void 구간삭제_동작_확인() {
        //given
        String targetStation = EXTRA_STATION;

        //when
        SectionService.remove(LINE_NUMBER_ONE, targetStation);
        boolean isExist = LineRepository.findByName(LINE_NUMBER_ONE)
                .isExist(targetStation);

        //then
        assertThat(isExist).isFalse();
    }

    @Test
    void 삭제하려는_구간의_노선이_등록되지_않은_노선이면_예외발생() {
        //given
        String notExistLine = "등록되지않은노선";

        //when & then
        assertThatExceptionOfType(NotExistLineException.class)
                .isThrownBy(() -> SectionService.remove(notExistLine, EXTRA_STATION));
    }
}