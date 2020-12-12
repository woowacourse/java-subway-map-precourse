package subway.controller.exception;

import org.junit.Test;

import subway.domain.Station;
import subway.domain.StationRepository;

public class StationValidatorTest {
    @Test(expected = NameFormatException.class)
    public void testWrongFormatStationName() {
        StationValidator.validateStationName("HankukUniversity");
        StationValidator.validateStationName("123456역");
        StationValidator.validateStationName("   ");
        StationValidator.validateStationName("강남");
        StationValidator.validateStationName("역");
    }

    @Test(expected = DuplicationException.class)
    public void testStationNameDuplication() {
        StationRepository.addStation(new Station("잠실역"));
        StationValidator.validateDuplication("잠실역");
    }
}
