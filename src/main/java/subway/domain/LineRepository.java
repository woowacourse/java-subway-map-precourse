package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final String[] LINES = {"2호선","3호선","신분당선"};
    private static final String[][] STATIONS = {{"교대역","강남역","역삼역"},{"교대역","남부터미널역","양재역" ,"매봉역"},{"강남역","양재역","양재시민의숲역"}};

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

    public static void init() {
        int index = 0;
        for(String lineName : LINES){
            Line line = new Line(lineName);
            line.addStations(STATIONS[index++]);
            addLine(line);
        }
    }

    public static boolean lineRegisterStation(String name) {
        for(Line line : lines){
            if(line.existStation(name)){
                return true;
            }
        }
        return false;
    }
}
