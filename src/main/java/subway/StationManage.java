package subway;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.Scanner;

public class StationManage {
    public static final int MENU_INT_CREATE_STATION = 1;
    public static final int MENU_INT_DELETE_STATION = 2;
    private Scanner scanner;

    public StationManage (Scanner scanner) {
        this.scanner = scanner;
    }

    public void manageStation() {
        printStationMenu();
        int stationMenuNumber = parseMenuNumber();
        selectMenu(stationMenuNumber);
    }

    public void printStationMenu() {
        System.out.println("1. 역 등록");
        System.out.println("2. 역 삭제");
        System.out.println("3. 역 조회");
        System.out.println("B. 돌아가기");
        System.out.println("");
        System.out.println("## 원하는 기능을 선택하세요.");
    }

    public int parseMenuNumber() {
        String userInput = scanner.nextLine();
        try {
            return Integer.parseInt(userInput);
        } catch (IllegalArgumentException e) {
            if (userInput.equals("B")) {
                return 0;
            }
            System.out.println("[ERROR] 잘못된 입력입니다.");
            System.out.println("");
            printStationMenu();
            return parseMenuNumber();
        }
    }

    public void selectMenu(int menuNumber) {
        if (menuNumber == MENU_INT_CREATE_STATION) {
            String station = askStationName();
            StationRepository.addStation(new Station(station));
        } else if (menuNumber == MENU_INT_DELETE_STATION) {
            String station = askStationName();
            StationRepository.deleteStation(station);
            
        }
//        else if (stationMenuNumber == 3) {
//
//        } else if (stationMenuNumber == 0) {
//
//        }
    }
    public String askStationName() {
        String userInput = scanner.nextLine();
        //Todo validate userInput
        return userInput;
    }






}
