package subway.domain;

import subway.view.OutputView;

import java.util.*;

public class LineRepository {
    private static final String DUPLICATE_ERROR="중복된 이름입니다.";
    private static final String NOT_EXIST_LINE_ERROR="없는 노선입니다.";
    private static final String CANNOT_DELETE_STATION="노선에 포함된 역이 두개 이하일 때는 역을 제거할 수 없습니다.";
    private static final Integer MIN_STATION_SIZE=2;
    private static final String LINE_SPLIT_STATIONS="---";
    private static final List<Line> lines = new LinkedList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static boolean addLine(Line line) {
        if(isDuplicate(line.getName())){
            OutputView.printError(DUPLICATE_ERROR);
            return false;
        }
        lines.add(line);
        return true;
    }

    public static Line findByName(String name){
        if(lines.stream().noneMatch(line -> line.getName().equals(name))){
            OutputView.printError(NOT_EXIST_LINE_ERROR);
            return null;
        }
        return lines.stream()
                .filter(line -> line.getName().equals(name)).findFirst().get();
    }

    public static boolean deleteStationByName(Line line,String name){
        if(line==null){
            return false;
        }
        if(line.getStations().size()<=MIN_STATION_SIZE){
            OutputView.printError(CANNOT_DELETE_STATION);
            return false;
        }
        return line.getStations().removeIf(station -> station.getName().equals(name));
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    private static boolean isDuplicate(String name){
        return lines.stream().anyMatch(line -> line.getName().equals(name));
    }

    public static void printAllLine(){
        lines.forEach(line -> OutputView.printInfo(line.getName()));
    }

    public static void printAllLinesAndStation(){
        lines.forEach(line -> {
            System.out.println();
            OutputView.printInfo(line.getName());
            OutputView.printInfo(LINE_SPLIT_STATIONS);
            line.getStations().forEach(station -> {
                OutputView.printInfo(station.getName());
            });
        });
        System.out.println();
    }
}
