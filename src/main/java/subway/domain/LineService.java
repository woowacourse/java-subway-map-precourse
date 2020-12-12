package subway.domain;

import java.util.Arrays;
import java.util.Scanner;

public class LineService {
    public void addLine(Scanner scanner) {
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
        SectionRepository.addSection(lineName, upstreamLastStation, 0);
        SectionRepository.addSection(lineName, downstreamLastStation, 1);
        System.out.println("[INFO] 지하철 노선이 등록되었습니다.\n");
    }

    private boolean validateLineName(String lineName) {
        if(LineRepository.containLine(lineName)) {
            System.out.println("[ERROR] 이미 같은 이름의 노선이 있습니다.");
            return false;
        }
        if(lineName.length() < 2) {
            System.out.println("[ERROR] 노선 이름은 2자 이상이어야 합니다.");
            return false;
        }
        return true;
    }

    public void deleteLine(Scanner scanner) {
        String lineName = scanner.next();
        LineRepository.deleteLineByName(lineName);
    }

    public void getLine() {
        // TODO [INFO] 붙여서 출력하기
        System.out.println(Arrays.toString(LineRepository.lines().toArray()));
    }
}
