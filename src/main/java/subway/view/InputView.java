package subway.view;


import static subway.view.InputView.InputMessage.ADD_STATION;
import static subway.view.InputView.InputMessage.GET_INPUT;
import static subway.view.InputView.InputMessage.MAIN_OPTION;
import static subway.view.InputView.InputMessage.REMOVE_STATION;
import static subway.view.InputView.InputMessage.STATION_OPTION;

import java.util.Scanner;
import subway.domain.MainOption;
import subway.domain.Station;
import subway.domain.StationOption;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public MainOption readMainOption() {
        System.out.println(MAIN_OPTION.getMessage());
        System.out.println(GET_INPUT.getMessage());
        return MainOption.of(scanner.nextLine());
    }

    public StationOption readStationOption() {
        System.out.println(STATION_OPTION.getMessage());
        return StationOption.of(scanner.nextLine());
    }

    public Station readAddStation() {
        System.out.println(ADD_STATION.getMessage());
        return new Station(scanner.nextLine());
    }

    public Station readRemoveStation() {
        System.out.println(REMOVE_STATION.getMessage());
        return new Station(scanner.nextLine());
    }

    protected enum InputMessage {
        MAIN_OPTION("## 메인 화면\n"
                + "1. 역 관리\n"
                + "2. 노선 관리\n"
                + "3. 구간 관리\n"
                + "4. 지하철 노선도 출력\n"
                + "Q. 종료\n"),
        STATION_OPTION("## 역 관리 화면\n"
                + "1. 역 등록\n"
                + "2. 역 삭제\n"
                + "3. 역 조회\n"
                + "B. 돌아가기"),
        GET_INPUT("## 원하는 기능을 선택하세요."),
        ADD_STATION("## 등록할 역 이름을 입력하세요."),
        REMOVE_STATION("## 삭제할 역 이름을 입력하세요."),
        ;

        private final String message;

        InputMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
