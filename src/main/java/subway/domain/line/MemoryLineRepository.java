package subway.domain.line;

import subway.exception.ErrorCode;
import subway.exception.LineException;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class MemoryLineRepository implements LineRepository {
    private static final Map<String, Line> lines = new ConcurrentHashMap<>();

    private MemoryLineRepository() {
    }

    public static MemoryLineRepository of() {
        return new MemoryLineRepository();
    }

    @Override
    public List<Line> lines() {
        return lines.values().stream().collect(Collectors.toList());
    }

    @Override
    public Line addLine(Line line) {
        if (findByName(line.getName()) != null) {
            throw new LineException(ErrorCode.LINE_ALREADY_EXIST);
        }
        lines.put(line.getName(), line);
        return line;
    }

    @Override
    public Line findByName(String name) {
        Line line = lines.get(name);
        return line;
    }

    @Override
    public boolean deleteLineByName(String name) {
        if (lines.containsKey(name)) {
            lines.remove(name);
            return true;
        }
        throw new LineException(ErrorCode.LINE_NOT_FOUND);
    }

    @Override
    public void removeAll() {
        lines.clear();
    }
}
