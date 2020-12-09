package subway.controller;

import java.util.Scanner;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exception.SubwayCustomException;
import subway.view.InputView;
import subway.view.OutputView;

/**
 * 역, 노선, 구간을 관리(등록, 삭제, 조회)하는 클래스
 */
public class Management {

    private final InputView inputView;

    public Management(Scanner scanner) {
        inputView = new InputView(scanner);
    }

    public void manageStation() {
        OutputView.showStationMenu();
        String input = inputView.inputValue();

        if (input.equals("1")) {
            OutputView.guideInputStation();
            StationRepository.addStation(new Station(inputView.inputValue()));
            OutputView.doneInsertStation();
            return;
        }
        if (input.equals("2")) {
            OutputView.guideRemoveStation();
            StationRepository.deleteStation(inputView.inputValue());
            OutputView.doneRemoveStation();
            return;
        }
        if (input.equals("3")) {
            OutputView.showStationList(StationRepository.stations());
            return;
        }
        if (input.equals("B")) {
            return;
        }
        throw new SubwayCustomException("없는 선택사항입니다.");
    }

    public void manageLine() {
    }

    public void mangeSection() {
    }

}
