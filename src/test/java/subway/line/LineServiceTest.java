package subway.line;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import subway.line.domain.Line;
import subway.line.domain.LineRepository;
import subway.line.exception.AlreadyExistLineException;
import subway.line.exception.IllegalTypeOfNameException;
import subway.line.exception.NotExistLineException;
import subway.line.exception.TooShortLineNameException;
import subway.station.domain.Station;
import subway.station.domain.StationRepository;
import subway.station.exception.NotExistStationException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LineServiceTest {
    @BeforeEach
    public void setUp() {
        StationRepository.register(new Station("대구역"));
        StationRepository.register(new Station("동대구역"));
    }

    @AfterEach
    public void clearUp() {
        StationRepository.removeAll();
        LineRepository.removeAll();
    }

    @Test
    public void 지하철_노선_등록_기능_확인() {
        //given
        String lineName = "1호선";
        String topStationName = "대구역";
        String bottomStationName = "동대구역";

        //when
        LineService.register(lineName, topStationName, bottomStationName);

        //then
        assertThat(LineRepository.findByName(lineName).getName()).isEqualTo(lineName);
    }

    @Test
    public void 등록되지_않은_지하철역은_종점으로_등록될_수_없다() {
        //given
        String lineName = "1호선";
        String topStationName = "등록안된역";
        String bottomStationName = "이것도등록안됨";

        //when & then
        assertThatExceptionOfType(NotExistStationException.class)
                .isThrownBy(() -> LineService.register(lineName, topStationName, bottomStationName));
    }

    @Test
    public void 노선이름_두글자_미만이면_예외_발생() {
        //given
        String name = "선";
        String topStationName = "대구역";
        String bottomStationName = "동대구역";

        //when & then
        assertThatExceptionOfType(TooShortLineNameException.class)
                .isThrownBy(() -> LineService.register(name, topStationName, bottomStationName));
    }

    @Test
    public void 노선이름_한글_혹은_숫자가_아니면_예외_발생() {
        //given
        String name = "English";
        String topStationName = "대구역";
        String bottomStationName = "동대구역";

        //when & then
        assertThatExceptionOfType(IllegalTypeOfNameException.class)
                .isThrownBy(() -> LineService.register(name, topStationName, bottomStationName));
    }

    @Test
    public void 중복_노선_등록시_예외_발생() {
        //given
        String name = "1호선";
        String topStationName = "대구역";
        String bottomStationName = "동대구역";
        LineService.register(name, topStationName, bottomStationName);

        String duplicatedName = "1호선";

        //when & then
        assertThatExceptionOfType(AlreadyExistLineException.class)
                .isThrownBy(() -> LineService.register(duplicatedName, topStationName, bottomStationName));
    }

    @Test
    public void 노선_삭제기능_동작확인() {
        //given
        String name = "1호선";
        String topStationName = "대구역";
        String bottomStationName = "동대구역";
        LineService.register(name, topStationName, bottomStationName);

        //when
        LineService.remove(name);

        //then
        assertThat(LineRepository.isExist(name)).isFalse();
    }

    @Test
    public void 등록되지_않은_노선_삭제시_예외_발생() {
        //given
        String notExistLine = "1호선";

        //when & then
        assertThatExceptionOfType(NotExistLineException.class)
                .isThrownBy(() -> LineService.remove(notExistLine));
    }

    @Test
    public void 노선이_등록될때_각_종점들은_해당_노선을_자신의_노선_리스트에_추가해야함() {
        //given
        String lineName = "1호선";
        String topStationName = "잠실역";
        String bottomStationName = "강남역";

        Station topStation = new Station(topStationName);
        Station bottomStation = new Station(bottomStationName);

        //when
        Line line = LineCreator.createLine(lineName, topStation, bottomStation);

        //then
        assertThat(topStation.isRegistered()).isTrue();
        assertThat(bottomStation.isRegistered()).isTrue();
    }

    @Test
    public void 노선이_삭제될때_해당_노선에_등록된_각각의_역에_삭제될_노선_정보를_삭제해야함() {
        //given
        String lineName = "1호선";
        String topStationName = "잠실역";
        String bottomStationName = "강남역";

        StationRepository.register(new Station(topStationName));
        StationRepository.register(new Station(bottomStationName));

        LineService.register(lineName, bottomStationName, bottomStationName);

        //when
        LineService.remove(lineName);
        Station topStation = StationRepository.findByName(topStationName);
        Station bottomStation = StationRepository.findByName(bottomStationName);

        //then

        assertThat(topStation.isRegistered()).isFalse();
        assertThat(bottomStation.isRegistered()).isFalse();
    }
}