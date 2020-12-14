package subway.feature;

import subway.domain.*;
import subway.menu.SectionMenu;
import subway.view.OutputView;
import subway.view.SectionInputView;

import java.util.Scanner;

public class SectionFeature {
    public static void registerSection(Scanner scanner) {
        try {
            String line = SectionInputView.line(scanner);
            String station = SectionInputView.station(scanner);
            int sequence = SectionInputView.sequence(scanner);

            SectionRepository.addSection(line, station, sequence);

            System.out.println("[INFO] 구간이 등록되었습니다.");
        } catch (NumberFormatException e) {
            System.err.println("[ERROR] 순서로 입력된 값은 숫자여야 합니다.");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            SectionMenu.openScreen(scanner);
        }
    }

    public static void removeSection(Scanner scanner) {
        try {
            String line = SectionInputView.line(scanner);
            String station = SectionInputView.station(scanner);

            removeSection(SectionRepository.deleteSection(line, station));

            System.out.println("[INFO] 구간이 삭제되었습니다.");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            SectionMenu.openScreen(scanner);
        }
    }

    private static void removeSection(boolean success) {
        if (!success) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 구간입니다.");
        }
    }

    public static void showMap() {
        System.out.println("## 지하철 노선도");
        LineRepository.lines().stream()
                .forEach(line -> OutputView.printStationsByLine(line));
        System.out.println();
    }
}
