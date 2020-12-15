package subway.controller.validator;

import org.junit.Test;

import subway.controller.exception.DuplicationException;
import subway.controller.exception.IllegalElementException;
import subway.controller.exception.NameFormatException;
import subway.controller.exception.NotExistedElementException;
import subway.controller.validator.LineValidator;
import subway.domain.Line;
import subway.domain.LineRepository;

public class LineValidatorTest {
    @Test(expected = NameFormatException.class)
    public void testWrongFormatLineName() {
        LineValidator.validateLineName("HankukUniversity");
        LineValidator.validateLineName("    ");
        LineValidator.validateLineName("선");
        LineValidator.validateLineName("22222");
        LineValidator.validateLineName("2");
    }

    @Test(expected = DuplicationException.class)
    public void testLineNameDuplication() {
        LineRepository.addLine(new Line("2호선"));
        LineValidator.validateDuplication("2호선");
    }

    @Test(expected = IllegalElementException.class)
    public void testUpStationEqualsDownStation() {
        LineValidator.validateUpAndDownIsEqual("양재역", "양재역");
    }

    @Test(expected = NotExistedElementException.class)
    public void testLineNameExistWhenDelete() {
        LineRepository.addLine(new Line("2호선"));
        LineValidator.validateNotExistedLine("8호선");
    }
}
