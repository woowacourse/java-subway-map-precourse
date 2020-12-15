package subway.menu;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exception.*;

import java.util.List;
import java.util.Scanner;

public class SectionMenu implements Menu {


    private final static String INFO = "[INFO]";

    private final static String SECTION_ADD_MESSAGE = INFO + " 구간을 등록했습니다.";

    private final static String SECTION_MENU_HELLO = "## 구간 관리 화면";

    private final static String SECTION_ADD_SELECT = "1";
    private final static String SECTION_REMOVE_SELECT = "2";
    private final static String BACK_SELECT = "B";

    private final static List<String> MENU_SELECTIONS =
            List.of(SECTION_ADD_SELECT, SECTION_REMOVE_SELECT, BACK_SELECT);

    private final static String SECTION_ADD_EXPLAIN = "구간 등록";
    private final static String SECTION_REMOVE_EXPLAIN = "구간 삭제";
    private final static String BACK_EXPLAIN = "돌아가기";

    private final static String SPLIT = ". ";

    private final static String CHOOSE = "## 원하는 기능을 선택하세요.";
    private final static String LINE_CHOOSE = "## 노선을 입력하세요.";
    private final static String STATION_CHOOSE = "## 역이름을 입력하세요.";
    private final static String REMOVE_SECTION_CHOOSE = "## 삭제할 구간의 노선을 입력하세요.";
    private final static String REMOVE_STATION_CHOOSE = "## 삭제할 구간의 역을 입력하세요.";
    private final static String SEQUENCE_CHOOSE = "## 순서를 입력하세요.";

    private Scanner scanner;

    public SectionMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void printMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append(SECTION_MENU_HELLO).append("\n")
                .append(SECTION_ADD_SELECT).append(SPLIT).append(SECTION_ADD_EXPLAIN).append("\n")
                .append(SECTION_REMOVE_SELECT).append(SPLIT).append(SECTION_REMOVE_EXPLAIN).append("\n")
                .append(BACK_SELECT).append(SPLIT).append(BACK_EXPLAIN).append("\n");

        System.out.println(sb.toString());
    }

    public boolean menuSelect() {
        while (true) {
            printMenu();
            System.out.println(CHOOSE);
            String select = scanner.next();
            System.out.println();

            if (subFunction(select)) {
                return false;
            }
        }
    }

    private boolean subFunction(String select) {
        if (checkSelectNotValid(select)) {
            return false;
        } else if (select.equals(SECTION_ADD_SELECT)) {
            addSection();
        } else if (select.equals(SECTION_REMOVE_SELECT)) {
            removeSection();
        } else if (select.equals(BACK_SELECT)) {
            return true;
        }
        return false;
    }

    private void addSection() {
        try {
            Line line = findLine();
            Station station = findStation();

            if (line.addStation(setStationSequence(), station)) {
                System.out.println(SECTION_ADD_MESSAGE + "\n");
            }
        } catch (NotExistException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    private Line findLine() throws NotExistException {
        System.out.println(LINE_CHOOSE);
        String lineName = scanner.next();

        if (!LineRepository.contains(lineName)) {
            throw new LineNotExistException(lineName);
        }

        return LineRepository.findLineByName(lineName);
    }

    private Station findStation() throws NotExistException {
        System.out.println(STATION_CHOOSE);
        String stationName = scanner.next();

        if (!StationRepository.contains(stationName)) {
            throw new StationNotExistException(stationName);
        }

        return StationRepository.findStationByName(stationName);
    }

    private void removeSection() {
        try {
            Line line = getLine();
            Station station = getStation();

            if (line.removeStationByName(station.getName())) {
                System.out.println(INFO + station.getName() + "을 구간에서 삭제했습니다.\n");
            }
        } catch (NotExistException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    private Line getLine() throws NotExistException {
        System.out.println(REMOVE_SECTION_CHOOSE);
        String lineName = scanner.next();

        if (!LineRepository.contains(lineName)) {
            throw new LineNotExistException(lineName);
        }

        return LineRepository.findLineByName(lineName);
    }

    private Station getStation() throws NotExistException {
        System.out.println(REMOVE_STATION_CHOOSE);
        String stationName = scanner.next();

        if (!StationRepository.contains(stationName)) {
            throw new StationNotExistException(stationName);
        }

        return StationRepository.findStationByName(stationName);
    }

    private int setStationSequence() {
        System.out.println(SEQUENCE_CHOOSE);
        String seq = scanner.next();

        try {
            if (!seq.chars().allMatch(Character::isDigit)) {
                throw new SectionNumberFormatException();
            }
            return Integer.parseInt(seq);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }


    private boolean checkSelectNotValid(String select) {
        try {
            if (MENU_SELECTIONS.contains(select)) {
                return false;
            }

            throw new SelectNotValidException();
        } catch (SelectNotValidException e) {
            System.out.println(e.getMessage() + "\n");
            return true;
        }
    }
}
