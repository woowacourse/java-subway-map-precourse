package subway.controller;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;
import java.util.List;

public class StationController {
    private static StationController stationController = null;
    private final Scanner scanner;

    private StationController(Scanner scanner){
        this.scanner = scanner;
    }

    public static StationController getInstance(Scanner scanner){
        if(stationController == null){
            return new StationController(scanner);
        }
        return stationController;
    }

    public void addStation(){
        OutputView.printMsg("## 등록할 역 이름을 입력하세요.\n");
        String name = InputView.getInput(scanner);
        StationRepository.addStation(new Station(name));
        OutputView.printInfoMsg("지하철 역이 등록되었습니다.");
    }
}
