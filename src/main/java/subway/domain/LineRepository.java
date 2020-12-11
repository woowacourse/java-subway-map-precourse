package subway.domain;

import java.util.*;

public class LineRepository {
    private static final String LINE_DUPLICATE_ERROR = "[ERROR] 이미 등록되어 있는 노선입니다.";
    private static final String LINE_EXIST_ERROR = "[ERROR] 등록되어 있는 노선이 아닙니다.";
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
        for (Line l : lines) {
            System.out.print(l.getName()+" ");
        }
        System.out.println();
    }

    public static void validateDuplicate(Line line) {
        Set<Line> duplicateCheckSet = new HashSet<>(lines);
        duplicateCheckSet.add(line);
        if (duplicateCheckSet.size() == lines.size()) {
            throw new IllegalArgumentException(LINE_DUPLICATE_ERROR);
        }
    }

    public static boolean deleteLineByName(String name) {
        validateNameExist(new Line(name));
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void validateNameExist(Line newLine) {
        boolean nameFlag = true;
        for (Line line : lines) {
            if (line.equals(newLine)) {
                nameFlag = false;
                break;
            }
        }
        if (nameFlag) {
            throw new IllegalArgumentException(LINE_EXIST_ERROR);
        }
    }


}
