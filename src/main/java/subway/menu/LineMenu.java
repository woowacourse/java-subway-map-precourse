package subway.menu;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exception.*;

import java.util.List;
import java.util.Scanner;

public class LineMenu implements Menu {

    private final static String INFO = "[INFO]";

    private final static String REMOVE_LINE_MESSAGE = "을 삭제했습니다.";

    private final static String LINE_MENU_HELLO = "## 노선 관리 화면";

    private final static String LINE_ADD_SELECT = "1";
    private final static String LINE_REMOVE_SELECT = "2";
    private final static String LINE_INQUIRY_SELECT = "3";
    private final static String BACK_SELECT = "B";

    private final static List<String> MENU_SELECTIONS =
            List.of(LINE_ADD_SELECT, LINE_REMOVE_SELECT, LINE_INQUIRY_SELECT, BACK_SELECT);

    private final static String LINE_ADD_EXPLAIN = "노선 등록";
    private final static String LINE_REMOVE_EXPLAIN = "노선 삭제";
    private final static String LINE_INQUIRY_EXPLAIN = "노선 조회";
    private final static String BACK_EXPLAIN = "돌아가기";

    private final static String SPLIT = ". ";

    private final static String CHOOSE = "## 원하는 기능을 선택하세요.";

    private final static String NAME_CHOOSE = "## 등록할 노선 이름을 입력하세요.";
    private final static String REMOVE_LINE_CHOOSE = "## 삭제할 노선 이름을 입력하세요.";
    private final static String INQUIRY = "## 노선 목록";

    private final static String UPSTREAM_TERMINAL_STATION_CHOOSE = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private final static String DOWNSTREAM_TERMINAL_STATION_CHOOSE = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";

    private Scanner scanner;
    private int MIN_NAME_LENGTH;

    public LineMenu(Scanner scanner, int minNameLength) {
        this.scanner = scanner;
        this.MIN_NAME_LENGTH = minNameLength;
    }


    @Override
    public void printMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append(LINE_MENU_HELLO).append("\n")
                .append(LINE_ADD_SELECT).append(SPLIT).append(LINE_ADD_EXPLAIN).append("\n")
                .append(LINE_REMOVE_SELECT).append(SPLIT).append(LINE_REMOVE_EXPLAIN).append("\n")
                .append(LINE_INQUIRY_SELECT).append(SPLIT).append(LINE_INQUIRY_EXPLAIN).append("\n")
                .append(BACK_SELECT).append(SPLIT).append(BACK_EXPLAIN).append("\n");

        System.out.println(sb.toString());
    }

    public boolean menuSelect() {
        while (true) {
            printMenu();
            System.out.println(CHOOSE);

            String select = scanner.next();

            if (subFunction(select)) {
                return false;
            }
        }
    }

    private boolean subFunction(String select) {
        if (checkSelectNotValid(select)) {
            return false;
        } else if (select.equals(LINE_ADD_SELECT)) {
            addLine();
        } else if (select.equals(LINE_REMOVE_SELECT)) {
            removeLine();
        } else if (select.equals(LINE_INQUIRY_SELECT)) {
            System.out.println(linesToString());
        } else if (select.equals(BACK_SELECT)) {
            return true;
        }
        return false;
    }

    private void addLine() {
        System.out.println(NAME_CHOOSE);
        String lineName = scanner.next();
        if (checkNameLengthNotValid(lineName) || checkLineDuplication(lineName)) {
            return;
        }

        Line line = makeLine(lineName);

        if (line == null) {
            return;
        }

        LineRepository.addLine(line);
    }

    private Line makeLine(String lineName) {
        String upstreamTerminal = getUpstreamTerminal();
        String downstreamTerminal = getDownstreamTerminal();

        try {
            if (upstreamTerminal == null || downstreamTerminal == null) {
                throw new TerminalStationNotExistException();
            }
            Line line = initLine(lineName, upstreamTerminal, downstreamTerminal);
            return line;
        } catch (TerminalStationException e) {
            System.out.println(e.getMessage() + "\n");
            return null;
        }
    }

    private Line initLine(String lineName, String upstreamTerminal, String downstreamTerminal)
            throws SameTerminalStationException {

        if (upstreamTerminal.equals(downstreamTerminal)) {
            throw new SameTerminalStationException();
        }

        Line line = new Line(lineName);
        line.addStation(upstreamTerminal);
        line.addStation(downstreamTerminal);
        return line;
    }

    private String getUpstreamTerminal() {
        System.out.println(UPSTREAM_TERMINAL_STATION_CHOOSE);
        String stationName = scanner.next();

        if (StationRepository.contains(stationName)) {
            return stationName;
        }
        return null;
    }

    private String getDownstreamTerminal() {
        System.out.println(DOWNSTREAM_TERMINAL_STATION_CHOOSE);
        String stationName = scanner.next();

        if (StationRepository.contains(stationName)) {
            return stationName;
        }
        return null;
    }

    private boolean checkLineDuplication(String lineName) {
        try {
            if (LineRepository.contains(lineName)) {
                throw new LineDuplicationException(lineName);
            }

            return false;
        } catch (DuplicationException e) {
            System.out.println(e.getMessage() + "\n");
            return true;
        }
    }

    private void removeLine() {
        System.out.println(REMOVE_LINE_CHOOSE);
        String lineName = scanner.next();

        try {
            if (LineRepository.deleteLineByName(lineName)) {
                System.out.println(INFO + " " + lineName + REMOVE_LINE_MESSAGE + "\n");
                return;
            }

            throw new LineNotExistException(lineName);
        } catch (NotExistException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    private String linesToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(INQUIRY).append("\n");

        List<Line> lines = LineRepository.lines();

        for (Line line : lines) {
            sb.append(INFO).append(" ").append(line.getName()).append("\n");
        }

        return sb.toString();
    }

    private boolean checkNameLengthNotValid(String lineName) {
        try {
            if (lineName.length() > MIN_NAME_LENGTH) {
                return false;
            }

            throw new StationMinimumNameLengthException(MIN_NAME_LENGTH);
        } catch (MinimumNameLengthException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    private boolean checkSelectNotValid(String select) {
        try {
            if (MENU_SELECTIONS.contains(select)) {
                return false;
            }

            throw new SelectNotValidException();
        } catch (SelectNotValidException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }
}
