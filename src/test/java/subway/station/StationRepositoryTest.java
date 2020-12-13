package subway.station;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StationRepositoryTest {

    @Test
    void 중복된_역_등록시_예외처리() {
        // given
        String input = "강남역";

        // when
        StationRepository.addStation(new Station(input));

        // then
        assertThrows(Exception.class, () -> {
            StationRepository.checkDuplicateStation(input);
        });
    }

    @Test
    void 존재하지_않는_역이름_예외처리() {
        // given, when
        String input = "강남역";

        // then
        assertThrows(Exception.class, () -> {
            StationRepository.checkStationExist(input);
        });
    }

}