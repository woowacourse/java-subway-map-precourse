package subway.domain.line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.commonprint.Prefix;

/*
필요 시 StationRepository, LineRepository 이 외 추가로 Repository를 만들 수 있다.
추가로 생성되는 객체에 대해서 XXXRepository 네이밍으로 저장 클래스를 추가할 수 있다.
객체들의 상태를 관리하기 위해서 XXXRepository 클래스를 활용해 저장 로직을 구현해야 한다.
필요에 따라 자유롭게 수정이 가능하다.
* */
public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static Line findByName(String lineName) {
        for (Line line : lines) {
            if (line.getName().equals(lineName)) {
                return line;
            }
        }
        return null;
    }

    public static void printAllLines() {
        lines.forEach(
            line -> System.out.println(Prefix.INFO_PREFIX + line.getName())
        );
    }
}
