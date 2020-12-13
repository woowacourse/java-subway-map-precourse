package subway.domain;

import subway.tool.InputTool;
import subway.view.OutputView;

import java.util.*;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static boolean addLine(Line line) {
        lines.add(line);
        return true;
    }

    public static boolean isPossibleLine(String lineName, String startName, String endName) {
        if(!InputTool.isValidName(lineName)){
            OutputView.printError("노선 이름은 2글자 이상이어야 합니다.");
            return false;
        }
        if(isExistLine(lineName)){
            OutputView.printError("노선 이름은 중복될 수 없습니다.");
            return false;
        }
        if(StationRepository.isExistStation(startName)==false || StationRepository.isExistStation(endName) == false){
            OutputView.printError("종점역이 존재하지 않습니다.");
            return false;
        }
        Line newLine = new Line(lineName);
        addLine(newLine);
        OutputView.printInfo("노선이 등록되었습니다.");
        return true;
    }


    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static List<Line> getLines() {
        return lines;
    }

    public static boolean lookUpLine() {
        Iterator<Line> itr = lines.iterator();
        while (itr.hasNext()) {
            OutputView.printInfo(itr.next().getName());
        }
        return true;
    }

    public static boolean lookUpStationOfLine() {
        Iterator<Line> itr = lines.iterator();
        while (itr.hasNext()) {
            Line line = (Line)itr.next();
            List<Station> stationList = line.getStationOfLine();
            OutputView.printInfo(line.getName());
            OutputView.printInfo("---");
            for (Station station : stationList)
                OutputView.printInfo(station.getName());
            System.out.println();

        }
        return true;
    }

    public static boolean isExistLine(String name) {
        Iterator<Line> itr = lines.iterator();
        while (itr.hasNext()) {
            if (itr.next().isEqual(name) == true) return true;
        }
        return false;
    }
}
