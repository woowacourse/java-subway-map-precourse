package subway.menu;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exception.*;

import java.util.List;
import java.util.Scanner;

public class StationMenu implements Menu {

    private final static String INFO = "[INFO]";

    private final static String STATION_MENU_HELLO = "## 역 관리 화면";

    private final static String STATION_ADD_SELECT = "1";
    private final static String STATION_REMOVE_SELECT = "2";
    private final static String STATION_INQUIRY_SELECT = "3";
    private final static String BACK_SELECT = "B";

    private final static List<String> MENU_SELECTIONS =
            List.of(STATION_ADD_SELECT, STATION_REMOVE_SELECT, STATION_INQUIRY_SELECT, BACK_SELECT);

    private final static String STATION_ADD_EXPLAIN = "역 등록";
    private final static String STATION_REMOVE_EXPLAIN = "역 삭제";
    private final static String STATION_INQUIRY_EXPLAIN = "역 조회";
    private final static String BACK_EXPLAIN = "돌아가기";

    private final static String SPLIT = ". ";

    private final static String CHOOSE = "## 원하는 기능을 선택하세요.";

    private final static String NAME_CHOOSE = "## 등록할 역 이름을 입력하세요.";
    private final static String REMOVE_LINE_CHOOSE = "## 삭제할 역 이름을 입력하세요.";
    private final static String INQUIRY = "## 역 목록";

    private int MIN_NAME_LENGTH;
    private Scanner scanner;

    public StationMenu(Scanner scanner, int minNameLength) {
        this.scanner = scanner;
        this.MIN_NAME_LENGTH = minNameLength;
    }

    @Override
    public void printMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append(STATION_MENU_HELLO).append("\n")
                .append(STATION_ADD_SELECT).append(SPLIT).append(STATION_ADD_EXPLAIN).append("\n")
                .append(STATION_REMOVE_SELECT).append(SPLIT).append(STATION_REMOVE_EXPLAIN).append("\n")
                .append(STATION_INQUIRY_SELECT).append(SPLIT).append(STATION_INQUIRY_EXPLAIN).append("\n")
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
        } else if (select.equals(STATION_ADD_SELECT)) {
            addStation();
        } else if (select.equals(STATION_REMOVE_SELECT)) {
            removeStation();
        } else if (select.equals(STATION_INQUIRY_SELECT)) {
            System.out.println(stationsToString());
            return false;
        } else if (select.equals(BACK_SELECT)) {
            return true;
        }
        return false;
    }

    private void addStation() {

        System.out.println(NAME_CHOOSE);
        String stationName = scanner.next();
        if (checkNameLengthNotValid(stationName)) {
            return;
        }

        if (StationRepository.addStation(new Station(stationName))) {
            System.out.println(INFO + " " + stationName + "을 등록했습니다.\n");
        }
    }

    private void removeStation() {
        System.out.println(REMOVE_LINE_CHOOSE);
        String stationName = scanner.next();

        try {
            if (StationRepository.deleteStationByName(stationName)) {
                System.out.println(INFO + " " + stationName + "을 삭제했습니다.\n");
                return;
            }
            throw new StationNotExistException(stationName);
        } catch (NotExistException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    private String stationsToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(INQUIRY).append("\n");

        List<Station> stations = StationRepository.stations();

        for (Station station : stations) {
            sb.append(INFO).append(" ").append(station.getName()).append("\n");
        }

        return sb.toString();
    }

    private boolean checkNameLengthNotValid(String stationName) {
        try {
            if (stationName.length() >= MIN_NAME_LENGTH) {
                return false;
            }

            throw new StationMinimumNameLengthException(MIN_NAME_LENGTH);
        } catch (MinimumNameLengthException e) {
            System.out.println(e.getMessage() + "\n");
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
            System.out.println(e.getMessage() + "\n");
            return true;
        }
    }
}
