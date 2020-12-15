package subway;

import subway.domain.LineRepository;
import subway.domain.StationRepository;

import java.util.Scanner;

public class Subway {
    private static final String MAIN_MENU = "## 메인 화면\n1. 역 관리\n2. 노선 관리\n3. 구간 관리\n" +
                                                    "4. 지하철 노선도 출력\nQ. 종료\n";

    private Scanner scanner;

    public Subway(Scanner scanner) {
        this.scanner = scanner;
        StationRepository.init();
        LineRepository.init();
    }

    public String selectState() {
        System.out.println(MAIN_MENU);
        String menu = scanner.next();
        return menu;
    }

}