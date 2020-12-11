package subway.domain.Line;

import subway.exception.AlreadyAddLineException;
import subway.exception.LineNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public Line findBy(String name) {
        return lines().stream()
                .filter(l -> l.isSameName(name)).findFirst()
                .orElseThrow(() -> new AlreadyAddLineException(name));
    }

    public void addLine(Line line) { //기존 메서드

        if (lines().contains(line)) {
            throw new AlreadyAddLineException(line.toString());
        }
        lines.add(line);
    }

    public boolean deleteLineByName(String name) {   //기존 메서드

        boolean result = lines().removeIf(l -> l.isSameName(name));

        if (!result) {
            throw new LineNotFoundException(name);
        }
        return result;
    }


}
