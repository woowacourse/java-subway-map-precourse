package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.StationRepository;

public class Board {

    private final static String INFO = "[INFO]";

    private final static String STATION_REMOVED_MESSAGE = INFO + " 지하철 역을 삭제했습니다.";
    private final static String STATION_ADD_MESSAGE = INFO + " 지하철 역을 추가했습니다.";

    private final static String LINE_ADD_MESSAGE = INFO + " 노선을 추가했습니다.";
    private final static String LINE_REMOVED_MESSAGE = INFO + " 노선을 삭제했습니다.";

    private final static String SECTION_ADD_MESSAGE = INFO + " 구간을 등록했습니다.";

    private final static String ERROR = "[ERROR]";

    private final static String MINIMUM_LENGTH_ERROR = ERROR + " 이름이 너무 짧습니다.";

    private final static String DUPLICATED_STATION_ERROR = ERROR + " 같은 이름의 역이 있습니다.";
    private final static String NOT_EXIST_STATION_ERROR = ERROR + " 지하철 역이 존재하지 않습니다.";

    private final static String NOT_EXIST_LINE_ERROR = ERROR + " 존재하지 않는 노선입니다.";

    private final static String SAME_STATION_IN_SECTION_ERROR = ERROR + " 이미 같은 역이 있습니다.";
    private final static String TERMINAL_DOES_NOT_EXIST_ERROR = ERROR + " 상행선 또는 하행선이 없는 역입니다.";
    private final static String SECTION_MINIMUM_SIZE_ERROR = ERROR + " 구간을 더 이상 삭제할 수 없습니다.";
    private final static String SAME_TERMINAL_ERROR = ERROR + " 상행선과 하행선이 같은 역입니다.";
    private final static String SECTION_INDEX_ERROR = ERROR + " 순서의 범위가 맞지 않습니다.";

    private final static int MIN_NAME_LENGTH = 2;


    private final static Subway subway = new Subway();

    public Board() {

    }

    private void setInitStation() {

    }

    public boolean addStation(String name) {

        if (subway.containsStation(name)) {
            System.out.println(DUPLICATED_STATION_ERROR);
            return false;
        } else if (name.length() < MIN_NAME_LENGTH) {
            System.out.println(MINIMUM_LENGTH_ERROR);
            return false;
        }
        subway.addStation(name);
        System.out.println(STATION_ADD_MESSAGE);
        return true;
    }

    public void removeStationByName(String name) {
        if (subway.removeStation(name)) {
            System.out.println(STATION_REMOVED_MESSAGE);
            return;
        }
        System.out.println(NOT_EXIST_STATION_ERROR);
    }

    public boolean addLine(String name, String upStreamTerminal, String downStreamTerminal) {

        if (!subway.containsLine(upStreamTerminal) || !subway.containsLine(downStreamTerminal)) {
            System.out.println(TERMINAL_DOES_NOT_EXIST_ERROR);
            return false;
        } else if (upStreamTerminal.equals(downStreamTerminal)) {
            System.out.println(SAME_TERMINAL_ERROR);
            return false;
        }

        subway.addLine(name, upStreamTerminal, downStreamTerminal);
        System.out.println(LINE_ADD_MESSAGE);
        return true;
    }

    public void removeLineByName(String name) {
        if (subway.removeLineByName(name)) {
            System.out.println(LINE_REMOVED_MESSAGE);
            return;
        }
        System.out.println(NOT_EXIST_LINE_ERROR);
    }

    public boolean addSection(String lineName, String stationName, int index) {
        if (!checkLineExist(lineName) || !checkStationExist(stationName)) {
            return false;
        }

        Line line = LineRepository.findLineByName(lineName);
        if (!checkValidSectionIndex(line, index) || checkStationDuplicate(line, stationName)) {
            return false;
        }
        line.addStation(index, stationName);
        System.out.println(SECTION_ADD_MESSAGE);
        return true;
    }

    public boolean removeSection(String lineName, String stationName) {
        if (!checkLineExist(lineName) || !checkStationExist(stationName)) {
            return false;
        }

        Line line = LineRepository.findLineByName(lineName);
        if (checkSectionRemovable(line)) {
            return false;
        }
        line.removeStationByName(stationName);
        return true;
    }

    private boolean checkLineExist(String name) {
        if (!LineRepository.contains(name)) {
            System.out.println(NOT_EXIST_LINE_ERROR);
            return false;
        }
        return true;
    }

    private boolean checkStationExist(String name) {
        if (!StationRepository.contains(name)) {
            System.out.println(NOT_EXIST_STATION_ERROR);
            return false;
        }
        return true;
    }

    private boolean checkSectionRemovable(Line line) {
        if (!line.canRemove()) {
            System.out.println(SECTION_MINIMUM_SIZE_ERROR);
            return false;
        }
        return true;
    }

    private boolean checkStationDuplicate(Line line, String stationName) {
        if (line.contains(stationName)) {
            System.out.println(SAME_STATION_IN_SECTION_ERROR);
            return false;
        }
        return true;
    }

    private boolean checkValidSectionIndex(Line line, int index) {
        if (!line.isValidSection(index)) {
           System.out.println(SECTION_INDEX_ERROR);
           return false;
        }
        return true;
    }

}
