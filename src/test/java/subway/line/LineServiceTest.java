package subway.line;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import subway.line.domain.LineRepository;
import subway.station.domain.Station;
import subway.station.domain.StationRepository;
import subway.station.exception.NotExistException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LineServiceTest {
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

        StationRepository.register(new Station(topStationName));
        StationRepository.register(new Station(bottomStationName));

        //when
        LineService.register(lineName, topStationName, bottomStationName);

        //then
        assertThat(LineRepository.findByName(lineName).getName()).isEqualTo(lineName);
    }

    @Test
    public void 등록되지_않은_지하철역은_종점으로_등록될_수_없다() {
        //given
        String lineName = "1호선";
        String topStationName = "대구역";
        String bottomStationName = "동대구역";

        //when & then
        assertThatExceptionOfType(NotExistException.class)
                .isThrownBy(() -> LineService.register(lineName, topStationName, bottomStationName));
    }
}