package subway.domain.line;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class MemoryLineRepository implements LineRepository {
    private static Map<String, Line> lines = new ConcurrentHashMap<>();

    @Override
    public List<Line> lines() {
        return lines.values().stream().collect(Collectors.toList());
    }

    @Override
    public void addLine(Line line) {
        lines.put(line.getName(), line);
    }

    @Override
    public boolean deleteLineByName(String name) {
        if (lines.containsKey(name)) {
            lines.remove(name);
            return true;
        }
        return false;
    }
}
