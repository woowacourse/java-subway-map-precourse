package subway.domain;

import subway.dto.LineDTO;
import subway.exception.DuplicatedObjectException;
import subway.exception.NoSuchObjectException;
import subway.exception.NoneObjectException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LineRepository {
    private static final String ERROR_ALREADY_EXIST = "이미 등록된 노선 이름입니다.";
    private static final String ERROR_NOT_EXIST = "등록되지 않은 노선 이름입니다.";
    private static final String ERROR_NO_LINES = "등록된 노선이 없습니다.";
    private static final int ZERO = 0;

    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        if (lines.size() == ZERO) {
            throw new NoneObjectException(ERROR_NO_LINES);
        }
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        if (lines.contains(line)) {
            throw new DuplicatedObjectException(ERROR_ALREADY_EXIST);
        }
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        boolean removed = lines.removeIf(line -> Objects.equals(line.getName(), name));
        if (!removed) {
            throw new NoSuchObjectException(ERROR_NOT_EXIST);
        }
        return true;
    }

    public static Line searchByName(String name) {
        for (Line line : lines) {
            if (line.getName().equals(name)) {
                return line;
            }
        }
        throw new NoSuchObjectException(ERROR_NOT_EXIST);
    }

    public static List<LineDTO> exprotsAllLinesToDTO() {
        if (lines.size() == ZERO) {
            throw new NoneObjectException(ERROR_NO_LINES);
        }
        return lines.stream()
                .map(Line::toDTO)
                .collect(Collectors.toList());
    }
}
