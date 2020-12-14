package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
	private static final String NOT_FOUND_LINE_MESSAGE = "입력한 노선을 찾을 수 없습니다.";
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }
    
    public static Line getLineByName(String name) {
    	for(Line line : lines) {
    		if(line.getName().equals(name)) {
    			return line;
    		}
    	}
		throw new IllegalArgumentException(NOT_FOUND_LINE_MESSAGE);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }
}
