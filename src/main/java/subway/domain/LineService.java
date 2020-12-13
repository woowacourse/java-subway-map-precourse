package subway.domain;

import java.util.Scanner;

public class LineService {
    private static final int LINE_NAME_SIZE_CONDITION = 2;
    private static final int START_LINE_ORDER = 0;
    private static final int END_LINE_ORDER = 1;
    public void addLine(Scanner scanner) {
        SectionService sectionService = new SectionService();
        String lineName;
        do {
            System.out.println("## 등록할 노선 이름을 입력하세요.");
            lineName = scanner.next();
        } while (!validateLineName(lineName));
        System.out.println("## 등록할 노선의 상행 종점역 이름을 입력하세요.");
        String upstreamLastStation = scanner.next();
        System.out.println();
        System.out.println("## 등록할 노선의 하행 종점역 이름을 입력하세요.");
        String downstreamLastStation = scanner.next();
        System.out.println();
        LineRepository.addLine(new Line(lineName));
        sectionService.addLineStartEndSection(new Section(lineName, upstreamLastStation, START_LINE_ORDER));
        sectionService.addLineStartEndSection(new Section(lineName, downstreamLastStation, END_LINE_ORDER));
        System.out.println("[INFO] 지하철 노선이 등록되었습니다.\n");
    }

    private boolean validateLineName(String lineName) {
        if(LineRepository.containLine(lineName)) {
            System.out.println("[ERROR] 이미 같은 이름의 노선이 있습니다.");
            return false;
        }
        if(lineName.length() < LINE_NAME_SIZE_CONDITION) {
            System.out.println("[ERROR] 노선 이름은 2자 이상이어야 합니다.");
            return false;
        }
        return true;
    }

    public void deleteLine(Scanner scanner) {
        System.out.println("## 삭제할 노선 이름을 입력하세요.");
        String lineName = scanner.next();
        if(!LineRepository.deleteLineByName(lineName)) {
            System.out.println("[ERROR] 해당 이름으로 등록된 노선이 없습니다.");
            return;
        }
        System.out.println("[INFO] 지하철 노선이 삭제되었습니다.");
    }

    public void getLine() {
        System.out.println("## 노선 목록");
        LineRepository.lines().forEach(line -> System.out.println("[INFO] " + line.getName()));
    }
}
