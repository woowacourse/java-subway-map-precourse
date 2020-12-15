package subway.domain;

import static subway.message.ErrorMessage.LINE_REPOSITORY_LINE_ALREADY_EXIST;
import static subway.message.ErrorMessage.LINE_REPOSITORY_LINE_DOES_NOT_EXIST;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class LineRepository {

    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(final Line line) throws IllegalArgumentException {
        validateLineNameDuplicate(line.getName());
        lines.add(line);
    }

    private static void validateLineNameDuplicate(String lineName) {
        if (getLineByName(lineName).isPresent()) {
            throw new IllegalArgumentException(LINE_REPOSITORY_LINE_ALREADY_EXIST.toString());
        }
    }

    public static void deleteLineByName(String name) throws IllegalArgumentException {
        final int index = validateLineExistInRepository(name);
        lines.get(index).removeAllStations(); // 역들에서 해당 노선에 포함되었다는 정보를 제거하기 위해 노선 내의 모든 역을 제거
        lines.remove(index);
    }

    private static int validateLineExistInRepository(String name) {
        AtomicInteger atomicInteger = new AtomicInteger(-1);
        boolean isAny = lines.stream()
            .peek(v -> atomicInteger.incrementAndGet())
            .anyMatch(line -> line.getName().equals(name));
        if (!isAny) {
            throw new IllegalArgumentException(LINE_REPOSITORY_LINE_DOES_NOT_EXIST.toString());
        }

        return atomicInteger.intValue();
    }

    public static Optional<Line> getLineByName(String name) {
        return lines.stream().filter(line -> line.getName().equals(name)).findFirst();
    }
}
