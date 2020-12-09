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

    private final OutputView outputView = new OutputView();
    private final Scanner scanner;
    private final InputView inputView;

    public Management(Scanner scanner) {
        this.scanner = scanner;
        inputView = new InputView(scanner);
    }

    public void manageStation(String input) {
        input = inputView.chooseLineOrStationMenu(input);
        if (input.equals("1")) {
            StationRepository.addStation(new Station(inputView.insertNewStation()));
            outputView.doneInsertStation();
            return;
        }
        if (input.equals("2")) {

        }
        if (input.equals("3")) {

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
