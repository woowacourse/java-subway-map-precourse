package subway.Service;

import subway.Manager.LineManager;
import subway.domain.*;
import validator.ExceptionMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LineService {
    private static final String LINE_INSERT = "1";
    private static final String LINE_DELETE = "2";
    private static final int MIN_LINE_NAME_LENGTH = 2;
    private static final int LINE_NAME = 0;
    private static final int UP_TERMINAL_STATION = 1;
    private static final int DOWN_TERMINAL_STATION = 2;

    private LineRepository lineRepository = new LineRepository();

    public void createLine(List<String> insertLineInfo) {
        try {
            String lineName = insertLineInfo.get(LINE_NAME);
            String upTerminal = insertLineInfo.get(UP_TERMINAL_STATION);
            String downTerminal = insertLineInfo.get(DOWN_TERMINAL_STATION);
            checkBeforeCreateLine(lineName, upTerminal, downTerminal);
            addLineAndStation(lineName, upTerminal, downTerminal);
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            LineManager.execute(LINE_INSERT);
        }
    }

    public void addLineAndStation(String lineName, String upTerminal, String downTerminal) { // 노선이름, 상행, 하행 종점 등록
        Station upTerminalStation = StationRepository.findByName(upTerminal);
        Station downTerminalStation = StationRepository.findByName(downTerminal);
        Line newLine = new Line(lineName);
        List<Station> sections = new ArrayList<>(Arrays.asList(upTerminalStation, downTerminalStation));
        LineStationRepository.addLineStation(new LineStation(newLine, sections));
    }

    public void deleteLine(String lineName) {
        try {
            if(!LineRepository.deleteLineByName(lineName)) {
                throw new IllegalArgumentException(ExceptionMessage.NOT_EXIST_LINE);
            }
            LineStationRepository.deleteLineOnSubway(lineName);
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            LineManager.execute(LINE_DELETE);
        }
    }

    public void checkBeforeCreateLine(String lineName, String upTerminal, String downTerminal) {
        if (lineName.length() < MIN_LINE_NAME_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.LINE_NAME_OVER_TWO);
        }
        if (LineRepository.contains(lineName)) {
            throw new IllegalArgumentException(ExceptionMessage.LINE_NAME_EXISTS);
        }
        if (!StationRepository.contains(upTerminal)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_EXIST_STATION);
        }
        if (!StationRepository.contains(downTerminal)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_EXIST_STATION);
        }
    }

    public String lineLookup() {
        return lineRepository.toString();
    }
}
