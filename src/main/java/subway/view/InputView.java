package subway.view;

import java.util.Scanner;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.option.MainOption;
import subway.domain.option.StationOption;

public class InputView {
    Scanner scanner = new Scanner(System.in);
    private static final InputView instance = new InputView();

    public static InputView getInstance() {
        return instance;
    }

    private InputView() {
    }

    // static이면 이 위에 지우고 아래를 static으로 만들면됨

    public MainOption readMainOption() {
        try {
            System.out.println(Message.INPUT_OPTION.message);
            return MainOption.from(scanner.next());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return readMainOption();
        }
    }

    public StationOption readStationOption() {
        try {
            System.out.println(Message.INPUT_OPTION.message);
            return StationOption.from(scanner.next());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return readStationOption();
        }
    }

    public Station readStationToRegister() {
        System.out.println(Message.INPUT_REGISTER_STATION_NAME.message);
        String newStationName = scanner.next();
        StationRepository.validateDuplicatedStationName(newStationName);
        return new Station(newStationName);
    }

    public String readStationToDelete() {
        System.out.println(Message.INPUT_DELETE_STATION_NAME.message);
        return scanner.next();
    }

    private enum Message {
        INPUT_OPTION("## 원하는 기능을 선택하세요."),
        INPUT_REGISTER_STATION_NAME("## 등록할 역 이름을 입력하세요."),
        INPUT_DELETE_STATION_NAME("## 삭제할 역 이름을 입력하세요."),
        INPUT_REGISTER_LINE_NAME("## 등록할 노선 이름을 입력하세요."),
        INPUT_UPSTREAM_ENDPOINT_STATION_NAME("## 등록할 노선의 상행 종점역 이름을 입력하세요."),
        INPUT_DOWNSTREAM_ENDPOINT_STATION_NAME("## 등록할 노선의 하행 종점역 이름을 입력하세요."),
        INPUT_STATION("## 역이름을 입력하세요."),
        INPUT_ORDER("## 순서를 입력하세요."),
        INPUT_DELETE_SECTION_LINE("## 삭제할 구간의 노선을 입력하세요."),
        INPUT_DELETE_SECTION_STATION("## 삭제할 구간의 역을 입력하세요.");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
