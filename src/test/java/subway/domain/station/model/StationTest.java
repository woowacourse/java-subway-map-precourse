package subway.domain.station.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StationTest {

    @DisplayName("Station 객체를 생성하는 기능을 테스트한다")
    @ParameterizedTest
    @ValueSource(strings = {
            "강남역", "사당역", "봉천역", "신림역", "서울대입구역"
    })
    void testInitStation(String name) {
        //when
        Station station = new Station(name);

        //then
        assertThat(station).extracting("name").isEqualTo(name);
    }

    @DisplayName("최소 역이름 길이보다 역이름이 짧을 경우 예외를 발생하는 기능을 테스트한다 ")
    @ParameterizedTest()
    @ValueSource(strings = {
            "역", "녁", "곳"
    })
    @EmptySource
    void testInitStationIfNameShorterThanMinLimitStationName(String name) {
        //when //then
        assertThatThrownBy(() -> new Station(name))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
