package Controller;

import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.Scanner;

public class StationController {
    public static void runStationController(Scanner scanner) {
        System.out.println("## 역 관리 화면\n" +
                "1. 역 등록\n" +
                "2. 역 삭제\n" +
                "3. 역 조회\n" +
                "B. 돌아가기\n" +
                "\n" +
                "## 원하는 기능을 선택하세요.");

        String userInput = scanner.nextLine();

        boolean inputCheck = false;
        if (userInput.equals("1")) {
            inputCheck = true;
            addStation(scanner);
        }
        if (userInput.equals("2")) {
            inputCheck = true;
        }
        if (userInput.equals("3")) {
            inputCheck = true;
        }
        if (userInput.equals("B")) {
            inputCheck = true;
        }
        if (inputCheck == false) {
            System.out.println("[ERROR] 올바른 번호를 입력해주세요");
            SubwayController.run(scanner);
        }
    }

    public static void addStation(Scanner scanner) {
        System.out.println("## 등록할 역 이름을 입력하세요");
        String name = scanner.nextLine();
        Station station = new Station(name);
        StationRepository.addStation(station);
        System.out.println("[INFO] 지하철 역이 등록되었습니다.");
    }
}
