package subway;

public class Board {

    private final static String INFO = "[INFO]";
    private final static String STATION_REMOVED_MESSAGE = INFO + " 지하철 역을 삭제했습니다.";
    private final static String STATION_ADD_MESSAGE = INFO + " 지하철 역을 추가했습니다.";
    private final static String LINE_ADD_MESSAGE = INFO + " 노선을 추가했습니다.";
    private final static String LINE_REMOVED_MESSAGE = INFO + " 노선을 삭제했습니다.";

    private final static String ERROR = "[ERROR]";
    private final static String DUPLICATED_SUBWAY_ERROR = ERROR + " 같은 이름의 역이 있습니다.";
    private final static String TERMINAL_DOES_NOT_EXIST_ERROR = ERROR + " 상행선 또는 하행선이 없는 역입니다.";
    private final static String SAME_TERMINAL_ERROR = ERROR + " 상행선과 하행선이 같은 역입니다.";
    private final static String NOT_EXIST_STATION_ERROR = ERROR + " 지하철 역이 존재하지 않습니다.";
    private final static String NOT_EXIST_LINE_ERROR = ERROR + " 존재하지 않는 노선입니다.";
    private final static String MINIMUM_LENGTH_ERROR = ERROR + " 이름이 너무 짧습니다.";
    private final static String SAME_STATION_IN_SECTION_ERROR = ERROR + " 이미 같은 역이 있습니다.";


    private final static int MIN_NAME_LENGTH = 2;


    private final static Subway subway = new Subway();

    public Board() {

    }

    public boolean addStation(String name) {

        if (subway.containsStation(name)) {
            System.out.println(DUPLICATED_SUBWAY_ERROR);
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
        if (subway.containsStation(name)) {
            System.out.println(NOT_EXIST_STATION_ERROR);
        }
        subway.removeStation(name);
        System.out.println(STATION_REMOVED_MESSAGE);
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

        if (subway.containsLine(name)) {
            System.out.println(NOT_EXIST_LINE_ERROR);
            return;
        }
        subway.removeLineByName(name);
        System.out.println(LINE_REMOVED_MESSAGE);
    }

}
