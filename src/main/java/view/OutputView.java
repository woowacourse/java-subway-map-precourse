package view;

import subway.domain.Line;
import subway.domain.LineRepository;

public class OutputView {

    public static void initialTest() {
        for (Line line : LineRepository.lines()) {
            System.out.println("-------------------------------------------");
            System.out.println("노선 이름: " + line.getName());
            System.out.println("상행 종점: " + line.getNorthboundTerminal());
            System.out.println("하행 종점: " + line.getSouthboundTerminal());
            System.out.print("역 리스트: " + String.join(" -> ", line.getContainedStation()));
            System.out.println();
        }
    }
}
