package subway.view;


import static subway.exception.ExceptionMessage.INVALID_ADD_SECTION_STATION_INDEX;
import static subway.view.InputView.InputMessage.ADD_LINE;
import static subway.view.InputView.InputMessage.ADD_LINE_ASCENDING_STATION;
import static subway.view.InputView.InputMessage.ADD_LINE_DESCENDING_STATION;
import static subway.view.InputView.InputMessage.ADD_SECTION_LINE;
import static subway.view.InputView.InputMessage.ADD_SECTION_STATION;
import static subway.view.InputView.InputMessage.ADD_SECTION_STATION_INDEX;
import static subway.view.InputView.InputMessage.ADD_STATION;
import static subway.view.InputView.InputMessage.DELETE_LINE;
import static subway.view.InputView.InputMessage.GET_INPUT;
import static subway.view.InputView.InputMessage.LINE_OPTION;
import static subway.view.InputView.InputMessage.MAIN_OPTION;
import static subway.view.InputView.InputMessage.REMOVE_SECTION_LINE;
import static subway.view.InputView.InputMessage.REMOVE_SECTION_STATION;
import static subway.view.InputView.InputMessage.REMOVE_STATION;
import static subway.view.InputView.InputMessage.SECTION_OPTION;
import static subway.view.InputView.InputMessage.STATION_OPTION;

import java.util.Scanner;
import subway.controller.MainOption;
import subway.controller.line.LineOption;
import subway.controller.section.SectionOption;
import subway.controller.station.StationOption;
import subway.domain.Station;

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

    public LineOption readLineOption() {
        System.out.println(LINE_OPTION.getMessage());
        System.out.println(GET_INPUT.getMessage());
        return LineOption.of(scanner.nextLine());
    }

    public String readAddLine() {
        System.out.println(ADD_LINE.getMessage());
        return scanner.nextLine();
    }

    public Station readAscendingStation() {
        System.out.println(ADD_LINE_ASCENDING_STATION.getMessage());
        return new Station(scanner.nextLine());
    }

    public Station readDescendingStation() {
        System.out.println(ADD_LINE_DESCENDING_STATION.getMessage());
        return new Station(scanner.nextLine());
    }

    public String readRemoveLine() {
        System.out.println(DELETE_LINE.getMessage());
        return scanner.nextLine();
    }

    public SectionOption readSectionOption() {
        System.out.println(SECTION_OPTION.getMessage());
        System.out.println(GET_INPUT.getMessage());
        return SectionOption.of(scanner.nextLine());
    }

    public String readAddSectionLine() {
        System.out.println(ADD_SECTION_LINE.getMessage());
        return scanner.nextLine();
    }

    public Station readAddSectionStation() {
        System.out.println(ADD_SECTION_STATION.getMessage());
        return new Station(scanner.nextLine());
    }

    public int readAddSectionIndex() {
        System.out.println(ADD_SECTION_STATION_INDEX.getMessage());
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_ADD_SECTION_STATION_INDEX.getMessage());
        }
    }

    public String readRemoveSectionLine() {
        System.out.println(REMOVE_SECTION_LINE.getMessage());
        return scanner.nextLine();
    }

    public Station readRemoveSectionStation() {
        System.out.println(REMOVE_SECTION_STATION.getMessage());
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
        LINE_OPTION("## 노선 관리 화면\n"
                + "1. 노선 등록\n"
                + "2. 노선 삭제\n"
                + "3. 노선 조회\n"
                + "B. 돌아가기"),
        SECTION_OPTION("## 구간 관리 화면\n"
                + "1. 구간 등록\n"
                + "2. 구간 삭제\n"
                + "B. 돌아가기"),
        GET_INPUT("## 원하는 기능을 선택하세요."),
        ADD_STATION("## 등록할 역 이름을 입력하세요."),
        REMOVE_STATION("## 삭제할 역 이름을 입력하세요."),
        ADD_LINE("## 등록할 노선 이름을 입력하세요."),
        ADD_LINE_ASCENDING_STATION("## 등록할 노선의 상행 종점역 이름을 입력하세요."),
        ADD_LINE_DESCENDING_STATION("## 등록할 노선의 하행 종점역 이름을 입력하세요."),
        DELETE_LINE("## 삭제할 노선 이름을 입력하세요."),
        ADD_SECTION_LINE("## 노선을 입력하세요."),
        ADD_SECTION_STATION("## 역을 입력하세요."),
        ADD_SECTION_STATION_INDEX("## 순서를 입력하세요."),
        REMOVE_SECTION_LINE("## 삭제할 구간의 노선을 입력하세요."),
        REMOVE_SECTION_STATION("## 삭제할 구간의 역을 입력하세요."),
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
