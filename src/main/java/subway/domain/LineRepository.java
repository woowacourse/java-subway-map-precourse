package subway.domain;

import subway.Constant;

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
        if(lines.stream().anyMatch(o -> o.getName().equals(line.getName()))){
            System.out.println(String.join(" ", Constant.ERROR_PREFIX, Constant.DUPLICATE_LINE_NAME));
            return;
        }
        lines.add(line);
        System.out.println(String.join(" ", Constant.INFO_PREFIX, Constant.ADD_LINE_SUCCESS));
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void printLines(){
        for(int i=0; i<lines.size(); i++){
            System.out.println(String.join(" ", Constant.INFO_PREFIX, lines.get(i).getName()));
        }
    }
}
