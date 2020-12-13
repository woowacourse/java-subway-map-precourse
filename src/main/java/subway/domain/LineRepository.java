package subway.domain;

import subway.tool.InputTool;
import subway.view.OutputView;

import java.util.*;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static boolean addLine(Line line) {
        lines.add(line);
        return true;
    }
    public static void insertStationInLine(Line line, String name){
        Station station = new Station(name);
        line.insertStationInLine(station);
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
        insertStationInLine(newLine, startName);
        insertStationInLine(newLine, endName);
        addLine(newLine);
        OutputView.printInfo("노선이 등록되었습니다.");
        return true;
    }


    public static boolean deleteLineByName(String name) {
        OutputView.printInfo("노선이 삭제되었습니다.");
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static boolean isContainStationInTargetLine(String lineName, String stationName) {
        Iterator<Line> itr = lines.iterator();
        while (itr.hasNext()) {
            Line tempLine = (Line) itr.next();
            if(tempLine.getName().compareTo(lineName) ==0){
                if(tempLine.isContainStation(stationName)) return true;
            }
        }
        return false;
    }

    public static int getTargetLineSize(String lineName) {
        Iterator<Line> itr = lines.iterator();
        while (itr.hasNext()) {
            Line tempLine = (Line) itr.next();
            if(tempLine.getName().compareTo(lineName) ==0) return tempLine.getStationOfLine().size();
        }
        return -1;
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
    //해당 이름의 역이 모든 노선 중 하나라도 포함되어 있는지
    public static boolean isContainStationInLines(String name) {
        Iterator<Line> itr = lines.iterator();
        while (itr.hasNext()) {
            Line line = (Line)itr.next();
            List<Station> stationList = line.getStationOfLine();
            for (Station station : stationList)
                if(station.isEqual(name) ==true) return true;
        }
        return false;
    }
    public static boolean isExistLine(String name) {
        Iterator<Line> itr = lines.iterator();
        while (itr.hasNext()) {
            if (itr.next().isEqual(name) == true) return true;
        }
        return false;
    }

    public static void addStationInLine(String lineName, String stationName, String order) {
         
    }

}
