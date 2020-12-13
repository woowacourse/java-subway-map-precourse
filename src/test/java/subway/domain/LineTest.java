package subway.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static subway.resource.TextResource.ERROR_LINE_NAME_LENGTH;
import static subway.resource.TextResource.ERROR_NOT_EXISTENCE_STATION;
import static subway.resource.TextResource.ERROR_START_END_STATION_DUPLICATED;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {
    @DisplayName("노선의 이름은 MIN_LINE_NAME_LENGTH 설정 값 이상이어야 한다")
    @Test
    public void checkLineNameOverConfigLength() {
        assertThatThrownBy(() -> {
            Line line = new Line("가", "강남역", "교대역");
        }).isInstanceOf(IllegalArgumentException.class).hasMessage(
            ERROR_LINE_NAME_LENGTH
        );
    }

    @DisplayName("상행 종점역과 하행 종점역은 존재 해야 한다.")
    @Test
    public void checkLineStartOrEndStationNotExistence() {
        StationRepository.addStation(new Station("교대역"));
        assertThatThrownBy(() -> {
            Line line = new Line("가나다역", "존재하지않는역", "교대역");
        }).isInstanceOf(IllegalArgumentException.class).hasMessage(
            ERROR_NOT_EXISTENCE_STATION
        );

        assertThatThrownBy(() -> {
            Line line = new Line("가나다역", "교대역", "존재하지않는역");
        }).isInstanceOf(IllegalArgumentException.class).hasMessage(
            ERROR_NOT_EXISTENCE_STATION
        );

        assertThatThrownBy(() -> {
            Line line = new Line("가나다역", "1존재하지않는역", "2존재하지않는역");
        }).isInstanceOf(IllegalArgumentException.class).hasMessage(
            ERROR_NOT_EXISTENCE_STATION
        );
    }

    @DisplayName("상행 종점역과 하행 종점역은 같은 역일 수 없다.")
    @Test
    public void checkLineStartAndEndStationSame() {
        StationRepository.addStation(new Station("교대역"));
        assertThatThrownBy(() -> {
            Line line = new Line("가나다역", "교대역", "교대역");
        }).isInstanceOf(IllegalArgumentException.class).hasMessage(
            ERROR_START_END_STATION_DUPLICATED
        );
    }
}
