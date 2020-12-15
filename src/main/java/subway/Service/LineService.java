package subway.Service;

import subway.Exception.LineException.*;
import subway.Exception.StationException.*;
import subway.Manager.LineManager;
import subway.domain.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LineService {
    private static final int LINE_NAME = 0;
    private static final int UP_TERMINAL_STATION = 1;
    private static final int DOWN_TERMINAL_STATION = 2;

    private LineRepository lineRepository = new LineRepository();

    public boolean createLine(List<String> insertLineInfo) {
        try {
            checkBeforeCreateLine(insertLineInfo);
            addLineAndStation(insertLineInfo);
            return true;
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            LineManager.execute();
            return false;
        }
    }

    public void addLineAndStation(List<String> insertLineInfo) {
        Line newLine = new Line(insertLineInfo.get(LINE_NAME));
        Station upTerminalStation = StationRepository.findByName(insertLineInfo.get(UP_TERMINAL_STATION));
        Station downTerminalStation = StationRepository.findByName(insertLineInfo.get(DOWN_TERMINAL_STATION));
        List<Station> sections = new ArrayList<>(Arrays.asList(upTerminalStation, downTerminalStation));

        LineRepository.addLine(newLine);
        LineStationRepository.addLineStation(new LineStation(newLine, sections));
    }

    public boolean deleteLine(String lineName) {
        try {
            if (!LineRepository.deleteLineByName(lineName)) {
                throw new CanNotFindLineException();
            }
            LineStationRepository.deleteLineOnSubway(lineName);
            return true;
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            LineManager.execute();
            return false;
        }
    }

    public void checkBeforeCreateLine(List<String> insertLineInfo) {
        if (LineRepository.isValidLineNameLength(insertLineInfo.get(LINE_NAME))) {
            throw new ShorterThanMinLineNameException();
        }
        if (LineRepository.contains(insertLineInfo.get(LINE_NAME))) {
            throw new DuplicateLineNameException();
        }
        if (!StationRepository.contains(insertLineInfo.get(UP_TERMINAL_STATION))) {
            throw new CanNotFindStationException();
        }
        if (!StationRepository.contains(insertLineInfo.get(DOWN_TERMINAL_STATION))) {
            throw new CanNotFindStationException();
        }
    }

    public String lineLookup() {
        return lineRepository.toString();
    }
}
