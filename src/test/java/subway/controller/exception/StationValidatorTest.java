package subway.controller.exception;

import org.junit.Test;

import subway.domain.Station;
import subway.domain.StationRepository;

public class StationValidatorTest {    
    @Test(expected = NameFormatException.class)
    public void testWrongFormatStationName() {
        StationValidator.validateRegisterStation("HankukUniversity");
        StationValidator.validateRegisterStation("123456역");
        StationValidator.validateRegisterStation("   ");
        StationValidator.validateRegisterStation("강남");
        StationValidator.validateRegisterStation("역");
    }

    @Test(expected = DuplicationException.class)
    public void testStationNameDuplication() {
        StationRepository.addStation(new Station("잠실역"));
        StationValidator.validateRegisterStation("잠실역");
    }
    
    @Test(expected = NotExistedElementException.class)
    public void testStationNameExistWhenDelete() {
        StationRepository.addStation(new Station("잠실역"));
        StationValidator.validateNotExistedStation("의정부역");
    }
}
