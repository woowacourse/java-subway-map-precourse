package subway.feature;

import subway.domain.*;
import subway.menu.SectionMenu;
import subway.menu.StationMenu;
import subway.view.OutputView;
import subway.view.SectionInputView;

import java.util.LinkedList;
import java.util.Scanner;

public class SectionFeature {
    public static void registerSection(Scanner scanner) {
        try {
            String line = SectionInputView.lineToRegister(scanner);
            String station = SectionInputView.stationToRegister(scanner);
            int sequence = SectionInputView.sequenceToRegister(scanner);
            // 노선에 역이 이미 있는지 여부 검사
            // ~코드~
            SectionRepository.addSection(line, station, sequence);

            System.out.println("[INFO] 구간이 등록되었습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            SectionMenu.openScreen(scanner);
        }
    }

    public static void removeSection(Scanner scanner) {
        try {
            String line = SectionInputView.lineToRemove(scanner);
            String station = SectionInputView.stationToRemove(scanner);
            // 노선에 역이 이미 있는지 여부 검사
            // ~코드~
            SectionRepository.deleteSection(line, station);

            System.out.println("[INFO] 구간이 삭제되었습니다.");

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            SectionMenu.openScreen(scanner);
        }
    }

    public static void showMap() {
        System.out.println("## 지하철 노선도");
        LineRepository.lines().stream()
                .forEach(line -> OutputView.printStationsByLine(line));
        System.out.println();
    }
}
