package subway.domain;

import subway.Constant;

import java.util.*;

public class LineRepository {
    public static final List<Line> lines = new ArrayList<>();
    static StationRepository stationRepository = new StationRepository();
    static SectionRepository sectionRepository = new SectionRepository();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(String lineName, Station upward, Station downward) {
        if (checkExistLine(lineName)) {
            System.err.println(String.join(" ", Constant.ERROR_PREFIX, Constant.DUPLICATE_LINE_NAME));
            return;
        } else if (!stationRepository.checkExistStation(upward) || !stationRepository.checkExistStation(downward)) {
            System.err.println(String.join(" ", Constant.ERROR_PREFIX, Constant.NO_STATION_INFO));
            return;
        } else if(upward.equals(downward)) {
            System.err.println(String.join(" ", Constant.ERROR_PREFIX, "상행과 하행 종점은 같을 수 없습니다."));
            return;
        }
        Line line = new Line(lineName);
        line.stations.add(upward);
        line.stations.add(downward);
        lines.add(line);
        printMap();
        System.out.println(String.join(" ", Constant.INFO_PREFIX, Constant.ADD_LINE_SUCCESS));
    }

    public static boolean deleteLineByName(String name) {
        if (!checkExistLine(name)) {
            System.err.println(String.join(" ", Constant.ERROR_PREFIX, Constant.NO_LINE_INFO));
        }
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void printLines() {
        for (int i = 0; i < lines.size(); i++) {
            System.out.println(String.join(" ", Constant.INFO_PREFIX, lines.get(i).getName()));
        }
    }

    public static void printMap(){
        for(int i=0; i<lines.size(); i++){
            System.out.print(String.join(" ", Constant.INFO_PREFIX, lines.get(i).getName()));
            for(int j=0; j<lines.get(i).stations.size(); j++){
                System.out.print(lines.get(i).stations.get(j).getName() + " " );
            }
        }
    }

    public static boolean checkExistLine(String lineName) {
        return lines.stream().anyMatch(o -> o.getName().equals(lineName));
    }
}
