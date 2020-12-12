package subway.view.menu;

import subway.DuplicationException;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class StationMenu {
    public static void print() {
        OutputView.printStationMenu();
        String selection = InputView.receiveMenu("Station");

        if (selection.equals("1")) {
            registerNewStation();
            return;
        }
        if (selection.equals("2")) {
            // 역 삭제
            return;
        }
        if (selection.equals("3")) {
            // 역 조회
            return;
        }
        if (selection.equals("B")) {
            MainMenu.print();
            return;
        }
    }

    private static void registerNewStation() {
        System.out.println("\n## 등록할 역 이름을 입력하세요.");
        try {
            String name = InputView.receiveStationName();
            validateDuplication(name);
            StationRepository.addStation(new Station(name));
        } catch (DuplicationException e) {
            System.out.println(e.getMessage());
            registerNewStation();
        }
    }
    
    private static void validateDuplication(String name) {
        if (StationRepository.isDuplication(name)) {
            throw new DuplicationException("\n[ERROR] 이미 등록된 역 이름입니다.");
        }
    }
}
