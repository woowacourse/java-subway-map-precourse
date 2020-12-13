package subway.domain;

import static org.assertj.core.api.Assertions.*;
import static subway.resource.TextResource.ERROR_STATION_NAME_LENGTH;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StationTest {

    @DisplayName("지하철 역 이름은 MIN_STATION_NAME_LENGTH 설정 값 이상이어야 한다")
    @Test
    public void checkStationNameOverConfigLength() {
        assertThatThrownBy(() -> {
            Station station = new Station("가");
        }).isInstanceOf(IllegalArgumentException.class).hasMessage(
            ERROR_STATION_NAME_LENGTH
        );
    }
}
