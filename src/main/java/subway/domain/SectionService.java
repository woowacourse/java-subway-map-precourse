package subway.domain;

import java.nio.charset.CharacterCodingException;
import java.time.temporal.ChronoField;
import java.util.Scanner;

public class SectionService {
    public void addLineStartEndSection(Section section) {
        SectionRepository.addSection(section.getLineName(), section.getStationName(), section.getOrder());
    }

    public void addSection(Scanner scanner) {
        String lineName;
        String stationName;
        String order;
        do {
            System.out.println("## 노선을 입력하세요.");
            lineName = scanner.next();
        } while (!validateLineName(lineName));
        do {
            System.out.println("## 역이름을 입력하세요.");
            stationName = scanner.next();
        } while (!validateStationName(stationName));
        System.out.println();
        do {
            System.out.println("## 순서를 입력하세요.");
            order = scanner.next();
        } while (!validateOrder(lineName, order));
        System.out.println();
        SectionRepository.addSection(lineName, stationName, Integer.parseInt(order));
        System.out.println("[INFO] 구간이 등록되었습니다.\n");
    }

    private boolean validateLineName(String lineName) {
        if(!LineRepository.containLine(lineName)) {
            System.out.println("[ERROR] 등록되어있지 않은 노선입니다.\n");
            return false;
        }
        return true;
    }

    private boolean validateStationName(String stationName) {
        if(!StationRepository.containStation(stationName)) {
            System.out.println("[ERROR] 등록되어있지 않은 역입니다.\n");
            return false;
        }
        return true;
    }

    private boolean validateOrder(String lineName, String order) {
        for (char c : order.toCharArray()) {
            if(!Character.isDigit(c)) {
                System.out.println("[ERROR] 입력한 순서가 숫자가 아닙니다.\n");
                return false;
            }
        }
        int orderNum = Integer.parseInt(order) - 1;
        if(orderNum > SectionRepository.getLineSectionSize(lineName)) {
            System.out.println("[ERROR] 해당 노선이 가진 역의 개수를 초과합니다. 알맞은 순서를 입력해주세요.\n");
            return false;
        }
        return true;
    }

    public void deleteSection(Scanner scanner) {
    }
}
