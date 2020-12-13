package subway.domain;

import subway.Constant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();
    static StationRepository stationRepository = new StationRepository();
    private static final String NO_STATION_INFO= "등록되지 않은 역입니다.\n";
    private static final String NO_LINE_INFO= "등록되지 않은 노선입니다.\n";

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line, Station upward, Station downward) {
        if(checkExistLine(line)){
            System.out.println(String.join(" ", Constant.ERROR_PREFIX, Constant.DUPLICATE_LINE_NAME));
            return;
        } else if(!stationRepository.checkExistStation(upward) || !stationRepository.checkExistStation(downward)){
            System.out.println(String.join(" ", Constant.ERROR_PREFIX, NO_STATION_INFO));
            return;
        }
        lines.add(line);
        System.out.println(String.join(" ", Constant.INFO_PREFIX, Constant.ADD_LINE_SUCCESS));
    }

    public static boolean deleteLineByName(String name) {
        if(!checkExistLine(new Line(name))){
            System.out.println(String.join(" ", Constant.ERROR_PREFIX, NO_LINE_INFO));
        }
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void printLines(){
        for(int i=0; i<lines.size(); i++){
            System.out.println(String.join(" ", Constant.INFO_PREFIX, lines.get(i).getName()));
        }
    }

    private static boolean checkExistLine(Line line){
        return lines.stream().anyMatch(o -> o.getName().equals(line.getName()));
    }
}
