package subway.domain;

import subway.view.LineMessages;
import subway.view.SectionMessages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    public static final int NAME_LENGTH_LOWER_BOUND = 2;

    private String name;
    private final Sections sections = new Sections();

    public Line(String name, String upwardDestination, String downwardDestination) throws IllegalArgumentException {
        LineRepository.validateDuplicateName(name);
        validateNameLength(name);
        StationRepository.validateRegistration(upwardDestination);
        StationRepository.validateRegistration(downwardDestination);
        this.name = name;
        this.sections.addSection(new Station(upwardDestination));
        this.sections.addSection(new Station(downwardDestination));
    }

    public String getName() {
        return name;
    }

    public Sections getSections() {return sections;}

    private void validateNameLength(String name) throws IllegalArgumentException {
        if (name.length() < NAME_LENGTH_LOWER_BOUND) {
            throw new IllegalArgumentException(LineMessages.NAME_LENGTH_ERROR.getMessage());
        }
    }

    public static void validateInteger(String location) throws IllegalArgumentException {
        try {
            Integer.parseInt(location);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(SectionMessages.NON_POSITIVE_INTEGER_LOCATION_ERROR.getMessage());
        }
    }

    public static void validateSectionRange(String location, String lineName) throws IllegalArgumentException {
        int lineLength = LineRepository.getLine(lineName).sections.getSectionLength();
        if (Integer.parseInt(location) < 0 || lineLength <= Integer.parseInt(location)) {
            throw new IllegalArgumentException(SectionMessages.LOCATION_OUT_OF_RANGE_ERROR.getMessage());
        }
    }
}
