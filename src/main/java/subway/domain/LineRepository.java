package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

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

	public static Line findStation(String name) {
    	for(int templine=0; templine<lines.size();templine++)
    	{
    		if (lines.get(templine).getName().equals(name))
    		{
    			Line line = lines.get(templine);
    			return line;
    		}
    	}
    	System.out.println(name+ " ¸øÃ£À½");
		return null;
	}

	public static void viewLineRepository() {
		for (int line = 0; line < lines.size(); line++) {
			lines.get(line).viewLine();
			System.out.println("");
		}
	}
}
