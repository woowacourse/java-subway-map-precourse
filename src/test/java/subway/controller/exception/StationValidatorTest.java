package subway.controller.exception;

import org.junit.Test;

import subway.domain.Station;
import subway.domain.StationRepository;

public class StationValidatorTest {    
    @Test(expected = NameFormatException.class)
    public void testWrongFormatStationName() {
        StationValidator.validateStation("HankukUniversity");
        StationValidator.validateStation("123456역");
        StationValidator.validateStation("   ");
        StationValidator.validateStation("강남");
        StationValidator.validateStation("역");
    }

    @Test(expected = DuplicationException.class)
    public void testStationNameDuplication() {
        StationRepository.addStation(new Station("잠실역"));
        StationValidator.validateStation("잠실역");
    }
    
    @Test(expected = NotExistedElementException.class)
    public void testStationNameExistWhenDelete() {
        StationRepository.addStation(new Station("잠실역"));
        boolean deletion = StationRepository.deleteStation("의정부역");
        StationValidator.validateExistedStation(deletion);
    }
}
