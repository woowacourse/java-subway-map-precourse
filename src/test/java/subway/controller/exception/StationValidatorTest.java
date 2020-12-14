package subway.controller.exception;

import org.junit.Test;

import subway.controller.LineController;
import subway.controller.validator.StationValidator;
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

    @Test(expected = NotExistedElementException.class)
    public void testStationNameExistWhenDelete() {
        StationRepository.addStation(new Station("잠실역"));
        StationValidator.validateNotExistedStation("의정부역");
    }

    @Test(expected = IllegalElementException.class)
    public void testStationHasBeenRegisteredWhenDelete() {
        StationRepository.addStation(new Station("양재역"));
        StationRepository.addStation(new Station("판교역"));
        LineController.makeNewLine("신분당선", "양재역", "판교역");
        StationValidator.validateStationRegisterInLine("양재역");
    }
}
