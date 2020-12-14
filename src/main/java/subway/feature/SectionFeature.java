package subway.feature;

import subway.domain.*;
import subway.menu.SectionMenu;
import subway.menu.StationMenu;
import subway.view.SectionInputView;

import java.util.LinkedList;
import java.util.Scanner;

public class SectionFeature {
    public static void registerSection(Scanner scanner) {
        try {
            String line = SectionInputView.lineForRegister(scanner);
            String station = SectionInputView.stationForRegister(scanner);
            int sequence = SectionInputView.sequenceForRegister(scanner);
            // 노선에 역이 이미 있는지 여부 검사
            // ~코드~
            SectionRepository.addSection(line, station, sequence);

            LinkedList<Station> test = LineRepository.findLine(line).getLine();// 테스트용
            test.stream().forEach(x -> System.out.println(x.getName()));

            System.out.println("[INFO] 구간이 등록되었습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            SectionMenu.openScreen(scanner);
        }
    }

    public static void removeSection(Scanner scanner) {

    }
}
