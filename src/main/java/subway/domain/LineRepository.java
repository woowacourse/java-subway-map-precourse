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
        System.out.println("addline 실행");
        if(!(line.getName()==null)){
            lines.add(line);
        }
        System.out.println(line.getName());
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }
    public static void printLine(){
        for(int i=0;i<lines.size();i++){
            System.out.println("[INFO] "+lines.get(i).getName());
        }
    }

}
