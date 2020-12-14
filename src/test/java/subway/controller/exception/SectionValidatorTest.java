package subway.controller.exception;

import org.junit.Before;
import org.junit.Test;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class SectionValidatorTest {
    @Before
    public void setUp() {
        StationRepository.addStation(new Station("산성역"));
        StationRepository.addStation(new Station("암사역"));
        Line line = new Line("8호선");
        line.addStation("산성역");
        line.addStation("암사역");
        LineRepository.addLine(line);
    }
    
    @Test(expected = IllegalElementException.class)
    public void testSectionDuplication() {
        SectionValidator.validateStationCanMakeSection("8호선", "산성역");
    }
    
    @Test(expected = IllegalElementException.class)
    public void testOrderIsNaturalNumber() {
        SectionValidator.validateOrder("8호선", "0.5");
        SectionValidator.validateOrder("8호선", "-4");
        SectionValidator.validateOrder("8호선", "abc");
    }
    
    @Test(expected = IllegalElementException.class)
    public void testOrderIsLowerThanLineSize() {
        SectionValidator.validateOrder("8호선", "5");
    }
}
