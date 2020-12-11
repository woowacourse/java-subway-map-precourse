package subway.line;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import subway.line.domain.LineRepository;
import subway.line.exception.IllegalTypeOfNameException;
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
}