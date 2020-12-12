package subway.domain;

import validator.ExceptionMessage;

import java.util.*;

public class LineRepository {
    private static final String NEW_LINE = "\n";
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

    public static boolean isLineExist(String name) {
        for (Line line : lines()) {
            String lineName = line.getName();
            if (lineName.equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static void isValidLineName(String name) {
        if (name.length() < 2) {
            throw new IllegalArgumentException(ExceptionMessage.LINE_NAME_OVER_TWO);
        }
        if (isLineExist(name)) {
            throw new IllegalArgumentException(ExceptionMessage.LINE_NAME_EXISTS);
        }
    }

    public static void isPossibleTerminalStation(String name) {
        if (!StationRepository.isStationExist(name))
            throw new IllegalArgumentException(ExceptionMessage.NOT_EXIST_STATION_FOR_LINE);
    }


    public static void createLineAndStation(String lineName, String upTerminal, String downTerminal) { // 노선이름, 상행, 하행 종점 등록
        Station upTerminalStation = StationRepository.getStation(upTerminal);
        Station downTerminalStation = StationRepository.getStation(downTerminal);
        Line newLine = new Line(lineName);
        List<Station> sections = Arrays.asList(upTerminalStation, downTerminalStation);
        SubwayRepository.addStationOnTheLine(newLine, sections);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Line line : lines()) {
            sb.append("[INFO] " + line + NEW_LINE);
        }
        return sb.toString();
    }
}
