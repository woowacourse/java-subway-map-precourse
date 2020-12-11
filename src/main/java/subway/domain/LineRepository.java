package subway.domain;

import java.util.*;

public class LineRepository {
    private static final String ERROR_ALREADY_EXIST = "이미 등록된 노선 이름입니다.";
    private static final String ERROR_NOT_EXIST = "등록되지 않은 노선 이름입니다.";

    private static final List<Line> lines = new ArrayList<>();

    static {
        List<String> initialLines = new ArrayList<>(Arrays.asList(
                "2호선", "3호선", "신분당선"
        ));
        initialLines.stream()
                .map(Line::new)
                .forEach(LineRepository::addLine);
    }

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        if (lines.contains(line)) {
            throw new IllegalArgumentException(ERROR_ALREADY_EXIST);
        }
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        boolean removed = lines.removeIf(line -> Objects.equals(line.getName(), name));
        if (!removed) {
            throw new IllegalArgumentException(ERROR_NOT_EXIST);
        }
        return true;
    }
}
