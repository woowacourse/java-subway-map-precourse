package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.exception.LineNameDuplicateException;
import subway.exception.NameLengthException;

public class LineService {
    private static final int MIN_NAME_LENGTH = 2;

    public static void save(Line line) {
        validateNameLength(line.getName());
        validateDuplicateName(line.getName());
        line.initTerminalStations();
        LineRepository.addLine(line);
    }

    private static void validateNameLength(String name) {
        if (name.length() < MIN_NAME_LENGTH) {
            throw new NameLengthException();
        }
    }

    private static void validateDuplicateName(String name) {
        if (LineRepository.findByName(name).isPresent()) {
            throw new LineNameDuplicateException();
        }
    }
}
