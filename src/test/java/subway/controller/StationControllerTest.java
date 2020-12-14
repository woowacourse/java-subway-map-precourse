package subway.controller;

import org.junit.jupiter.api.Test;
import subway.DummyData;
import subway.domain.*;

import static org.junit.jupiter.api.Assertions.*;

class StationControllerTest {

    @Test
    void addStation() {
        DummyData.initialize();

        int beforeSize = StationRepository.getStationNames().size();
        StationRepository.addStation(Station.create(new Name("죽전역")));
        int afterSize = StationRepository.getStationNames().size();
        assertEquals(beforeSize + 1, afterSize);
    }

    @Test
    void addStation_Expect_Exception() {
        DummyData.initialize();

        // 중복 이름의 역 추가 불가능
        assertThrows(Exception.class, () -> {
            StationRepository.addStation(Station.create(new Name("교대역")));
        });
    }
}