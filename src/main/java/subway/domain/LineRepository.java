package subway.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import subway.Station_management;

public class LineRepository {
	static List<String> line2_stations = new ArrayList<String>(Arrays.asList("교대역","강남역","역삼역"));
	static List<String> line3_stations = new ArrayList<String>(Arrays.asList("교대역","남부터미널역","양재역","매봉역"));
	static List<String> line_sinbundang_stations = new ArrayList<String>(Arrays.asList("강남역","양재역","양재시민의숲역"));
	
	static Line line_2 = new Line("2호선", line2_stations);
	static Line line_3 = new Line("3호선", line3_stations);
	static Line line_sinbundang = new Line("신분당선", line_sinbundang_stations);
	
    private static final List<Line> lines = new ArrayList<>(Arrays.asList(line_2,line_3,line_sinbundang));    
    
    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }
}
