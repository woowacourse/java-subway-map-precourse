package subway;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.menu.MainMenu;
import subway.view.MainInputView;

import java.util.Scanner;

public class Controller {

    private final Scanner SCANNER;
    public Controller(Scanner scanner) {
        this.SCANNER = scanner;
    }

    public void run() {
        initialize();
        String mainMenuInput = "";

        do {
            mainMenuInput = MainInputView.mainMenu(SCANNER);
            MainMenu.select(mainMenuInput).moveView(SCANNER);
        } while (MainMenu.canContinue(mainMenuInput));

    }

    // 사전 등록 정보로 초기 설정
    private void initialize() {
        StationRepository.addStation(new Station("교대역"));
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("역삼역"));
        StationRepository.addStation(new Station("남부터미널역"));
        StationRepository.addStation(new Station("양재역"));
        StationRepository.addStation(new Station("양재시민의숲역"));
        StationRepository.addStation(new Station("매봉역"));
    }

}
